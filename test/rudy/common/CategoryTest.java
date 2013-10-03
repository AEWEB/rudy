package test.rudy.common;


import junit.framework.TestCase;

public class CategoryTest extends TestCase {
	public void testName() {
	     String name="cat";
	     Category cateogry=new Category(0, null);
	     cateogry.setName(name);
	    assertEquals(name,cateogry.getName());
	}
	public void testId() {
	     int id=13;
	     Category cateogry=new Category(0, null);
	     cateogry.setId(id);
	     assertEquals(id,cateogry.getId());
	}
}
