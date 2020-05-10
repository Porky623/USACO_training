/*
ID: philip61
TASK: stamps
LANG: JAVA
 */
package chapter_3;
import java.util.*;
import java.io.*;
public class stamps {
	public static void main(String[] args) throws IOException{
		Scanner f = new Scanner(new File("stamps.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("stamps.out")));
		int K = f.nextInt();
		int N = f.nextInt();
		int[] can = new int[2000001];
		int[] vals = new int[N];
		for(int i = 0; i < N; i++) {
			vals[i]=f.nextInt();
		}
		int in = 0;
		loop:
		for(int i = 0; i < can.length; i++) {
			if(can[i]==0&&i!=0||can[i]>K){
				break loop;
			}
			for(int j = 0; j < N; j++) {
				int x = i+vals[j];
				if(x<can.length) {
					int y = can[i]+1;
					if(y<can[x]||can[x]==0) {
						can[x]=y;
					}
				}
			}
			in++;
		}
		out.println(in-1);
		out.close();
	}
}
