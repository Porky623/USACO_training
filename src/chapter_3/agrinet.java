/*
ID: philip61
TASK: agrinet
LANG: JAVA
 */
package chapter_3;
import java.util.*;
import java.io.*;
public class agrinet {
	private static int[][] connect;
	private static int[] dist, source;
	private static boolean[] inTree;
	private static int INF = 2000000000;
	private static int treeSize,treeCost;
	public static void main(String[] args) throws IOException{
		Scanner f = new Scanner(new File("agrinet.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("agrinet.out")));
		int N = f.nextInt();
		connect=new int[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				connect[i][j]=f.nextInt();
			}
		}
		dist = new int[N];
		source = new int[N];
		inTree = new boolean[N];
		for(int i = 0; i < N; i++) {
			dist[i]=INF;
			inTree[i]=false;
			source[i]=-1;
		}
		treeSize=1;
		treeCost=0;
		inTree[0]=true;
		for(int i = 1; i < N; i++) {
			dist[i]=connect[0][i];
			source[i]=0;
		}
		while(treeSize<N) {
			int min = INF;
			int in = 0;
			for(int i = 1; i < N; i++) {
				if(!inTree[i]&&dist[i]<min) {
					min=dist[i];
					in=i;
				}
			}
			treeSize++;
			treeCost+=min;
			inTree[in]=true;
			for(int j = 0; j < N; j++) {
				if(dist[j]>connect[in][j]) {
					dist[j]=connect[in][j];
					source[j]=in;
				}
			}
		}
		out.println(treeCost);
		out.close();
	}
}
