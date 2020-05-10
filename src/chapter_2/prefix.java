/*
ID: philip61
TASK: prefix
LANG: JAVA
 */
package chapter_2;
import java.util.*;
import java.io.*;
public class prefix {
	private static int n;
   public static void main(String[] args) throws IOException{
      BufferedReader f = new BufferedReader(new FileReader("prefix.in"));
      PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("prefix.out")));
      ArrayList<String> pri = new ArrayList<String>();
      boolean cont = true;
      while(cont) {
    	  StringTokenizer st = new StringTokenizer(f.readLine());
    	  while(st.hasMoreTokens()) {
    		  String k = st.nextToken();
    		  if(!k.equals("."))
    			  pri.add(k);
    		  else
    			  cont = false;
    	  }
      }
      String line;
      StringBuilder sb = new StringBuilder();
		line = f.readLine();
		while (line != null) {
			sb.append(line);
			line = f.readLine();
		}
      String S = sb.toString();
      boolean[] work = new boolean[200050];
      work[0]=true;
      for(int i = 0; i < S.length(); i++){
         if(work[i]){
            for(int j = 0; j < pri.size(); j++){
               if(S.length()>=(i+pri.get(j).length()))
               if(S.substring(i,i+pri.get(j).length()).equals(pri.get(j)))
                  work[i+pri.get(j).length()]=true;
            }
         }
      }
      for(int i = S.length(); i >=0; i--){
         if(work[i]){
            out.println(i);
            out.close();
            System.exit(0);
         }
      }
      }
}
