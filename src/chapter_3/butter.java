/*
ID: philip61
TASK: butter
LANG: JAVA
 */
package chapter_3;
import java.util.*;
import java.io.*;
public class butter {
	private static int N,P,C,min;
	private static int[] graze;
	private static int[][] graph;
	private static ArrayList<ArrayList<Integer>> vert = new ArrayList<ArrayList<Integer>>();
	private final static int INF = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException{
		BufferedReader f = new BufferedReader(new FileReader("butter.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("butter.out")));
		StringTokenizer st1 = new StringTokenizer(f.readLine());
		N=Integer.parseInt(st1.nextToken());
		P=Integer.parseInt(st1.nextToken());
		C=Integer.parseInt(st1.nextToken());
		graze = new int[N];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(f.readLine());
			graze[i]=Integer.parseInt(st.nextToken());
		}
		graph=new int[P][P];
		for(int i = 0; i < P; i++) {
			for(int j = 0; j < P; j++) {
				graph[i][j]=INF;
			}
			graph[i][i]=0;
		}
		for(int i = 0; i < P; i++) {
			vert.add(new ArrayList<Integer>());
		}
		for(int i = 0; i < C; i++) {
			StringTokenizer st = new StringTokenizer(f.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			vert.get(a-1).add(b-1);
			vert.get(b-1).add(a-1);
			graph[a-1][b-1]=graph[b-1][a-1]=c;
		}
		min=INF;
		for(int i = 0; i < P; i++) {
			dijkstra(i);
		}
		out.println(min);
		out.close();
	}
	private static void dijkstra(int x) {
		Past[] list = new Past[P];
		for (int i = 0; i < P; i++) {
			list[i] = new Past(i);
		}
		PriorityQueue<Past> queue = new PriorityQueue<Past>();
		list[x].dist = 0;
		queue.add(list[x]);
		while (queue.isEmpty() == false) {
			Past mPast = queue.poll();
			int id = mPast.ID;
			if (list[id].visited == false) {
				list[id].visited = true;
				int sz = vert.get(id).size();
				for (int i = 0; i < sz; i++) {
					int dst = vert.get(id).get(i);
					if (graph[id][dst] == Integer.MAX_VALUE)
						continue;
					int cost = graph[id][dst];
					if (list[dst].visited == false
							|| list[dst].dist - cost > list[id].dist) {
						list[dst].dist = Math.min(list[dst].dist, list[id].dist
								+ cost);
						queue.add(list[dst]);
					}
				}
			}
		}
		int calc = 0;
		for (int i = 0; i < N; i++)
			calc += list[graze[i]-1].dist;
		if(calc<min)
			min=calc;
	}
}
class Past implements Comparable<Past> {
	public boolean visited;
	public int ID;
	public int dist;

	public Past(int id) {
		ID = id;
		dist = Integer.MAX_VALUE;
		visited = false;
	}

	public int compareTo(Past a) {
		if (dist == a.dist)
			return ID - a.ID;
		else
			return dist - a.dist;
	}
}