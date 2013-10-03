package rudy.android;

import rudy.common.Logs;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
/**
 * データベースへのインタフェースとなるクラス
 */
public class AndroidDB extends SQLiteOpenHelper implements AndroidDB_runnable{
	/**
	 *　書き込み用db
	 */
	private SQLiteDatabase transactionDb;
	/**
	 *　読み込み用DB
	 */
	private SQLiteDatabase readDb;
	
	/**
	 *　コントロールへのドライバー
	 */
	private DBControlDriver controlDriver;
	
	//constructor
		public AndroidDB(Context context, String name, CursorFactory factory,int version,DBControlDriver controlDriver) {
			super(context, name, factory, version);
			this.controlDriver=controlDriver;
			setTransactionDb(getWritableDatabase());
			this.setReadDb(getReadableDatabase());
		}

	//override
		//---SQLiteOpenHelper
		@Override
		public void onCreate(SQLiteDatabase db) {
			Logs.push("onCreate");
			getControlDriver().setupApp(db);
		}
		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			getControlDriver().updateApp(db);
		}
		
	/**
	 *　トランザクションを終了する
	 */
	protected void endTransaction(){
		getTransactionDb().endTransaction();
	}
	/**
	 * 選択を実行
	 */
	public Cursor select(String sql){
		return getReadDb().rawQuery(sql,null);
	}
	/**
	 * クエリーを実行
	 */
	public boolean runQuery(String query){
		boolean result=true;
		try{
			Logs.push(query);
			getTransactionDb().execSQL(query);
		}catch (SQLException e) {
			Logs.push(e.toString()+" /error");
			result=false;
		}
		return result;
	}
	/**
	 *　トランザクションを開始する
	 */
	public void rock(){
		getTransactionDb().beginTransaction();
	}
	/**
	 *　コミットする
	 */
	public boolean commit(){
		boolean result=true;
		try{
			getTransactionDb().setTransactionSuccessful();
		}catch (SQLException e) {
			result=false;
		}finally{
			endTransaction();
		}
		return result;
	}
	/**
	 *　ロールバック
	 */
	public void back(){
		endTransaction();
	}
	/**
	 *　読み込み用DBを取得
	 */
	protected SQLiteDatabase getReadDb() {
		return readDb;
	}
	/**
	 *　読み込み用DBをセット
	 */
	protected void setReadDb(SQLiteDatabase readDb) {
		this.readDb = readDb;
	}
	/**
	 *　書き込み用DBを取得
	 */
	protected SQLiteDatabase getTransactionDb(){
		return this.transactionDb;
	}
	/**
	 *　書き込み用DBをセット
	 */
	protected void setTransactionDb(SQLiteDatabase transactionDb){
		this.transactionDb=transactionDb;
	}

	/**
	 * 接続をクローズする
	 */
	public void dbClose() {
		getReadDb().close();
		getTransactionDb().close();
	}
	protected DBControlDriver getControlDriver(){
		return controlDriver;
	}
	protected void setControlDriver(DBControlDriver controlDriver) {
		this.controlDriver=controlDriver;
	}
	
		
}
