/*
ID: philip61
TASK: fence6
LANG: JAVA
 */
package chapter_4;
import java.util.*;
import java.io.*;
public class fence6 {
	private static int N;
	public static void main(String[] args) throws IOException{
		BufferedReader f = new BufferedReader(new FileReader("fence6.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("fence6.out")));
		N=Integer.parseInt(f.readLine());
		End[][] ends = new End[N][2];
		for(int i = 0; i < N; i++) {
			ends[i][0]=new End(i);
			ends[i][1]=new End(i);
		}
		StringTokenizer st;
		int[] len = new int[N];
		for(int i = 0; i < N; i++) {
			st= new StringTokenizer(f.readLine());
			int x=Integer.parseInt(st.nextToken());
			len[x-1]=Integer.parseInt(st.nextToken());
			ends[x-1][0].con.add(ends[x-1][1]);
			ends[x-1][1].con.add(ends[x-1][0]);
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			st=new StringTokenizer(f.readLine());
			int q = Integer.parseInt(st.nextToken());
			End e=null;
			boolean cont=true;
			if(ends[q-1][0].con.contains(ends[x-1][0])||ends[q-1][1].con.contains(ends[x-1][0]))
				cont=false;
			else if(ends[q-1][0].con.isEmpty()) {
				e=ends[q-1][0];
			}
			else
				e=ends[q-1][1];
			ArrayList<End> list = new ArrayList<End>();
			list.add(ends[x-1][0]);
			list.add(e);
			for(int j = 1; j < a&&cont; j++) {
				q = Integer.parseInt(st.nextToken());
				if(ends[q-1][0].con.isEmpty()) {
					e=ends[q-1][0];
				}
				else
					e=ends[q-1][1];
				list.add(e);
			}
			if(cont) {
				for(int j = 0; j < a; j++) {
					for(int k = j+1; k < a; k++) {
						list.get(j).con.add(list.get(k));
						list.get(k).con.add(list.get(j));
					}
				}
			}
			st=new StringTokenizer(f.readLine());
			q = Integer.parseInt(st.nextToken());
			e=null;
			cont=true;
			if(ends[q-1][0].con.contains(ends[x-1][0])||ends[q-1][1].con.contains(ends[x-1][0]))
				cont=false;
			else if(ends[q-1][0].con.isEmpty()) {
				e=ends[q-1][0];
			}
			else
				e=ends[q-1][1];
			list = new ArrayList<End>();
			list.add(ends[x-1][1]);
			list.add(e);
			for(int j = 1; j < a&&cont; j++) {
				q = Integer.parseInt(st.nextToken());
				if(ends[q-1][0].con.isEmpty()) {
					e=ends[q-1][0];
				}
				else
					e=ends[q-1][1];
				list.add(e);
			}
			if(cont) {
				for(int j = 0; j < a; j++) {
					for(int k = j+1; k < a; k++) {
						list.get(j).con.add(list.get(k));
						list.get(k).con.add(list.get(j));
					}
				}
			}
		}
		
		f.close();
		out.close();
	}
}
class End{
	public int fence;
	public HashSet<End> con;
	public End(int f) {
		fence=f;
		con=new HashSet<End>();
	}
}