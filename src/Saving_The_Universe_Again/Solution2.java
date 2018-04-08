package Saving_The_Universe_Again;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.lang.*;

public class Solution2 {

    public static void main(String[] args) {
       
           Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
          // int noOfTestCases = in.nextInt();
          
           //for(int i=0; i<noOfTestCases; i++) {
              
               int noOfElements = in.nextInt();
              
              
              
             
          // int arr[] = new int[noOfElements]; // get number of elements for each test case

               for(int j=0; j<noOfElements; j++) {
                  
                   int d=in.nextInt();
                   String p=in.next();
                 
                   int f=0;
                  int status= operation(d,p,0,f);
                  if(status==1) {
                       System.out.println("Case #" + (j+1) + ":" + " Impossible");
                      
                   }
                   else {
                      
                      // System.out.println("Case #" + (j+1) + ": " + "ok");

                   }
         
                  
               }
              
           //}     

    }

    public static int check(int d,String p) {
        int strength=1;
        int loss=0;
        int a=0;
        int status=1;
        int h=p.length();
       for(int i=0;i<p.length();i++) {
          
          if(p.charAt(i)=='c') {
             strength=2*strength;
          }
          else {
              loss+=strength;
          }
                  
       }
       return loss;
    }
    public static int operation(int d, String p,int o,int f) {
       
        int strength=1;
        int loss=0;
        int a=0;
        int status=1;   
        int h=p.length();
       for(int i=0;i<p.length();i++) {
          
          if(p.charAt(i)=='c') {
             strength=2*strength;
          }
          else {
              loss+=strength;
          }
                  
       }
      
         //System.out.println(loss );
            if(loss>d) {
                //System.out.println("hello");
                if(o+1>=p.length())
                    o=0;
                //System.out.println(o);
               
                for(int m=o;m<p.length();m++)
                {
                    if((p.charAt(m)=='c' && p.charAt(m+1)=='s')) {
                        o=m;
                    if(o+1>=p.length())
                           o=0;
                          
                        p=swap(p,m,m+1,f++);
                        // System.out.println(p);
                         int val=check(d,p);
                         if(val<loss) {
                             status=operation(d,p,o+1,f);
                             if(status==0)
                                 return 0;
                         }
                    }
                }
               
                 //p=swap(p,k,k+1);
          //System.out.println(p);
       
         }
         else {
             //System.out.println("hi");
             status=0;
             System.out.println(f);
             return status;
             
         }


        return status;
       
       
    //    return
    }

    public static String swap(String str, int i, int j,int f)
    {     
        //System.out.println(str.charAt(i)+" "+str.charAt(j));
        StringBuilder sb = new StringBuilder(str);
        sb.setCharAt(i, str.charAt(j));
        sb.setCharAt(j, str.charAt(i));
        //System.out.println(str.charAt(i)+" "+str.charAt(j));
        return sb.toString();
    }
 
}