/*
ID: philip61
TASK: heritage
LANG: JAVA
 */
package chapter_3;
import java.util.*;
import java.io.*;
public class heritage {
	public static void main(String[] args) throws IOException{
		BufferedReader f = new BufferedReader(new FileReader("heritage.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("heritage.out")));
		String in,pre;
		in=f.readLine();
		pre=f.readLine();
		out.println(solve(in,pre));
		f.close();
		out.close();
	}
	private static String solve(String in, String pre) {
		if(in.length()==0)
			return "";
		if(in.length()==1) {
			return in;
		}
		if(in.length()==2) {
			StringBuilder s = new StringBuilder();
			s.append(pre.charAt(1));
			s.append(pre.charAt(0));
			return s.toString();
		}
		char root = pre.charAt(0);
		int i;
		for(i = 0; i < in.length(); i++) {
			if(in.charAt(i)==root)
				break;
		}
		return solve(in.substring(0, i),pre.substring(1, i+1))+solve(in.substring(i+1),pre.substring(i+1))+root;
	}
}
