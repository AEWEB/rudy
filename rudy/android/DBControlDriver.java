package rudy.android;

import android.database.sqlite.SQLiteDatabase;
/**
 * DB側からControlへのドライバー
 */
public interface DBControlDriver {
	/**
	 * アプリケーションがインストールされた時に呼び出される
	 */
	public void setupApp(SQLiteDatabase db);
	/**
	 * アプリケーションが更新された時に呼び出される
	 */
	public void updateApp(SQLiteDatabase db);
}
