package test.rudy.common;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import rudy.common.StringHandle;

import junit.framework.TestCase;

public class StringHandleTest extends TestCase {
	/**
	 *配列が結合されているか
	 */
	public void testImplode(){
		ArrayList<String> array=new ArrayList<String>();
		array.add("test");
		array.add("String");
		array.add("handle");
		String option="op";
		assertEquals(array.get(0)+option+array.get(1)+option+array.get(2),
				StringHandle.implode(array, option));
	}
	/**
	 *文字数チェック
	 *@param startNum 最小値
	 *@param endNum　最大値
	 *@param value　値
	 *@param language　エラーの言語
	 */
	public void testIsExamineNum(){
		int min=5;
		int max=12;
		assertEquals(
			max+StringHandle.pleaseValueBelow[0],
			StringHandle.isExamineNum(min,max,13,0));
		assertEquals(
			min+StringHandle.pleaseValueGreater[0],
			StringHandle.isExamineNum(min,max,4,0));
		assertEquals(
			max+StringHandle.pleaseValueBelow[1],
			StringHandle.isExamineNum(min,max,13,1));
		assertEquals(
			min+StringHandle.pleaseValueGreater[1],
			StringHandle.isExamineNum(min,max,4,1));
		assertNull(StringHandle.isExamineNum(min,max,5,0));
		assertNull(StringHandle.isExamineNum(min,max,12,0));
		assertNull(StringHandle.isExamineNum(min,max,6,0));
		assertNull(StringHandle.isExamineNum(min,max,7,0));
	}
	/**
	 *文字数チェック
	 *@param startNum 最小値
	 *@param endNum　最大値
	 *@param value　値
	 *@param language　エラーの言語
	 */
	public void testIsLengthCheck(){
		int min=3;
		int max=8;
		assertEquals(
			max+StringHandle.pleaseLengBelow[0],
			StringHandle.isLengthCheck(min,max,"あああああああああ",0));
		
		assertEquals(
			min+StringHandle.pleaseLengthGreater[0],
			StringHandle.isLengthCheck(min,max,"ああ",0));
			
		assertEquals(
			max+StringHandle.pleaseLengBelow[1],
			StringHandle.isLengthCheck(min,max,"あああああああああ",1));
		assertEquals(
			min+StringHandle.pleaseLengthGreater[1],
			StringHandle.isLengthCheck(min,max,"ああ",1));
		
		assertNull(StringHandle.isLengthCheck(min,max,"あああ",0));
		assertNull(StringHandle.isLengthCheck(min,max,"ああああああああ",0));
		assertNull(StringHandle.isLengthCheck(min,max,"ああああ",0));
		assertNull(StringHandle.isLengthCheck(min,max,"あああああああ",0));
		
	}
}
