package rudy.android;
import java.util.ArrayList;

import rudy.common.Logs;
import rudy.common.StringHandle;
import android.app.Activity;
import android.app.AlertDialog;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

/**
 * アクティビティーの雛形となるクラス
 */
abstract public class ActivityAbstract extends Activity implements DBControlDriver{
		
	/**
	 *　データベース
	 */
	private AndroidDB_runnable db;
	/**
	 *　システム共通データ
	 */
	private SystemCommon common;
	/**
	 *　エラーメッセージリスト
	 */
	private ArrayList<String> errorMessage_list=new ArrayList<String>();
		
	//abstract
	/**
	 *　DB名を取得
	 */
	abstract protected String getDBName();
	/**
	 *　CursorFactoryを取得
	 */
	abstract protected CursorFactory getDBFactory();
	/**
	 *　DBのversionを取得
	 */
	abstract protected int getDBVersion();
	/**
	 *　システム共通データを作成
	 */
	abstract protected void createCommon();
	
	//override
	/**
	 *　returnボタンを押された時の処理
	 */
	public void onBackPressed() {
		exitAction();
		super.onBackPressed();
	}
	
	/**
	 * 初期化処理
	 */
	protected void init(){
		createAndroidDB();
	}
	/**
	 *　DBオブジェクトを生成
	 */
	protected void createAndroidDB(){
		setDB(new AndroidDB(this,getDBName(),getDBFactory(),getDBVersion(),this));
	}
	
	/**
	 *　エラー時の処理
	 */
	protected void error(Exception e) {
		Logs.push(e.toString());
		Logs.output();
	}
	/**
	 *　ダイヤログを表示する
	 */
	protected AlertDialog.Builder createAlertDialog(String name,String massage,boolean cancelable) {
		return null; 
	}
	/**
	 *　アクション終了時の処理
	 */
	protected void exitAction(){
		getDB().dbClose();
	}
	/**
	 *　画面更新
	 */
	public void update() {
		getErrorMessage_list().clear();
	}
	
	//Validator
	/**
	* 数字かどうか調べる
	*/
	protected boolean isInt(int startNum,int endNum,String param){
		String error;
		try{
			if((error=StringHandle.isExamineNum(startNum, endNum,Integer.parseInt(param),getCommon().getLanguage()))!=null){
				setErrorMessage(error);
				return false;
			}
		}catch(NumberFormatException e){
			setErrorMessage(StringHandle.pleaseNumberFormat[getCommon().getLanguage()]);
			return false;
		}
		return true;
	}
	/**
	 *　リミットチェック
	 */
	protected boolean isLengthCheck(int startNum,int endNum,String param){
		String error;
		if((error=StringHandle.isLengthCheck(startNum, endNum, param,getCommon().getLanguage()))!=null){
			setErrorMessage(error);
			return false;
		}
		return true;
	}
	
	//getter and setter
	/**
	 *　DBオブジェクトを取得
	 */
	protected AndroidDB_runnable getDB(){
		return db;
	}
	/**
	 *　DBオブジェクトをセット
	 */
	protected void setDB(AndroidDB_runnable db){
		this.db=db;
	}
	/**
	 *　システム共通の情報を取得
	 */
	protected SystemCommon getCommon() {
		return common;
	}
	/**
	 *　システム共通の情報をセット
	 */
	protected void setCommon(SystemCommon common) {
		this.common = common;
	}
	/**
	 *　エラーメッセージを取得
	 */
	protected String getErrorMessage(){
		return StringHandle.implode(
			getErrorMessage_list(),
			StringHandle.newLine);
	}
	/**
	 *　エラーメッセージリストを取得
	 */
	protected ArrayList<String> getErrorMessage_list() {
		return errorMessage_list;
	}
	/**
	 *　エラーメッセージを追加
	 */
	protected void setErrorMessage(String errorMessage) {
		this.errorMessage_list.add(errorMessage);
	}
}
