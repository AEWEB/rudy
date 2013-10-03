package rudy.common;

import java.util.ArrayList;

import android.util.Log;
import android.widget.TextView;

public class Logs {
	public static ArrayList<String> log=new ArrayList<String>();
	
	public static void push(String message){
		log.add(message);
	}
	public static void output(){
		
		StringBuffer br=new StringBuffer("log:\r\n");
		for(int i=0;i<log.size();i++){
			br.append(log.get(i)+"\r\n");
		}
		Log.i("logs",br.toString());
		log.clear();
		
	}
}
