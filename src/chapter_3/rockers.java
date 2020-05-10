/*
ID: philip61
TASK: rockers
LANG: JAVA
 */
package chapter_3;
import java.util.*;
import java.io.*;
public class rockers {
	private static int N, T, M;
	public static void main(String[] args) throws IOException{
		BufferedReader f = new BufferedReader(new FileReader("rockers.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("rockers.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		N=Integer.parseInt(st.nextToken());
		T=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		ArrayList<Integer> len = new ArrayList<Integer>();
		st=new StringTokenizer(f.readLine());
		for(int i = 0; i < N; i++) {
			int x=Integer.parseInt(st.nextToken());
			if(x<=T)
				len.add(x);
		}
		if(len.size()<=M) 
			out.println(len.size());
		else
		out.println(solve(0,len,0,M));
		f.close();
		out.close();
	}
	private static int solve(int index, ArrayList<Integer> len, int curT, int curM) {
		if(index>=len.size()||curM==0)
			return 0;
		if(len.size()-index<curM) {
			return len.size()-index;
		}
		if(len.get(index)+curT>T) {
			if(curM==1) {
				return solve(index+1,len,curT,1);
			}
			int a = solve(index+1,len,curT,curM);
			int b = solve(index+1,len,len.get(index),curM-1);
			return Math.max(a,b+1);
		}
		int a = solve(index+1,len,curT,curM);
		int b = solve(index+1,len,curT+len.get(index),curM)+1;
		return Math.max(a, b);
	}
}
