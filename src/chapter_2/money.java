/*
ID: philip61
TASK: money
LANG: JAVA
 */
package chapter_2;
import java.util.*;
import java.io.*;
public class money {
	public static void main(String[] args) throws IOException{
		Scanner f = new Scanner(new File("money.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("money.out")));
		int V = f.nextInt();
		int N = f.nextInt();
		ArrayList<Integer> c = new ArrayList<Integer>();
		HashSet<Integer> d = new HashSet<Integer>();
		for(int i = 0; i < V; i++) {
			int x = f.nextInt();
			if(x<=N&&!d.contains(x)) {
				d.add(x);
				c.add(x);
			}
		}
		int[] coin = new int[c.size()];
		for(int i = 0; i < coin.length; i++) {
			coin[i]=c.get(i);
		}
		long[][] dp = new long[N+1][coin.length];
		for(int i = 0; i < coin.length; i++) {
			dp[0][i]=1;
		}
		Arrays.sort(coin);
		for(int i = coin[0]; i <= N; i+=coin[0]) {
			dp[i][0]=1;
		}
		for(int i = 1; i < coin.length; i++) {
			for(int j = 1; j < coin[i]; j++) {
				dp[j][i]+=dp[j][i-1];
			}
			for(int j = coin[i]; j <= N; j++) {
				dp[j][i]+=dp[j][i-1];
				dp[j][i]+=dp[j-coin[i]][i];
			}
		}
		out.println(dp[N][coin.length-1]);
		out.close();
	}
}