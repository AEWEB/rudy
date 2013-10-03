package test.rudy.android;

import rudy.android.AndroidJoinDBObjFactory_abstract;
import rudy.android.JoinDBObjFactory_runnable;
import android.database.Cursor;
import junit.framework.TestCase;
class JoinDBObjFactory_runnableMock implements JoinDBObjFactory_runnable{

	public String getJoinTable() {
		return "joinTable";
	}

	public String getJoinCulum() {
		// TODO Auto-generated method stub
		return "joinColum";
	}

	public void setJoinCulum(String joinCulum) {
		// TODO Auto-generated method stub
		
	}

	public Object craeteJoinObj(Cursor cursor) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getColumObj() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
class AndroidJoinDBObjFactory_abstractMock extends AndroidJoinDBObjFactory_abstract{
	
	public final static String usualTable="test";
	
	public AndroidJoinDBObjFactory_abstractMock(
			JoinDBObjFactory_runnable joinDBFactory) {
		super(joinDBFactory);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected String getUsualTable() {
		return usualTable;
	}

	@Override
	protected String getUsualTable_as() {
		// TODO Auto-generated method stub
		return "tes";
	}

	@Override
	protected String getJoinTable_as() {
		// TODO Auto-generated method stub
		return "tes2";
	}

	@Override
	protected String getUsualJoinCulum() {
		return "testColum";
	}

	@Override
	protected String getInsertValues() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String getCreateTableValues() {
		// TODO Auto-generated method stub
		return null;
	}
	
	//mock methid
	public void setupJoin_test(String join){
		setupJoin(join);
	}
	public String getTable_test(){
		return getTable();
	}
	
}
public class AndroidJoinDBObjFactory_abstractTest extends TestCase {
	
		//process
			public void testSetupJoin(){
				/*
				setTable(getUsualTable()+" "+getUsualTable_as()+" "+join+" join "+
					getJoinDBFactory().getJoinTable()+" "+getJoinTable_as()+" on "+
					getUsualTable_as()+"."+getUsualJoinCulum()+"="+
					getJoinTable_as()+"."+getJoinDBFactory().getJoinCulum());
					*/
				JoinDBObjFactory_runnableMock joinTestMock=new JoinDBObjFactory_runnableMock();
				AndroidJoinDBObjFactory_abstractMock test=new AndroidJoinDBObjFactory_abstractMock(
					joinTestMock);
				String join=AndroidJoinDBObjFactory_abstract.innerJoin;
				test.setupJoin_test(join);
				assertEquals(test.getTable_test(),
					test.getUsualTable()+" "+test.getUsualTable_as()+" "+join+" join "+
					joinTestMock.getJoinTable()+" "+test.getJoinTable_as()+" on "+
					test.getUsualTable_as()+"."+test.getUsualJoinCulum()+"="+
					test.getJoinTable_as()+"."+joinTestMock.getJoinCulum());
			}
			public void testInit(){
				JoinDBObjFactory_runnableMock joinTestMock=new JoinDBObjFactory_runnableMock();
				AndroidJoinDBObjFactory_abstractMock test=new AndroidJoinDBObjFactory_abstractMock(
					joinTestMock);
				test.init();
				assertEquals(test.getTable_test(),AndroidJoinDBObjFactory_abstractMock.usualTable);
				assertEquals(test.getColumn(),"*");
				assertEquals(test.getWhere(),"");
			}
			
}
