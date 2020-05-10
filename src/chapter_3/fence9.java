/*
ID: philip61
TASK: fence9
LANG: JAVA
 */
package chapter_3;
import java.util.*;
import java.io.*;
public class fence9 {
	private static double n,m,p;
	public static void main(String[] args) throws IOException{
		BufferedReader f = new BufferedReader(new FileReader("fence9.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("fence9.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		n=Double.parseDouble(st.nextToken());
		m=Double.parseDouble(st.nextToken());
		p=Double.parseDouble(st.nextToken());
		if(n<p)
			out.println(solve1());
		else
			out.println(solve2());
		out.close();
		f.close();
	}
	private static int solve1() {
		int count = 0;
		for(double i = 1; i <= n; i++) {
			if(m*i/n==(int)(m*i/n))
				count--;
			count+=(int)(m*i/n);
		}
		for(double i = n+1; i < p; i++) {
			if((-m*i+p*m)/(p-n)==(int)((-m*i+p*m)/(p-n)))
				count--;
			count+=(int)((-m*i+p*m)/(p-n));
		}
		return count;
	}
	private static int solve2() {
		int count = 0;
		for(double i = 1; i < n; i++) {
			if((int)(m*i/n)==m*i/n)
				count--;
			count+=(int)(m*i/n);
		}
		for(double i = p+1; i < n; i++) {
			/*if((int)((m*i-m*p)/(n-p))==(m*i-m*p)/(n-p))
				count++;*/
			count-=(int)((m*i-m*p)/(n-p));
		}
		return count;
	}
}
