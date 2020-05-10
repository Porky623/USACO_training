/*
ID: philip61
TASK: lamps
LANG: JAVA
 */
package chapter_2;
import java.util.*;
import java.io.*;
public class lamps {
	public static void main(String[] args) throws IOException{
		BufferedReader f = new BufferedReader(new FileReader("lamps.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lamps.out")));
		StringTokenizer stn = new StringTokenizer(f.readLine());
		int N = Integer.parseInt(stn.nextToken());
		StringTokenizer stc = new StringTokenizer(f.readLine());
		int C = Integer.parseInt(stc.nextToken());
		StringTokenizer st1 = new StringTokenizer(f.readLine());
		ArrayList<Integer> onl = new ArrayList<Integer>();
		while(st1.hasMoreTokens()) {
			onl.add(Integer.parseInt(st1.nextToken()));
		}
		int[] on = new int[onl.size()-1];
		for(int i = 0; i < on.length; i++) {
			on[i]=(onl.get(i));
		}
		StringTokenizer st2 = new StringTokenizer(f.readLine());
		ArrayList<Integer> offl = new ArrayList<Integer>();
		while(st2.hasMoreTokens()) {
			offl.add(Integer.parseInt(st2.nextToken()));
		}
		int[] off = new int[offl.size()-1];
		for(int i = 0; i < off.length; i++) {
			off[i]=(offl.get(i));
		}
		String[] p = new String[] {"000000","010101","101010","111111","100100","011011","001110","110001"};
		boolean[][] pos = new boolean[8][6];
		for(int i = 0; i < 8; i++) {
			String s = p[i];
			for(int j = 0; j < 6; j++) {
				if(s.charAt(j)=='0')
					pos[i][j]=false;
				else
					pos[i][j]=true;
			}
		}
		int[][] moves = new int[8][2];
		moves[0][0]=1;
		moves[0][1]=2;
		moves[1][0]=1;
		moves[1][1]=2;
		moves[2][0]=1;
		moves[2][1]=2;
		moves[3][0]=0;
		moves[3][1]=3;
		moves[4][0]=2;
		moves[4][1]=3;
		moves[5][0]=1;
		moves[5][1]=4;
		moves[6][0]=2;
		moves[6][1]=3;
		moves[7][0]=2;
		moves[7][1]=3;
		int[] set = new int[6];
		for(int i = 0; i < 6; i++) {
			set[i]=0;
		}
		for(int i = 0; i < on.length; i++) {
			set[(on[i]+5)%6]=1;
		}
		for(int i = 0; i < off.length; i++) {
			if(set[(off[i]+5)%6]==1) {
				out.println("IMPOSSIBLE");
				out.close();
				System.exit(0);
			}
			set[(off[i]+5)%6]=-1;
		}
		if(C>2) {
			boolean[] can = new boolean[8];
			for(int i = 0; i < 8; i++) {
				can[i]=true;
			}
			for(int i = 0; i < 8; i++) {
				check:
				for(int j = 0; j < 6; j++) {
					if(pos[i][j]&&set[j]==-1||!pos[i][j]&&set[j]==1){
						can[i]=false;
						break check;
					}
				}
			}
			ArrayList<String> sol = new ArrayList<String>();
			for(int i = 0; i < 8; i++){
				if(can[i]) {
					String s = "";
					for(int j = 0; j < N; j++) {
						if(pos[i][j%6])
							s+="1";
						else
							s+="0";
					}
					sol.add(s);
				}
			}
			if(sol.size()==0)
				out.println("IMPOSSIBLE");
			else {
				String[] ax = new String[sol.size()];
				for(int i = 0; i < ax.length; i++) {
					ax[i]=sol.get(i);
				}
				Arrays.sort(ax);
				for(String s : ax)
					out.println(s);
			}
			out.close();
			System.exit(0);
		}
		ArrayList<boolean[]> can = new ArrayList<boolean[]>();
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 2; j++) {
				if(moves[i][j]==C)
					can.add(pos[i]);
			}
		}
		boolean[] cou = new boolean[can.size()];
		for(int i = 0; i < cou.length; i++) {
			cou[i]=true;
		}
		for(int i = 0; i < can.size(); i++) {
			check:
			for(int j = 0; j < 6; j++) {
				if(can.get(i)[j]&&set[j]==-1||!can.get(i)[j]&&set[j]==1){
					cou[i]=false;
					break check;
				}
			}
		}
		ArrayList<String> sol = new ArrayList<String>();
		for(int i = 0; i < can.size(); i++){
			if(cou[i]) {
				String s = "";
				for(int j = 0; j < N; j++) {
					if(can.get(i)[j%6])
						s+="1";
					else
						s+="0";
				}
				sol.add(s);
			}
		}
		if(sol.size()==0)
			out.println("IMPOSSIBLE");
		else {
			String[] ax = new String[sol.size()];
			for(int i = 0; i < ax.length; i++) {
				ax[i]=sol.get(i);
			}
			Arrays.sort(ax);
			for(String s : ax)
				out.println(s);
		}
		out.close();
	}
}
