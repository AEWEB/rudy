package rudy.common;

import java.text.SimpleDateFormat;
import java.util.Calendar;
/** 
 * 日付けを処理するクラス
 */
public class DateHandle {
	//date result index
	public final static String yearIndex="yearIndex";
	public final static String monthIndex="monthIndex";
	public final static String dateIndex="dateIndex";
	/** 
	 * 通常の日にちフォーマット
	 */
	public final static String getUsual(Calendar calender){
		return (new SimpleDateFormat("yyyy-MM-dd")).format(calender.getTime());
	}
	/** 
	 * 日本語の日にちフォーマット
	 */
	public final static String japanFormat(Calendar calender){
		return (new SimpleDateFormat("yyyy年MM月dd日")).format(calender.getTime());
	}
	/** 
	 * 日付けを処理するクラス
	 */
	public final static String dateTimeFormat(Calendar calender){
		return (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(calender.getTime());
	}
}
