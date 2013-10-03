package rudy.android;

/**
 * 結合演算用テーブル
 */
abstract public class AndroidJoinDBObjFactory_abstract extends AndroidDataBaseObjFactory_abstract{
	/**
	 * テーブル
	 */
	private String table;
	/**
	 * 結合するテーブルのオブジェクト
	 */
	private JoinDBObjFactory_runnable joinDBFactory;
		
	//static
		public final static String innerJoin="inner";
		public final static String leftJoin="left";
		public final static String nullWord="NULL";
		
		/**
		 * constructor
		 */
		public AndroidJoinDBObjFactory_abstract(JoinDBObjFactory_runnable joinDBFactory){
			super();
			this.joinDBFactory=joinDBFactory;
		}
		
		/**
		 * 通常テーブル
		 */
		abstract protected String getUsualTable();
		/**
		 * 通常テーブル別名
		 */
		abstract protected String getUsualTable_as();
		/**
		 * 結合テーブル別名
		 */
		abstract protected String getJoinTable_as();
		/**
		 * 通常テーブル結合カラム
		 */
		abstract protected String getUsualJoinCulum();
		
		
		/**
		 * 通常テーブル結合カラム
		 */
		protected void setupJoin(String join){
			setTable(getUsualTable()+" "+getUsualTable_as()+" "+join+" join "+
				getJoinDBFactory().getJoinTable()+" "+getJoinTable_as()+" on "+
				getUsualTable_as()+"."+getUsualJoinCulum()+"="+
				getJoinTable_as()+"."+getJoinDBFactory().getJoinCulum());
		}
		
		/**
		 * 初期化処理
		 */
		public void init(){
			super.init();
			setTable(getUsualTable());
		}
		
	//implementention
		/**
		 * 通常テーブル
		 */
		protected String getTable(){
			return table;
		}
		
	//getter and setter
		/**
		 * 通常テーブル
		 */
		protected void setTable(String table){
			this.table=table;
		}
		public void setJoinDBFactory(JoinDBObjFactory_runnable joinDBFactory) {
			this.joinDBFactory = joinDBFactory;
		}
		public JoinDBObjFactory_runnable getJoinDBFactory() {
			return joinDBFactory;
		}		
}
