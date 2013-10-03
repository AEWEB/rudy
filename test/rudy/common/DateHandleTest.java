package test.rudy.common;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import rudy.common.DateHandle;
import slup.activity.R.string;

import junit.framework.TestCase;

public class DateHandleTest extends TestCase {
	
	public void testGetUsual(){
		assertEquals((new SimpleDateFormat("yyyy-MM-dd")).format(Calendar.getInstance().getTime()),
			DateHandle.getUsual(Calendar.getInstance()));
	}
	public void testJapanFormat(){
		assertEquals((new SimpleDateFormat("yyyy年MM月dd日")).format(Calendar.getInstance().getTime()),
			DateHandle.japanFormat(Calendar.getInstance()));
	}
	public void testDateTimeFormat(){
		assertEquals((new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(Calendar.getInstance().getTime()),
			DateHandle.dateTimeFormat(Calendar.getInstance()));
	}
}
