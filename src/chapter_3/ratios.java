/*
ID: philip61
TASK: ratios
LANG: JAVA
 */
package chapter_3;
import java.util.*;
import java.io.*;
public class ratios {
	public static void main(String[] args) throws IOException{
		BufferedReader f = new BufferedReader(new FileReader("ratios.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ratios.out")));
		int[][] input = new int[4][3];
		for(int i = 0; i < 4; i++) {
			StringTokenizer st = new StringTokenizer(f.readLine());
			for(int j = 0; j < 3; j++) {
				input[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		int[] reach = new int[4];
		int[] result = new int[3];
		for(int i = 0; i < 100; i++) {
			for(int j = 0; j < 100; j++) {
				for(int k = 0; k < 100; k++) {
					for(int a = 0; a < 3; a++) {
						result[a]=input[1][a]*i+input[2][a]*j+input[3][a]*k;
					}
					int x = check(result,input);
					if(x>0&&(reach[3]==0||x<reach[3])) {
						reach[0]=i;
						reach[1]=j;
						reach[2]=k;
						reach[3]=x;
					}
				}
			}
		}
		if(reach[3]==0) {
			out.println("NONE");
		}
		else
			out.println(reach[0]+" "+reach[1]+" "+reach[2]+" "+reach[3]);
		out.close();
	}
	private static int check(int[] res,int[][] input) {
		int x = -1;
		for(int i = 0; i < 3; i++) {
			if(input[0][i]>0) {
				if(res[i]==0||res[i]%input[0][i]!=0) {
					return 0;
				}
				if(x>0&&res[i]/input[0][i]!=x)
					return 0;
				x=res[i]/input[0][i];
			}
			else if(res[i]!=0){
				return 0;
			}
		}
		return x;
	}
}
