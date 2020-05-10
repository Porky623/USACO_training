/*
ID: philip61
TASK: fact4
LANG: JAVA
 */
package chapter_3;
import java.util.*;
import java.io.*;
public class fact4 {
	public static void main(String[] args) throws IOException{
		BufferedReader f = new BufferedReader(new FileReader("fact4.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("fact4.out")));
		int N = Integer.parseInt(f.readLine());
		int[] facts = new int[N+1];
		int c = 0;
		for(int i = 1; i < facts.length; i++) {
			facts[i]=i;
			while(facts[i]%5==0) {
				facts[i]/=5;
				c++;
			}
		}
		for(int i = 1; i < facts.length; i++) {
			while(facts[i]%2==0&&c>0) {
				facts[i]/=2;
				c--;
			}
		}
		int d = 1;
		for(int i = 1; i < facts.length; i++) {
			d*=facts[i]%10;
			d%=10;
		}
		out.println(d);
		out.close();
	}
}
