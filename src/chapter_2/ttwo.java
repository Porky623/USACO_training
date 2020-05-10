/*
ID: philip61
TASK: ttwo
LANG: JAVA
 */
package chapter_2;
import java.util.*;
import java.io.*;
public class ttwo {
	private static boolean[][] grid;
	private static int[] far,cow;
	public static void main(String[] args) throws IOException{
		BufferedReader f = new BufferedReader(new FileReader("ttwo.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ttwo.out")));
		far = new int[3];
		cow = new int[3];
		grid = new boolean[10][10];
		for(int i = 0; i < 10; i++) {
			String k = f.readLine();
			for(int j = 0; j < 10; j++) {
				if(k.charAt(j)=='F'){
					far[0]=i;
					far[1]=j;
					far[2]=0;
				}
				else if(k.charAt(j)=='C') {
					cow[0]=i;
					cow[1]=j;
					cow[2]=0;
				}
				else if(k.charAt(j)=='*') {
					grid[i][j]=true;
				}
			}
		}
		for(int i = 0; i < 160000; i++) {
			if(far[0]==cow[0]&&far[1]==cow[1]){
				out.println(i);
				out.close();
				System.exit(0);
			}
			move();
		}
		out.println(0);
		out.close();
	}
	private static void move() {
		moveX(far);
		moveX(cow);
	}
	private static void moveX(int[] x) {
		switch(x[2]) {
		case 0:
			if(x[0]>0&&!grid[x[0]-1][x[1]]) {
				x[0]--;
			}
			else {
				x[2]++;
			}
			break;
		case 1:
			if(x[1]<9&&!grid[x[0]][x[1]+1]) {
				x[1]++;
			}
			else {
				x[2]++;
			}
			break;
		case 2:
			if(x[0]<9&&!grid[x[0]+1][x[1]]) {
				x[0]++;
			}
			else {
				x[2]++;
			}
			break;
		default:
			if(x[1]>0&&!grid[x[0]][x[1]-1]) {
				x[1]--;
			}
			else {
				x[2]=0;
			}
		}
	}
}
