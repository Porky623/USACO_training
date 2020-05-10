/*
ID: philip61
TASK: zerosum
LANG: JAVA
 */
package chapter_2;
import java.util.*;
import java.io.*;
public class zerosum {
	private static PrintWriter out;
	private static int N;
	public static void main(String[] args) throws IOException{
		BufferedReader f = new BufferedReader(new FileReader("zerosum.in"));
		out = new PrintWriter(new BufferedWriter(new FileWriter("zerosum.out")));
		N = Integer.parseInt(f.readLine());
		ArrayList<ArrayList<Integer>> pos = make(0,new ArrayList<Integer>());
		for(ArrayList<Integer> x : pos) {
			solve(x);
		}
		out.close();
	}
	private static ArrayList<ArrayList<Integer>> make(int k,ArrayList<Integer> cur){
		ArrayList<ArrayList<Integer>> temp = new ArrayList<ArrayList<Integer>>();
		if(k==N-1) {
			temp.add(cur);
			return temp;
		}
		ArrayList<Integer> t = new ArrayList<Integer>();
		t.addAll(cur);
		t.add(0);
		temp.addAll(make(k+1,t));
		t = new ArrayList<Integer>();
		t.addAll(cur);
		t.add(1);
		temp.addAll(make(k+1,t));
		t = new ArrayList<Integer>();
		t.addAll(cur);
		t.add(2);
		temp.addAll(make(k+1,t));
		return temp;
	}
	private static void solve(ArrayList<Integer> arr) {
		ArrayList<Integer> nums = new ArrayList<Integer>();
		for(int i = 1; i < N+1; i++) {
			nums.add(i);
		}
		int index = 0;
		for(int i = 0; i < N-1; i++) {
			if(arr.get(i)==0) {
				nums.set(index,nums.get(index)*10+nums.get(index+1));
				nums.remove(index+1);
			}
			else {
				index++;
			}
		}
		ArrayList<Integer> arr2 = new ArrayList<Integer>();
		for(int i = 0; i < arr.size(); i++) {
			if(arr.get(i)!=0)
				arr2.add(arr.get(i));
		}
		int total = nums.get(0);
		for(int i = 0; i < arr2.size(); i++) {
			if(arr2.get(i)==1) {
				total+=nums.get(i+1);
			}
			else
				total-=nums.get(i+1);
		}
		if(total==0) {
			out.println(tString(arr));
		}
	}
	private static String tString(ArrayList<Integer> arr) {
		String k = "1";
		for(int i = 0; i < arr.size(); i++) {
			switch(arr.get(i)) {
			case 0:
				k+=" ";
				break;
			case 1:
				k+="+";
				break;
			default:
				k+="-";
			}
			k+=""+(i+2);
		}
		return k;
	}
}
