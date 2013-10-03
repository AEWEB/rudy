package test.rudy.android;

import rudy.android.AndroidDB_runnable;
import rudy.android.AndroidDataBaseObjFactory_abstract;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import junit.framework.TestCase;
class AndroidDataBaseObjFactory_test extends AndroidDataBaseObjFactory_abstract{

	@Override
	protected String getTable() {
		return "testTable";
	}
	@Override
	protected String getInsertValues() {
		return "testInsertValues";
	}
	@Override
	protected String getCreateTableValues() {
		// TODO Auto-generated method stub
		return "testCreateTableValues";
	}
	public void createTable(Object obj){
		AndroidDB_testMock db=(AndroidDB_testMock) obj;
		db.runQuery("create table "+getTable()+" ("+getCreateTableValues()+")");
	}
	//mock method
	protected String getTable_test() {
		return getTable();
	}
	public String getUpdateValue_test(){
		return getUpdateValue();
	}
	public void setUpdateValue_test(String updateValue){
		setUpdateValue(updateValue);
	}
	
	public String getCreateCulum_datetime_test(){
		return getCreateCulum_datetime();
	}
	public String getCreateCulum_foreignKey_test(String culum,String referens,String r_culum){
		return getCreateCulum_foreignKey(culum, referens, r_culum);
	}
	public String parseDate_test(String value){
		return parseDate(value);
	}
	public String parseDateTime_test(String value){
		return parseDateTime(value);
	}
}
class AndroidDB_testMock implements AndroidDB_runnable{
	public String query;
	public Cursor select(String sql) {
		query=sql;
		return null;
	}
	public boolean runQuery(String query) {
		this.query=query;
		System.out.println(query);
		return true;
	}
	public void dbClose() {
		// TODO Auto-generated method stub
		
	}
	public void rock() {
		// TODO Auto-generated method stub
		
	}
	public boolean commit() {
		// TODO Auto-generated method stub
		return false;
	}
	public void back() {
		// TODO Auto-generated method stub
		
	}
	
}
public class AndroidDataBaseObjFactory_abstractTest extends TestCase {
	private AndroidDataBaseObjFactory_test control=new AndroidDataBaseObjFactory_test();
	private AndroidDB_testMock db=new AndroidDB_testMock();
	
	public AndroidDataBaseObjFactory_abstractTest(){
		super();
	}
	protected void setUp(){
		control.init();
	}
	
	public void testInit(){
		assertEquals(control.getWhere(),"");
		assertEquals(control.getColumn(),"*");
	}
	public void testInsert(){
		//return obj.runQuery(
			//"insert into "+getTable()+" ("+getColumn()+") values("+getInsertValues()+")");
		control.setColumn("testColumn");
		assertTrue(control.insert(db));
		assertEquals(db.query,"insert into testTable (testColumn) values(testInsertValues)");
	}
	//setUpdateValue and getUpdateValue
	public void testUpdate(){
		control.setWhere(" testWhere");
		control.setUpdateValue_test("testUpdateValue");
		assertTrue(control.update(db));
		assertEquals(db.query,"update testTable set testUpdateValue testWhere");
	}
	public void testDelete(){
		control.setWhere(" testWhere");
		assertTrue(control.delete(db));
		assertEquals(db.query,"delete from testTable testWhere");
	}
	public void testCreateTable(){
		control.createTable(db);
		assertEquals(db.query,"create table testTable (testCreateTableValues)");
	}
	public void testSelect(){
		//return obj.select(
			//"select "+getColumn()+" from "+getTable()+getWhere());
		control.setColumn("testColumn");
		control.setWhere(" testWhere");
		control.select(db);
		assertEquals(db.query,"select "+control.getColumn()+" from "+control.getTable()+control.getWhere());
	}
	public void testSetWhere() {
		control.setWhere(" testWhere");
		assertEquals(control.getWhere(),
			" testWhere");
	}
	public void testSetColumn() {
		control.setColumn("testColumn");
		assertEquals(control.getColumn(),
				"testColumn");
	}
	public void testSetUpdateValue() {
		control.setUpdateValue_test("testUpdateValue");
		assertEquals(control.getUpdateValue_test(),
				"testUpdateValue");
	}
	
	public void testSetTarget() {
		Object a=new Object();
		control.setTarget(a);
		assertEquals(control.getTarget(),a);
	}
	public void testGetCreateCulum_datetime(){
		assertEquals(control.getCreateCulum_datetime_test(), "text");
	}
	public void testGetCreateCulum_foreignKey(){
		assertEquals(control.getCreateCulum_foreignKey_test("testColumn","referens","r_culum"), 
			"FOREIGN KEY(testColumn) REFERENCES referens(r_culum)");
	}
	public void testParseDate(){
		assertEquals(control.parseDate_test("2009-10-16"),"date(2009-10-16,'+9 hours','utc')");
	}
	public void testParseDateTime(){
		assertEquals(control.parseDateTime_test("2009-10-16 00:00:00"),"datetime(2009-10-16 00:00:00,'+9 hours','utc')");
	}
	
}
