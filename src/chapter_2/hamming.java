/*
ID: philip61
LANG: JAVA
TASK: hamming
 */
package chapter_2;
import java.util.*;
import java.io.*;
public class hamming {
	static int N, B, D;
	public static void main(String[] args) throws IOException{
		BufferedReader f = new BufferedReader(new FileReader("hamming.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("hamming.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		N = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		List<Integer> keep = new ArrayList<Integer>();
		keep.add(0);
		for(int i = 1; i < (int)Math.pow(2,B); i++)
		{
			boolean shouldKeep = true;
			for(int j = 0; j < keep.size(); j++)
			{
				if(compare(i,keep.get(j))<D)
					shouldKeep = false;
			}
			if(shouldKeep)
				keep.add(i);
			if(keep.size()==N)
				break;
		}
		int index = 0;
		while(index<keep.size())
		{
			if(index%10==9||index==keep.size()-1)
			{
				out.println(""+keep.get(index));
			}
			else
				out.print(keep.get(index)+" ");
			index++;
		}
		out.close();
	}
	public static int compare(int a, int b){
		int tempA = a;
		int tempB = b;
		boolean[] numA = new boolean[B];
		boolean[] numB = new boolean[B];
		for(int i = 0; i < B; i++)
		{
			if(tempA%2==1)
				numA[i] = true;
			else
				numA[i] = false;
			tempA/=2;
			if(tempB%2==1)
				numB[i] = true;
			else
				numB[i] = false;
			tempB/=2;
		}
		int count = 0;
		for(int i = 0; i < B; i++)
		{
			if(numA[i]!=numB[i])
				count++;
		}
		return count;
	}
}