/*
ID: philip61
TASK: fence
LANG: JAVA
 */
package chapter_3;
import java.util.*;
import java.io.*;
public class fence {
	private static int N;
	private static PrintWriter out;
	private static HashMap<Integer,PriorityQueue<Integer>> map = new HashMap<Integer,PriorityQueue<Integer>>();
	private static Stack<Integer> stack=new Stack<Integer>();
	public static void main(String[] args) throws IOException{
		Scanner f = new Scanner(new File("fence.in"));
		out = new PrintWriter(new BufferedWriter(new FileWriter("fence.out")));
		N=f.nextInt();
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < N; i++) {
			int x = f.nextInt();
			int y = f.nextInt();
			if(!map.containsKey(x)) {
				map.put(x, new PriorityQueue<Integer>());
			}
			if(!map.containsKey(y)) {
				map.put(y, new PriorityQueue<Integer>());
			}
			map.get(x).add(y);
			map.get(y).add(x);
			if(x<min)
				min=x;
			if(y<min)
				min=y;
		}
		int start=Integer.MAX_VALUE;
		Set<Integer> keys = map.keySet();
		for(int x : keys) {
			if(x<start&&map.get(x).size()%2==1)
				start=x;
		}
		if(start==Integer.MAX_VALUE)
			recurse(min);
		else
			recurse(start);
		int last = 0;
		while(!stack.isEmpty()) {
			int x = stack.pop();
			if(x!=last)
			out.println(x);
			last=x;
		}
		out.close();
	}
	private static void recurse(int node) {
		if(map.get(node).size()==0) {
			stack.push(node);
			return;
		}
		while(!map.get(node).isEmpty()) {
			int x = map.get(node).poll();
			map.get(x).remove(node);
			recurse(x);
			stack.push(node);
		}
	}
}
