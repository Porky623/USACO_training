/*
ID: philip61
TASK: runround
LANG: JAVA
 */
package chapter_2;
import java.util.*;
import java.io.*;
public class runround {
	public static void main(String[] args) throws IOException{
		BufferedReader f = new BufferedReader(new FileReader("runround.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("runround.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int N = Integer.parseInt(st.nextToken());
		N++;
		while(!runaround(N)) {
			N++;
		}
		out.println(""+N);
		out.close();
	}
	private static boolean runaround(int x) {
		String s = ""+x;
		boolean[] dig = new boolean[10];
		dig[0]=true;
		for(int i = 1; i < 10; i++) {
			dig[i]=false;
		}
		for(int i = 0; i < s.length(); i++) {
			if(dig[(int)s.charAt(i)-(int)'0']) {
				return false;
			}
			if(((int)s.charAt(i)-(int)'0')%s.length()==0)
				return false;
			dig[(int)s.charAt(i)-(int)'0']=true;
		}
		dig=new boolean[s.length()];
		for(int i = 0; i < dig.length; i++) {
			dig[i]=false;
		}
		dig[0]=true;
		return run(s,0,dig,1);
	}
	private static boolean run(String s, int in, boolean[] dig, int a) {
		int x = (int)s.charAt(in)-(int)'0';
		int in2 = (in+x)%s.length();
		if(dig[in2]) {
			if(in2!=0)
				return false;
			if(a!=s.length())
				return false;
			return true;
		}
		dig[in2]=true;
		return run(s,in2,dig,a+1);
	}
}
