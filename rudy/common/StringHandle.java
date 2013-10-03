package rudy.common;

import java.util.List;
/** 
 * 文字列を扱うクラス
 */
public class StringHandle {
	public static String newLine="\r\n";//new line
	public static String[] pleaseValueGreater={"以上の数値を入力して下さい","Enter of the or more values,please."};
	public static String[] pleaseValueBelow={"以下の数値を入力して下さい","Enter of the below values,please."};
	public static String[] pleaseLengthGreater={"文字以上の文字を入力して下さい","Enter of the or more character,please."};
	public static String[] pleaseLengBelow={"文字以下の文字を入力して下さい","Enter of the below character,please."};
	public static String[] pleaseNumberFormat={"数字で入力してください","Enter of the number,please."};
	
	/**
	 *配列を文字列に結合する
	 *@param arrayList 配列
	 *@param option　オプション
	 */
	public final static String implode(List<String> arrayList,String option){
		StringBuffer br=new StringBuffer();
		for(int i=0;i<arrayList.size();i++){
			br.append(arrayList.get(i));
			if(i!=arrayList.size()-1){
				br.append(option);
			}
		}
		return br.toString();
	}
	/**
	 *リミットチェック
	 *@param startNum 最小値
	 *@param endNum　最大値
	 *@param value　値
	 *@param language　エラーの言語
	 */
	public final static String isExamineNum(int startNum,int endNum,int value,int language){
		String error=null;
		if(value<startNum){
			error=startNum+pleaseValueGreater[language];
		}else if(value>endNum){
			error=endNum+pleaseValueBelow[language];
		}
		return error;
	}
	/**
	 *文字数チェック
	 *@param startNum 最小値
	 *@param endNum　最大値
	 *@param value　値
	 *@param language　エラーの言語
	 */
	public final static String isLengthCheck(int startNum,int endNum,String value,int language){
		String error=null;
		if(value.length()<startNum){
			error=startNum+pleaseLengthGreater[language];
		}else if(value.length()>endNum){
			error=endNum+pleaseLengBelow[language];
		}
		return error;
	}
}

