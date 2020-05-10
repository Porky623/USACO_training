/*
ID: philip61
TASK: maze1
LANG: JAVA
 */
package chapter_2;
import java.io.*;
import java.util.*;
public class maze1 {
	private static int[][][] grid;
	public static void main(String[] args) throws IOException{
		BufferedReader f = new BufferedReader(new FileReader("maze1.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("maze1.out")));
		StringTokenizer st1 = new StringTokenizer(f.readLine());
		int W = Integer.parseInt(st1.nextToken());
		int H = Integer.parseInt(st1.nextToken());
		grid = new int[2][2*H+1][2*W+1];
		int[][] ent = new int[2][2];
		int in = 0;
		for(int i = 0; i < 2*H+1; i++) {
			String k = f.readLine();
			for(int j = 0; j < 2*W+1; j++) {
				if(k.charAt(j)==' ') {
					if(i==0||i==2*H||j==0||j==2*W) {
						ent[in][0]=i;
						ent[in][1]=j;
						in++;
					}
				}
				else {
					grid[0][i][j]=-1;
					grid[1][i][j]=-1;
				}
			}
		}
		for(int i = 0; i < 2; i++) {
			if(ent[i][0]==0) {
				grid[i][1][ent[i][1]]=1;
				if(grid[i][2][ent[i][1]]==0)
					run(i,3,ent[i][1],2);
				if(grid[i][1][ent[i][1]+1]==0) {
					run(i,1,ent[i][1]+2,2);
				}
				if(grid[i][1][ent[i][1]-1]==0) {
					run(i,1,ent[i][1]-2,2);
				}
			}
			if(ent[i][0]==2*H) {
				grid[i][2*H-1][ent[i][1]]=1;
				if(grid[i][2*H-2][ent[i][1]]==0)
					run(i,2*H-3,ent[i][1],2);
				if(grid[i][2*H-1][ent[i][1]+1]==0) {
					run(i,2*H-1,ent[i][1]+2,2);
				}
				if(grid[i][2*H-1][ent[i][1]-1]==0) {
					run(i,2*H-1,ent[i][1]-2,2);
				}
			}
			if(ent[i][1]==0) {
				grid[i][ent[i][0]][1]=1;
				if(grid[i][ent[i][0]][2]==0) {
					run(i,ent[i][0],3,2);
				}
				if(grid[i][ent[i][0]+1][1]==0) {
					run(i,ent[i][0]+2,1,2);
				}
				if(grid[i][ent[i][0]-1][1]==0) {
					run(i,ent[i][0]-2,1,2);
				}
			}
			if(ent[i][1]==2*W) {
				grid[i][ent[i][0]][2*W-1]=1;
				if(grid[i][ent[i][0]][2*W-2]==0) {
					run(i,ent[i][0],2*W-3,2);
				}
				if(grid[i][ent[i][0]+1][2*W-1]==0) {
					run(i,ent[i][0]+2,2*W-1,2);
				}
				if(grid[i][ent[i][0]-1][2*W-1]==0) {
					run(i,ent[i][0]-2,2*W-1,2);
				}
			}
		}
		int max = 0;
		for(int i = 0; i < grid[0].length; i++) {
			for(int j = 0; j < grid[0][0].length; j++) {
				if(grid[0][i][j]>grid[1][i][j])
					grid[0][i][j]=grid[1][i][j];
				int x = grid[0][i][j];
				if(x>max)
					max=x;
			}
		}
		out.println(max);
		out.close();
	}
	private static void run(int n, int x, int y,int len) {
		if(x<=0||y<=0||x>=grid[0].length-1||y>grid[0][0].length-1) {
			return;
		}
		if(0<grid[n][x][y]&&grid[n][x][y]<=len)
			return;
		if(grid[n][x][y]==0||grid[n][x][y]>len)
			grid[n][x][y]=len;
		if(grid[n][x-1][y]==0) {
			run(n,x-2,y,len+1);
		}
		if(grid[n][x+1][y]==0) {
			run(n,x+2,y,len+1);
		}
		if(grid[n][x][y-1]==0) {
			run(n,x,y-2,len+1);
		}
		if(grid[n][x][y+1]==0) {
			run(n,x,y+2,len+1);
		}
	}
}
