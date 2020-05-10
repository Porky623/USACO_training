/*
ID: philip61
TASK: subset
LANG: JAVA
 */
package chapter_2;
import java.util.*;
import java.io.*;
public class subset {
	public static void main(String[] args) throws IOException{
		BufferedReader f = new BufferedReader(new FileReader("subset.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("subset.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int N = Integer.parseInt(st.nextToken());
		long sum = N*(N+1)/2;
		if((N*(N+1))%4!=0)
			out.println("0");
		else {
			//ArrayList<Integer> l = new ArrayList<Integer>();
			//out.println(""+(calc(N,l)/2));
		
			long[][] cost = new long[N][(int)sum + 1];
	
			for (int i = 0; i < N; i++) {
			    cost[i][i] = 1;
			    for (int j = 0; j <= sum; j++) {
					if (i > 0) {
					    cost[i][j] = cost[i - 1][j];
					    if (j >= i)
						cost[i][j] += cost[i - 1][j - i];
					}
			    }
			}
			out.println(""+(int)cost[N-1][(int)sum/2]);
		}
		out.close();
	}
	private static int calc(int N, ArrayList<Integer> list) {
		int goal = (N*(N+1))/4;
		int sum = 0;
		for(int x : list) {
			sum+=x;
		}
		if(goal==sum)
			return 1;
		if(goal<sum)
			return 0;
		int end = 0;
		if(list.size()==0) {
			for(int i = 1; i <= (double)N/1.4; i++) {
				ArrayList<Integer> temp = new ArrayList<Integer>();
				temp.add(i);
				end+=calc(N,temp);
			}
		}
		else {
			for(int i = list.get(list.size()-1)+1;i<=N&&sum+i<=goal;i++) {
				ArrayList<Integer> temp = new ArrayList<Integer>();
				for(int x : list)
					temp.add(x);
				temp.add(i);
				end+=calc(N,temp);
			}
		}
		return end;
	}
}
