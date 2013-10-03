package rudy.android;

import android.database.Cursor;
/**
 * データベースへのインタフェースとなるクラス
 */
public interface AndroidDB_runnable{
	/**
	 * 選択を実行
	 */
	public Cursor select(String sql); 
	/**
	 * クエリーを実行
	 */
	public boolean runQuery(String query);
	/**
	 * 接続をクローズする
	 */
	public void dbClose();
	/**
	 *　トランザクションを開始する
	 */
	public void rock();
	/**
	 *　コミットする
	 */
	public boolean commit();
	/**
	 *　ロールバック
	 */
	public void back();	
	
}