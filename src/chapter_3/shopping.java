/*
ID: philip61
TASK: shopping
LANG: JAVA
 */
package chapter_3;
import java.util.*;
import java.io.*;
public class shopping {
	private static int[][][] offers;
	private static int[][] toBuy = new int[5][3];
	private static int[] prices;
	public static void main(String[] args) throws IOException{
		BufferedReader f = new BufferedReader(new FileReader("shopping.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("shopping.out")));
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		int[][][][][] dp = new int[6][6][6][6][6];
		int s = Integer.parseInt(f.readLine());
		//number of products, code c, k items
		offers = new int[s][][];
		prices = new int[s];
		for(int i = 0; i < s; i++) {
			StringTokenizer st = new StringTokenizer(f.readLine());
			int n = Integer.parseInt(st.nextToken());
			offers[i]=new int[n][2];
			for(int j = 0; j < n; j++) {
				offers[i][j][0]=Integer.parseInt(st.nextToken());
				offers[i][j][1]=Integer.parseInt(st.nextToken());
				map.put(offers[i][j][0], -1);
			}
			prices[i]=Integer.parseInt(st.nextToken());
		}
		int b = Integer.parseInt(f.readLine());
		for(int i = 0; i < b; i++) {
			StringTokenizer st = new StringTokenizer(f.readLine());
			int x =toBuy[i][0]= Integer.parseInt(st.nextToken());
			map.put(x, i);
			toBuy[i][1]=Integer.parseInt(st.nextToken());
			toBuy[i][2]=Integer.parseInt(st.nextToken());
		}
		for(int a = 0; a < 6; a++) {
			for(b = 0; b < 6; b++) {
				for(int c = 0; c < 6; c++) {
					for(int d = 0; d < 6; d++) {
						for(int e = 0; e < 6; e++) {
							dp[a][b][c][d][e]=a*toBuy[0][2]+b*toBuy[1][2]+c*toBuy[2][2]+d*toBuy[3][2]+e*toBuy[4][2];
						}
					}
				}
			}
		}
		int[] ind = new int[5];
		for(ind[0] = 0; ind[0] < 6; ind[0]++) {
			for(ind[1] = 0; ind[1] < 6; ind[1]++) {
				for(ind[2] = 0; ind[2] < 6; ind[2]++) {
					for(ind[3] = 0; ind[3] < 6; ind[3]++) {
						for(ind[4] = 0; ind[4] < 6; ind[4]++) {
							int[] add;
							for(int i = 0; i < s; i++) {
								add = new int[5];
								boolean cont = true;
								for(int j = 0; j < offers[i].length; j++) {
									if(map.get(offers[i][j][0])>=0)
										add[map.get(offers[i][j][0])]=offers[i][j][1];
									else
										cont=false;
								}
								for(int j = 0; j < 5; j++) {
									if(ind[j]+add[j]>5) {
										cont = false;
										break;
									}
								}
								if(cont) {
									dp[ind[0]+add[0]][ind[1]+add[1]][ind[2]+add[2]][ind[3]+add[3]][ind[4]+add[4]]=Math.min(dp[ind[0]][ind[1]][ind[2]][ind[3]][ind[4]]+prices[i], dp[ind[0]+add[0]][ind[1]+add[1]][ind[2]+add[2]][ind[3]+add[3]][ind[4]+add[4]]);
								}
							}
						}
					}
				}
			}
		}
		out.println(dp[toBuy[0][1]][toBuy[1][1]][toBuy[2][1]][toBuy[3][1]][toBuy[4][1]]);
		out.close();
		f.close();
	}
}
