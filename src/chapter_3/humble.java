/*
ID: philip61
TASK: humble
LANG: JAVA
 */
package chapter_3;
import java.util.*;
import java.io.*;
public class humble {
	public static void main(String[] args) throws IOException{
		BufferedReader f = new BufferedReader(new FileReader("humble.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("humble.out")));
		StringTokenizer st1 = new StringTokenizer(f.readLine());
		int K = Integer.parseInt(st1.nextToken());
		int N = Integer.parseInt(st1.nextToken());
		int[] input = new int[K];
		StringTokenizer st = new StringTokenizer(f.readLine());
		for(int i = 0; i < K; i++) {
			input[i]=Integer.parseInt(st.nextToken());
		}
		int[] hum = new int[N+1];
		int[] next = new int[K];
		for(int i = 0; i < K; i++) {
			next[i]=0;
		}
		hum[0]=1;
		for(int i = 1; i <= N; i++) {
			int min = Integer.MAX_VALUE;
			for(int j = 0; j < K; j++) {
				while(next[j]<i&&input[j]*hum[next[j]]<=hum[i-1]) {
					next[j]++;
				}
				if(input[j]*hum[next[j]]<min)
					min=input[j]*hum[next[j]];
			}
			hum[i]=min;
		}
		out.println(hum[N]);
		out.close();
	}
}
