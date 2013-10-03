package rudy.android;
/**
 * モデルのクラス
 */
public interface DataBaseObjFactory {
	/**
	 * 挿入
	 */
	public boolean insert(AndroidDB_runnable obj);
	/**
	 * 更新
	 */
	public boolean update(AndroidDB_runnable obj);
	/**
	 * 選択
	 */
	public Object select(AndroidDB_runnable obj);
	/**
	 * 消去
	 */
	public boolean delete(AndroidDB_runnable obj);
	/**
	 * 初期化処理
	 */
	public void init();
	/**
	 * オブジェクトを作成
	 */
	public Object createObj(Object object);
	/**
	 * ターゲットを取得
	 */
	public Object getTarget();
	/**
	 * テーブルを作成
	 */
	public void createTable(Object obj);
	/**
	 * ターゲットをセット
	 */
	public void setTarget(Object object);
	/**
	 *WHERE句をセット
	 */
	public void setWhere(String where);
	/**
	 *WHERE句を取得
	 */
	public String getWhere();
	/**
	 *射影をセット
	 */
	public void setColumn(String column);
	/**
	 *射影を取得
	 */
	public String getColumn() ;
	
}
