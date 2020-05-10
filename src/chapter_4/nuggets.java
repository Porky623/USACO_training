/*
ID: philip61
TASK: nuggets
LANG: JAVA
 */
package chapter_4;
import java.util.*;
import java.io.*;
public class nuggets {
	public static void main(String[] args) throws IOException{
		BufferedReader f = new BufferedReader(new FileReader("nuggets.in"));
		PrintWriter out =  new PrintWriter(new BufferedWriter(new FileWriter("nuggets.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int N = Integer.parseInt(st.nextToken());
		ArrayList<Integer> boxes = new ArrayList<Integer>();
		boolean cont = false;
		for(int i = 0; i < N; i++) {
			st=new StringTokenizer(f.readLine());
			int x = Integer.parseInt(st.nextToken());
			if(!cont) {
				for(int j = 0; j < i; j++) {
					if(x>boxes.get(j)) {
						if(gcd(x,boxes.get(j))==1)
							cont=true;
					}
					else if(gcd(boxes.get(j),x)==1)
						cont=true;
				}
			}
			boxes.add(x);
		}
		if(!cont)
			out.println(0);
		else {
			boolean[] dp = new boolean[65025];
			for(int i = 0; i < N; i++) {
				dp[boxes.get(i)]=true;
			}
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < 65025-boxes.get(i); j++) {
					if(dp[j])
						dp[j+boxes.get(i)]=true;
				}
			}
			int max = 0;
			for(int i = 1; i < 65025; i++) {
				if(!dp[i])
					max=i;
			}
			out.println(max);
		}
		f.close();
		out.close();
	}
	private static int gcd(int a, int b) {
		if(a%b==0)
			return b;
		return gcd(b,a%b);
	}
}
