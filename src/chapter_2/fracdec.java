/*
ID: philip61
TASK: fracdec
LANG: JAVA
 */
package chapter_2;
import java.util.*;
import java.io.*;
public class fracdec {
	public static void main(String[] args) throws IOException{
		BufferedReader f = new BufferedReader(new FileReader("fracdec.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("fracdec.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int N,D;
		N=Integer.parseInt(st.nextToken());
		D=Integer.parseInt(st.nextToken());
		int in=N/D;
		N-=in*D;
		HashMap<Integer,Integer> rem = new HashMap<Integer,Integer>();
		StringBuilder sbFrac= new StringBuilder();
		String q = "";
		int i = 0;
		while(N!=0&&!rem.containsKey(N)) {
			rem.put(N, i++);
			N*=10;
			int x = (N/D);
			N-=D*x;
			sbFrac.append(x);
		}
		q=sbFrac.toString();
		if(N==0) {
			out.print(in+"."+q);
			if(q.length()==0)
				out.println("0");
			else
				out.println();
			out.close();
			System.exit(0);
		}
		StringBuilder s = new StringBuilder();
		s.append(in);
		s.append(".");
		int index = rem.get(N);
		s.append(q.substring(0, index));
		s.append('(');
		s.append(q.substring(index));
		s.append(')');
		q=s.toString();
		while(q.length()>76) {
			out.println(q.substring(0, 76));
			q=q.substring(76);
		}
		out.println(q);
		out.close();
		System.exit(0);
	}
}
