/*
ID: philip61
TASK: camelot
LANG: JAVA
 */
package chapter_3;
import java.util.*;
import java.io.*;
public class camelot {
	private static int R,C;
	private static int[] dx = new int[] {-2,-1,1,2,2,1,-1,-2};
	private static int[] dy = new int[] {1,2,2,1,-1,-2,-2,-1};
	private static int[][][][] dist;
	private static Square king;
	private static ArrayList<Square> knights = new ArrayList<Square>();
	public static void main(String[] args) throws IOException{
		BufferedReader f = new BufferedReader(new FileReader("camelot.in"));
		PrintWriter out = new PrintWriter(new FileWriter("camelot.out"));
		String[] str = f.readLine().split(" ");
		R = Integer.parseInt(str[0]);
		C = Integer.parseInt(str[1]);
		dist=new int[R][C][R][C];
		str = f.readLine().split(" ");
		king = new Square(Integer.parseInt(str[1]) - 1, str[0].charAt(0) - 'A');
		String strline;
		while ((strline = f.readLine()) != null) {
			str = strline.split(" ");
			for (int i = 0; i < str.length; i += 2) {
				knights.add(new Square(Integer.parseInt(str[i + 1]) - 1, str[i].charAt(0) - 'A'));
			}
		}
		f.close();
		out.println(solve());
		out.close();
	}
	private static int solve() {
		int moves = Integer.MAX_VALUE;
		calc();
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				int temp = minSteps(new Square(i,j));
				moves=Math.min(moves,temp);
			}
		}
		return moves;
	}
	private static int minSteps(Square s) {
		int moves = 0;
		for(Square k : knights) {
			if(dist[s.x][s.y][k.x][k.y]<0)
				return Integer.MAX_VALUE;
			moves+=dist[s.x][s.y][k.x][k.y];
		}
		int temp = Math.max(Math.abs(king.x-s.x), Math.abs(king.y-s.y));
		for (int i = Math.max(0, king.x - 2); i <= Math.min(R - 1, king.x + 2); i++) {
			for (int j = Math.max(0, king.y - 2); j <= Math.min(C - 1,king.y + 2); j++) {
				for (Square knight : knights) {
					if (dist[s.x][s.y][i][j] != -1 && dist[i][j][knight.x][knight.y] != -1)
						temp = Math.min(temp, dist[s.x][s.y][i][j] + dist[i][j][knight.x][knight.y] - dist[s.x][s.y][knight.x][knight.y] + Math.max(Math.abs(king.x - i),Math.abs(king.y - j)));
				}
			}
		}
		return moves + temp;
	}
	private static void calc() {
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				for(int k = 0; k < R; k++) {
					for(int l = 0; l < C; l++) {
						dist[i][j][k][l]=-1;
					}
				}
			}
		}
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				dist[i][j][i][j]=0;
				move(new Square(i,j));
			}
		}
	}
	private static void move(Square dest) {
		Queue<Square> queue = new LinkedList<Square>();
		queue.add(dest);
		while(!queue.isEmpty()) {
			Square cur = queue.poll();
			for(int i = 0; i < 8; i++) {
				int x = cur.x+dx[i];
				int y = cur.y+dy[i];
				if(legal(x,y)){
					if((dist[dest.x][dest.y][x][y]<0||dist[dest.x][dest.y][cur.x][cur.y]+1<dist[dest.x][dest.y][x][y])) {
						dist[dest.x][dest.y][x][y]=dist[x][y][dest.x][dest.y]=dist[dest.x][dest.y][cur.x][cur.y]+1;
						queue.add(new Square(x,y));
					}
				}
			}
		}
	}
	private static boolean legal(int x, int y) {
		return x>=0&&y>=0&&x<R&&y<C;
	}
}
class Square{
	public int x,y;
	public Square(int a, int b) {
		x=a;
		y=b;
	}
	
}