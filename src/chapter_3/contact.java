/*
ID: philip61
TASK: contact
LANG: JAVA
 */
package chapter_3;
import java.util.*;
import java.io.*;
public class contact {
	public static void main(String[] args) throws IOException{
		Scanner f = new Scanner(new File("contact.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("contact.out")));
		int A = f.nextInt();
		int B = f.nextInt();
		int N = f.nextInt();
		StringBuilder st = new StringBuilder();
		while(f.hasNextLine())
			st.append(f.nextLine());
		int[][] count = new int[17000][2];
		for(int i = 0; i < count.length; i++) {
			count[i][0]=i;
		}
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int i = 0; i < st.length(); i++) {
			for(int j = A; j <= B; j++) {
				if(i+j<=st.length()) {
					int x = calc(st.substring(i, i+j));
					count[x][1]++;
				}
			}
		}
		Arrays.sort(count, 
		         new Comparator<int[]>() {
		            @Override
		            public int compare(int[] entry1, int[] entry2) {
		               if(entry1[1] == entry2[1]){
		                  return entry1[0] - entry2[0];
		               }
		               return entry2[1] - entry1[1];
		            }
		         });
		int cur = 0;
		int c = 0;
		int index = 0;
		int cx = 0;
	    while(cx<=N) {
	    	if(index>=count.length)
	    		break;
	    	if(count[index][1]>0) {
	    		if(count[index][1]==cur&&c>0&&c%6==0) {
	    			out.println();
	    			out.print(back(count[index][0]));
	    			c++;
	    		}
	    		else if(count[index][1]==cur) {
	    			out.print(" "+back(count[index][0]));
	    			c++;
	    		}
	    		else {
	    			if(cx==N)
	    				break;
	    			if(index!=0) {
	    				out.println();
	    			}
	    			out.println(count[index][1]);
	    			out.print(back(count[index][0]));
	    			cur=count[index][1];
	    			c=1;
		    		cx++;
	    		}
	    	}
    		index++;
	    }
	    out.println();
	    out.close();
	}
	private static int calc(String s) {
		StringBuilder st = new StringBuilder();
		st.append("1");
		st.append(s);
		return Integer.parseInt(st.toString(), 2);
	}
	private static String back(int x) {
		return Integer.toBinaryString(x).substring(1);
	}
}
