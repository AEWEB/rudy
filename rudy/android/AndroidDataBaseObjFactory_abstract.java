package rudy.android;
import android.database.sqlite.SQLiteDatabase;
import rudy.common.Logs;
/**
 * 
 * モデルの基本となるクラス。
 * テーブルごとに継承する。
 */
abstract public class AndroidDataBaseObjFactory_abstract {

	/**
	 *SQL文のWhere文の部分
	 */
	private String where;

	/**
	 * SQL文のカラム部分
	 */
	private String column;

	/**
	 * SQL文のupdate文の部分
	 */
	private String updateValue;

	/**
	 *  sql文生成の対象のとなるオブジェクト
	 */
	private Object target;

	public final static String interger = "integer";
	public final static String primary = "primary key";
	public final static String autoincrement = "autoincrement";
	public final static String text="text";
	public final static String notNULL = "not null";

	/**
	 *  initメソッドが呼ばれる
	 */
		public AndroidDataBaseObjFactory_abstract(){
			init();
		}

		/**
		 *  初期化処理
		 */
		public void init(){
			setWhere("");
			setColumn("*");
		}

	/**
	 *insertのクエリーを実行
	 */
		public boolean insert(AndroidDB_runnable obj){
			return obj.runQuery(
				"insert into "+getTable()+" ("+getColumn()+") values("+getInsertValues()+")");
		}
		/**
		 *updateのクエリーを実行
		 */
		public boolean update(AndroidDB_runnable obj){
			return obj.runQuery(
				"update "+getTable()+" set "+getUpdateValue()+getWhere());
		}
		/**
		 *deleteのクエリーを実行
		 */
		public boolean delete(AndroidDB_runnable obj){
			return obj.runQuery(
				"delete from "+getTable()+getWhere());
		}
		/**
		 *テーブルを作成
		 */
		public void createTable(Object obj){
			SQLiteDatabase db=(SQLiteDatabase) obj;
			Logs.push("create table "+getTable()+" ("+getCreateTableValues()+")");
			db.execSQL("create table "+getTable()+" ("+getCreateTableValues()+")");
		}
		/**
		 *select文を実行
		 */
		public Object select(AndroidDB_runnable obj){
			Logs.push("select "+getColumn()+" from "+getTable()+getWhere());
			return obj.select(
				"select "+getColumn()+" from "+getTable()+getWhere());
		}

		/**
		 *テーブル名を取得
		 */
		abstract protected String getTable();
		/**
		 *insertする値のsql文を取得
		 */
		abstract protected String getInsertValues();
		/**
		 *テーブルを作成をするsql文を取得
		 */
		abstract protected String getCreateTableValues();		

		/**
		 *WHERE句をセット
		 */
		public void setWhere(String where) {
			this.where = where;
		}
		/**
		 *WHERE句を取得
		 */
		public String getWhere() {
			return where;
		}
		/**
		 *射影をセット
		 */
		public void setColumn(String column) {
			this.column = column;
		}
		/**
		 *射影を取得
		 */
		public String getColumn() {
			return column;
		}
		/**
		 *updateするsql文をセット
		 */
		protected void setUpdateValue(String updateValue) {
			this.updateValue = updateValue;
		}
		/**
		 *updateする値のsql文を取得
		 */
		protected String getUpdateValue() {
			return updateValue;
		}
		/**
		 *targetをセット
		 */
		public void setTarget(Object target) {
			this.target = target;
		}
		/**
		 *targetを取得
		 */
		public Object getTarget() {
			return target;
		}
		/**
		 *date形のカラム名
		 */
		protected String getCreateCulum_datetime(){
			return "text";
		}
		/**
		 *外部キーを設定するsql文を取得
		 *@param culum カラム名
		 *@param referens　親テーブル
		 *@param r_culum　対象テーブル
		 */
		protected String getCreateCulum_foreignKey(
			String culum,String referens,String r_culum){
			return "FOREIGN KEY("+culum+") REFERENCES "+referens+"("+r_culum+")";
		}
		/**
		 *date型のsql文を生成する
		 */
		protected String parseDate(String value){
			return "date("+value+",'+9 hours','utc')";
			//return "date("+value+",'localtime')";
		}
		/**
		 *datetime型のsql文を生成する
		 */
		protected String parseDateTime(String value){
			return "datetime("+value+",'+9 hours','utc')";
			//return "date("+value+",'localtime')";
		}


}