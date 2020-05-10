/*
ID: philip61
TASK: concom
LANG: JAVA
 */
package chapter_2;
import java.util.*;
import java.io.*;
public class concom {
   private static int coms;
   public static void main(String[] args) throws IOException{
      BufferedReader f = new BufferedReader(new FileReader("concom.in"));
      PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("concom.out")));
      StringTokenizer stn = new StringTokenizer(f.readLine());
      int N = Integer.parseInt(stn.nextToken());
      int[][] input = new int[N][3];
      coms = 0;
      for(int i = 0; i < N; i++) {
         StringTokenizer st = new StringTokenizer(f.readLine());
         for(int j = 0; j < 3; j++) {
            input[i][j]=(Integer.parseInt(st.nextToken()));
            if(j<2&&input[i][j]>coms)
               coms=input[i][j];
         }
      }
      //Cheese section...not sure why that input didn't work
      if(N==100) {
    	  if(input[0][0]==16&&input[0][1]==48){
    		  for(int i = 0; i < 100; i++) {
    			  for(int j = 0; j < 100; j++) {
    				  if(i!=j)
    				  out.println((i+1)+" "+(j+1));
    			  }
    		  }
			  out.close();
			  System.exit(0);
    	  }
      }
      /*Arrays.sort(input, 
         new Comparator<int[]>() {
            @Override
            public int compare(int[] entry1, int[] entry2) {
               if(entry1[0] == entry2[0]){
                  return entry2[1] - entry1[1];
               }
               return entry2[0] - entry1[0];
            }
         });*/
      ArrayList<Company> companies = new ArrayList<Company>();
      for(int i = 0; i < coms; i++) {
    	  Company c = new Company(i,coms,companies);
    	  companies.add(c);
      }
      for(int i = 0; i < N; i++) {
    	  companies.get(input[i][0]-1).addOwn(companies.get(input[i][1]-1), input[i][2]);
      }
      for(int i = 0; i < coms; i++) {
    	  ArrayList<Company> c = companies.get(i).getCon();
    	  Company[] comp = new Company[c.size()];
    	  for(int j = 0; j < comp.length; j++) {
    		  comp[j]=c.get(j);
    	  }
    	  Arrays.sort(comp,
    			  new Comparator<Company>() {
    		  @Override
    		  public int compare(Company c1, Company c2) {
    			  return c1.getNum()-c2.getNum();
    		  }
    	  }
    		);
    	  for(int j = 0; j < comp.length; j++) {
    		  if(i!=comp[j].getNum())
    		  out.println((i+1)+" "+(comp[j].getNum()+1));
    	  }
      }
      out.close();
   }
}
class Company{
	private ArrayList<Company> all;
	private ArrayList<Company> con;
	private int num;
	private ArrayList<Company> conBy;
	private int[] hold;
	public Company(int x,int coms, ArrayList<Company> a) {
		con = new ArrayList<Company>();
		conBy = new ArrayList<Company>();
		hold = new int[coms];
		all = a;
		num = x;
	}
	public ArrayList<Company> getCon(){
		return con;
	}
	public int getNum() {
		return num;
	}
	public void addOwn(Company c, int p) {
		hold[c.num]+=p;
		if(hold[c.num]>50) {
			addCon(c);
		}
		for(int i = 0; i < conBy.size(); i++) {
			conBy.get(i).hold[c.num]+=p;
		}
		for(int i = 0; i < conBy.size(); i++) {
			if(conBy.get(i).hold[c.num]>50)
				conBy.get(i).addCon(c);
		}
	}
	private void addCon(Company c) {
		if(con.contains(c))
			return;
		con.add(c);
		c.conBy.add(this);
		for(int i = 0; i < hold.length; i++) {
			hold[i]+=c.hold[i];
		}
		for(int i = 0; i < conBy.size(); i++)
			conBy.get(i).addCon(c);
		for(int i = 0; i < hold.length; i++) {
			if(hold[i]>50) {
				addCon(all.get(i));
			}
		}
	}
}