/*
ID: philip61
TASK: inflate
LANG: JAVA
 */
package chapter_3;
import java.util.*;
import java.io.*;
public class inflate {
	public static void main(String[] args) throws IOException{
		BufferedReader f = new BufferedReader(new FileReader("inflate.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("inflate.out")));
		StringTokenizer st1 = new StringTokenizer(f.readLine());
		int M=Integer.parseInt(st1.nextToken());
		int N=Integer.parseInt(st1.nextToken());
	    int[] t = new int[M+1];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(f.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			for(int j = b; j < t.length; j++) {
				if(t[j]<t[j-b]+a) {
					t[j]=t[j-b]+a;
				}
			}
		}
	    out.println(t[M]);
	    out.close();
	}
}
