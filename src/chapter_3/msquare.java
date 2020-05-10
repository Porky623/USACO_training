/*
ID: philip61
TASK: msquare
LANG: JAVA
 */
package chapter_3;
import java.util.*;
import java.io.*;
public class msquare {
	public static void main(String[] args) throws IOException{
		BufferedReader f = new BufferedReader(new FileReader("msquare.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("msquare.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int[] target = new int[8];
		for(int i = 0; i < 8; i++) {
			target[i]=Integer.parseInt(st.nextToken());
		}
		boolean w = true;
		for(int i = 0; i < 8; i++) {
			if(target[i]!=i+1)
				w=false;
		}
		if(w) {
			out.println("0");
			out.println();
			out.close();
			System.exit(0);
		}
		HashSet<Integer> visited = new HashSet<Integer>();
		int[] temp = new int[] {1,2,3,4,5,6,7,8};
		visited.add(con(temp));
		HashMap<String,int[]> map = new HashMap<String,int[]>();
		map.put("", temp);
		Queue<String> q = new LinkedList<String>();
		q.add("");
		String p="";
		loop:
		while(visited.size()<40320) {
			String k = q.remove();
			int[] c = map.get(k);
			for(int i = 0; i < 3; i++) {
				String s = k+(char)('A'+i);
				int[] t = cube(c,s);
				boolean work = true;
				for(int j = 0; j < 8; j++) {
					if(t[j]!=target[j])
						work = false;
				}
				if(work) {
					p=s;
					break loop;
				}
				if(!visited.contains(con(t))) {
					q.add(s);
					visited.add(con(t));
					map.put(s,t);
				}
			}
		}
		out.println(p.length());
		while(p.length()>60) {
			out.print(p.substring(0, 60));
			p=p.substring(60);
		}
		out.println(p);
		out.close();
	}
	private static int[] cube(int[] start, String s) {
		char c = s.charAt(s.length()-1);
		int[] end = new int[8];
		if(c=='A') {
			for(int i = 0; i < 8; i++) {
				end[i]=start[7-i];
			}
			return end;
		}
		if(c=='B') {
			for(int i = 0; i < 3; i++) {
				end[i+1]=start[i];
				end[4+i]=start[5+i];
			}
			end[0]=start[3];
			end[7]=start[4];
			return end;
		}
		end[0]=start[0];
		end[7]=start[7];
		end[3]=start[3];
		end[4]=start[4];
		end[1]=start[6];
		end[2]=start[1];
		end[5]=start[2];
		end[6]=start[5];
		return end;
	}
	private static int con(int[] a) {
		int x = a[0];
		for(int i = 1; i < 8; i++) {
			x*=10;
			x+=a[i];
		}
		return x;
	}
}
