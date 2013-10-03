package rudy.android;
import android.database.Cursor;
/**
 * 結合テーブル
 */
public interface JoinDBObjFactory_runnable {
	/**
	 * 結合テーブル名を取得
	 */
	public String getJoinTable();
	/**
	 * 結合するカラムを取得
	 */
	public String getJoinCulum();
	/**
	 * 結合するカラムをセット
	 */
	public void setJoinCulum(String joinCulum);
	/**
	 * 結合側のオブジェクトを生成
	 */
	public Object craeteJoinObj(Cursor cursor);
	/**
	 * カラム名を取得
	 */
	public Object getColumObj();
}
