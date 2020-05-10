/*
ID: philip61
TASK: spin
LANG: JAVA
 */
package chapter_3;
import java.util.*;
import java.io.*;
public class spin {
	public static void main(String[] args) throws IOException{
		BufferedReader f = new BufferedReader(new FileReader("spin.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("spin.out")));
		Wheel[] ws = new Wheel[5];
		for(int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(f.readLine());
			int a=Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int[] s = new int[N];
			int[] e = new int[N];
			for(int j = 0; j < N; j++) {
				s[j]=Integer.parseInt(st.nextToken());
				e[j]=(Integer.parseInt(st.nextToken()))%360;
			}
			ws[i] = new Wheel(a,N,s,e);
		}
		int[] open=new int[360];
		for(int i = 0; i <= 357; i++) {
			Arrays.fill(open, 0);
			for(int j = 0; j < 5; j++) {
				int change = ws[j].v*i;
				for(int k = 0; k < ws[j].w; k++) {
					System.out.println((ws[j].start[k]+change)%360+" to "+(ws[j].ext[k]+change+ws[j].start[k])%360);
					System.out.println(ws[j].start[k]);
					System.out.println(ws[j].ext[k]);
					for(int a = ws[j].start[k]+change; a <= ws[j].start[k]+ws[j].ext[k]+change; a++) {
						if(++open[a%360]==5) {
							out.println(i);
							out.close();
							System.exit(0);
						}
					}
				}
			}
		}
		out.println("none");
		out.close();
	}
}
class Wheel{
	public int w,v;
	public int[] start=new int[5];
	public int[] ext = new int[5];
	public Wheel(int a, int b, int[] d, int[] e) {
		w=b;
		v=a;
		start=d;
		ext=e;
	}
}
