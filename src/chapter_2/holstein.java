/*
ID: philip61
LANG: JAVA
TASK: holstein
*/
package chapter_2;
import java.util.*;
import java.io.*;
class holstein{
   static int V,G;
   static int[] vit;
   static int[][] feed;
   public static void main(String[] args) throws IOException{
      BufferedReader f = new BufferedReader(new FileReader("holstein.in"));
      PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("holstein.out")));
      StringTokenizer stv = new StringTokenizer(f.readLine());
      V=Integer.parseInt(stv.nextToken());
      StringTokenizer stvit = new StringTokenizer(f.readLine());
      vit = new int[V];
      for(int i = 0; i < V; i++)
      {
         vit[i] = Integer.parseInt(stvit.nextToken());
      }
      StringTokenizer stg = new StringTokenizer(f.readLine());
      G=Integer.parseInt(stg.nextToken());
      feed = new int[G+1][V];
      for(int i = 1; i <= G; i++)
      {
         StringTokenizer stfeed = new StringTokenizer(f.readLine());
         for(int j = 0; j < V; j++)
         {
            feed[i][j] = Integer.parseInt(stfeed.nextToken());
         }
      }
      boolean notFound = true;
      int[][] solution;
      int[] indices = new int[G];
      for(int i = 1; i <= G; i++)
      {
         if(big(vit,feed[i])&&notFound)
         {
            out.println("1 "+i);
            notFound = false;
         }
      }
      for(int i = 1; i <= G; i++)
      {
         for(int j = i+1; j <= G; j++)
         {
            if(big(vit,sum(feed[i],feed[j]))&&notFound)
            {
               out.println("2 "+i+" "+j);
               notFound = false;
            }        
         }
      }
      for(int i = 1; i <= G; i++)
      {
         for(int j = i+1; j <= G; j++)
         {
            for(int k = j+1; k <= G; k++)
            {
               if(big(vit,sum(feed[i],sum(feed[k],feed[j])))&&notFound)
               {
                  out.println("3 "+i+" "+j+" "+k);
                  notFound = false;
               }        
            }
         }
      }
      for(int i = 1; i <= G; i++)
      {
         for(int j = i+1; j <= G; j++)
         {
            for(int k = j+1; k <= G; k++)
            {
               for(int l = k+1; l <= G; l++)
               {
                  if(big(vit,sum(feed[i],sum(feed[k],sum(feed[l],feed[j]))))&&notFound)
                  {
                     out.println("4 "+i+" "+j+" "+k+" "+l);
                     notFound = false;
                  }        
               }
            }
         }
      }
      for(int i = 1; i <= G; i++)
      {
         for(int j = i+1; j <= G; j++)
         {
            for(int k = j+1; k <= G; k++)
            {
               for(int l = k+1; l <= G; l++)
               {
                  for(int m = l+1; m <= G; m++)
                  {
                     if(big(vit,sum(feed[i],sum(feed[k],sum(feed[l],sum(feed[m],feed[j])))))&&notFound)
                     {
                        out.println("5 "+i+" "+j+" "+k+" "+l+" "+m);
                        notFound = false;
                     }      
                  }  
               }
            }
         }
      }
      for(int i = 1; i <= G; i++)
      {
         for(int j = i+1; j <= G; j++)
         {
            for(int k = j+1; k <= G; k++)
            {
               for(int l = k+1; l <= G; l++)
               {
                  for(int m = l+1; m <= G; m++)
                  {
                     for(int n = m+1; n <= G; n++)
                     {
                        if(big(vit,sum(feed[i],sum(feed[k],sum(feed[l],sum(feed[m],sum(feed[n],feed[j]))))))&&notFound)
                        {
                           out.println("6 "+i+" "+j+" "+k+" "+l+" "+m+" "+n);
                           notFound = false;
                        }      
                     }  
                  }
               }
            }
         }
      }
      for(int i = 1; i <= G; i++)
      {
         for(int j = i+1; j <= G; j++)
         {
            for(int k = j+1; k <= G; k++)
            {
               for(int l = k+1; l <= G; l++)
               {
                  for(int m = l+1; m <= G; m++)
                  {
                     for(int n = m+1; n <= G; n++)
                     {
                        for(int o = n+1; o <= G; o++)
                        {
                           if(big(vit,sum(feed[i],sum(feed[k],sum(feed[l],sum(feed[m],sum(feed[n],sum(feed[o],feed[j])))))))&&notFound)
                           {
                              out.println("7 "+i+" "+j+" "+k+" "+l+" "+m+" "+n+" "+o);
                              notFound = false;
                           }     
                        } 
                     }  
                  }
               }
            }
         }
      }
      for(int i = 1; i <= G; i++)
      {
         for(int j = i+1; j <= G; j++)
         {
            for(int k = j+1; k <= G; k++)
            {
               for(int l = k+1; l <= G; l++)
               {
                  for(int m = l+1; m <= G; m++)
                  {
                     for(int n = m+1; n <= G; n++)
                     {
                        for(int o = n+1; o <= G; o++)
                        {
                           for(int p = o+1; p <= G; p++)
                           {
                              if(big(vit,sum(feed[i],sum(feed[k],sum(feed[l],sum(feed[m],sum(feed[n],sum(feed[o],sum(feed[p],feed[j]))))))))&&notFound)
                              {
                                 out.println("8 "+i+" "+j+" "+k+" "+l+" "+m+" "+n+" "+o+" "+p);
                                 notFound = false;
                              }     
                           }
                        } 
                     }  
                  }
               }
            }
         }
      }
      for(int i = 1; i <= G; i++)
      {
         for(int j = i+1; j <= G; j++)
         {
            for(int k = j+1; k <= G; k++)
            {
               for(int l = k+1; l <= G; l++)
               {
                  for(int m = l+1; m <= G; m++)
                  {
                     for(int n = m+1; n <= G; n++)
                     {
                        for(int o = n+1; o <= G; o++)
                        {
                           for(int p = o+1; p <= G; p++)
                           {
                              for(int q = p+1; q <= G; q++){
                                 if(big(vit,sum(feed[i],sum(feed[k],sum(feed[l],sum(feed[m],sum(feed[n],sum(feed[o],sum(feed[p],sum(feed[q],feed[j])))))))))&&notFound)
                                 {
                                    out.println("9 "+i+" "+j+" "+k+" "+l+" "+m+" "+n+" "+o+" "+p+" "+q);
                                    notFound = false;
                                 }     
                              }
                           }
                        } 
                     }  
                  }
               }
            }
         }
      }
      for(int i = 1; i <= G; i++)
      {
         for(int j = i+1; j <= G; j++)
         {
            for(int k = j+1; k <= G; k++)
            {
               for(int l = k+1; l <= G; l++)
               {
                  for(int m = l+1; m <= G; m++)
                  {
                     for(int n = m+1; n <= G; n++)
                     {
                        for(int o = n+1; o <= G; o++)
                        {
                           for(int p = o+1; p <= G; p++)
                           {
                              for(int q = p+1; q <= G; q++){
                                 for(int r = q+1; r <= G; r++){
                                    if(big(vit,sum(feed[i],sum(feed[k],sum(feed[l],sum(feed[m],sum(feed[n],sum(feed[o],sum(feed[p],sum(feed[q],sum(feed[r],feed[j]))))))))))&&notFound)
                                    {
                                       out.println("10 "+i+" "+j+" "+k+" "+l+" "+m+" "+n+" "+o+" "+p+" "+q+" "+r);
                                       notFound = false;
                                    }     
                                 }
                              }
                           }
                        } 
                     }  
                  }
               }
            }
         }
      }
      for(int i = 1; i <= G; i++)
      {
         for(int j = i+1; j <= G; j++)
         {
            for(int k = j+1; k <= G; k++)
            {
               for(int l = k+1; l <= G; l++)
               {
                  for(int m = l+1; m <= G; m++)
                  {
                     for(int n = m+1; n <= G; n++)
                     {
                        for(int o = n+1; o <= G; o++)
                        {
                           for(int p = o+1; p <= G; p++)
                           {
                              for(int q = p+1; q <= G; q++){
                                 for(int r = q+1; r <= G; r++){
                                    for(int s = r+1; s <=G; s++){
                                       if(big(vit,sum(feed[i],sum(feed[k],sum(feed[l],sum(feed[m],sum(feed[n],sum(feed[o],sum(feed[p],sum(feed[q],sum(feed[r],sum(feed[s],feed[j])))))))))))&&notFound)
                                       {
                                          out.println("11 "+i+" "+j+" "+k+" "+l+" "+m+" "+n+" "+o+" "+p+" "+q+" "+r+" "+s);
                                          notFound = false;
                                       }     
                                    }
                                 }
                              }
                           }
                        } 
                     }  
                  }
               }
            }
         }
      }
      for(int i = 1; i <= G; i++)
      {
         for(int j = i+1; j <= G; j++)
         {
            for(int k = j+1; k <= G; k++)
            {
               for(int l = k+1; l <= G; l++)
               {
                  for(int m = l+1; m <= G; m++)
                  {
                     for(int n = m+1; n <= G; n++)
                     {
                        for(int o = n+1; o <= G; o++)
                        {
                           for(int p = o+1; p <= G; p++)
                           {
                              for(int q = p+1; q <= G; q++){
                                 for(int r = q+1; r <= G; r++){
                                    for(int s = r+1; s <=G; s++){
                                       for(int t = s+1; t <= G; t++){
                                          if(big(vit,sum(feed[i],sum(feed[k],sum(feed[l],sum(feed[m],sum(feed[n],sum(feed[o],sum(feed[p],sum(feed[q],sum(feed[r],sum(feed[s],sum(feed[t],feed[j]))))))))))))&&notFound)
                                          {
                                             out.println("12 "+i+" "+j+" "+k+" "+l+" "+m+" "+n+" "+o+" "+p+" "+q+" "+r+" "+s+" "+t);
                                             notFound = false;
                                          }     
                                       }
                                    }
                                 }
                              }
                           }
                        } 
                     }  
                  }
               }
            }
         }
      }
      for(int i = 1; i <= G; i++)
      {
         for(int j = i+1; j <= G; j++)
         {
            for(int k = j+1; k <= G; k++)
            {
               for(int l = k+1; l <= G; l++)
               {
                  for(int m = l+1; m <= G; m++)
                  {
                     for(int n = m+1; n <= G; n++)
                     {
                        for(int o = n+1; o <= G; o++)
                        {
                           for(int p = o+1; p <= G; p++)
                           {
                              for(int q = p+1; q <= G; q++){
                                 for(int r = q+1; r <= G; r++){
                                    for(int s = r+1; s <=G; s++){
                                       for(int t = s+1; t <= G; t++){
                                          for(int u = t+1; u <= G; u++){
                                             if(big(vit,sum(feed[i],sum(feed[k],sum(feed[l],sum(feed[m],sum(feed[n],sum(feed[o],sum(feed[p],sum(feed[q],sum(feed[r],sum(feed[s],sum(feed[t],sum(feed[u],feed[j])))))))))))))&&notFound)
                                             {
                                                out.println("13 "+i+" "+j+" "+k+" "+l+" "+m+" "+n+" "+o+" "+p+" "+q+" "+r+" "+s+" "+t+" "+u);
                                                notFound = false;
                                             }    
                                          } 
                                       }
                                    }
                                 }
                              }
                           }
                        } 
                     }  
                  }
               }
            }
         }
      }
      for(int i = 1; i <= G; i++)
      {
         for(int j = i+1; j <= G; j++)
         {
            for(int k = j+1; k <= G; k++)
            {
               for(int l = k+1; l <= G; l++)
               {
                  for(int m = l+1; m <= G; m++)
                  {
                     for(int n = m+1; n <= G; n++)
                     {
                        for(int o = n+1; o <= G; o++)
                        {
                           for(int p = o+1; p <= G; p++)
                           {
                              for(int q = p+1; q <= G; q++){
                                 for(int r = q+1; r <= G; r++){
                                    for(int s = r+1; s <=G; s++){
                                       for(int t = s+1; t <= G; t++){
                                          for(int u = t+1; u <= G; u++){
                                             for(int v = u+1; v <= G; v++){
                                                if(big(vit,sum(feed[i],sum(feed[k],sum(feed[l],sum(feed[m],sum(feed[n],sum(feed[o],sum(feed[p],sum(feed[q],sum(feed[r],sum(feed[s],sum(feed[t],sum(feed[u],sum(feed[v],feed[j]))))))))))))))&&notFound)
                                                {
                                                   out.println("14 "+i+" "+j+" "+k+" "+l+" "+m+" "+n+" "+o+" "+p+" "+q+" "+r+" "+s+" "+t+" "+u+" "+v);
                                                   notFound = false;
                                                }    
                                             }
                                          } 
                                       }
                                    }
                                 }
                              }
                           }
                        } 
                     }  
                  }
               }
            }
         }
      }
      for(int i = 1; i <= G; i++)
      {
         for(int j = i+1; j <= G; j++)
         {
            for(int k = j+1; k <= G; k++)
            {
               for(int l = k+1; l <= G; l++)
               {
                  for(int m = l+1; m <= G; m++)
                  {
                     for(int n = m+1; n <= G; n++)
                     {
                        for(int o = n+1; o <= G; o++)
                        {
                           for(int p = o+1; p <= G; p++)
                           {
                              for(int q = p+1; q <= G; q++){
                                 for(int r = q+1; r <= G; r++){
                                    for(int s = r+1; s <=G; s++){
                                       for(int t = s+1; t <= G; t++){
                                          for(int u = t+1; u <= G; u++){
                                             for(int v = u+1; v <= G; v++){
                                                for(int w = v+1; w <= G; w++){
                                                   if(big(vit,sum(feed[i],sum(feed[k],sum(feed[l],sum(feed[m],sum(feed[n],sum(feed[o],sum(feed[p],sum(feed[q],sum(feed[r],sum(feed[s],sum(feed[t],sum(feed[u],sum(feed[v],sum(feed[w],feed[j])))))))))))))))&&notFound)
                                                   {
                                                      out.println("15 "+i+" "+j+" "+k+" "+l+" "+m+" "+n+" "+o+" "+p+" "+q+" "+r+" "+s+" "+t+" "+u+" "+v+" "+w);
                                                      notFound = false;
                                                   }    
                                                }
                                             }
                                          } 
                                       }
                                    }
                                 }
                              }
                           }
                        } 
                     }  
                  }
               }
            }
         }
      }
      out.close();
   }
   public static int[] sum(int[] a, int[] b)
   {
      int[] temp = new int[a.length];
      for(int i = 0; i < a.length; i++)
      {
         temp[i] = a[i]+b[i];
      }
      return temp;
   }
   public static boolean big(int[] a, int[] b){
      for(int i = 0; i < a.length; i++)
      {
         if(a[i]>b[i])
            return false;
      }
      return true;
   }
}