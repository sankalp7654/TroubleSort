package Saving_The_Universe_Again;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

class Solution1{
	public static void main12(String[] args) {
		
	    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));	
		
	    int noOfTestCases = in.nextInt();

	    for(int i=0; i<noOfTestCases; i++) {
	    		int strength = 1, charge = 0;
	    		
	    		int maxShieldDamage = in.nextInt();
	    		String robotProgram = in.next().toUpperCase();
	    		
	    		int stringLength = robotProgram.length();

		
	    		int robotDamage = getTotalDamage(robotProgram);
	    		System.out.println();
			System.out.println(robotDamage);

				
	    		if(maxShieldDamage >= robotDamage) {
    				System.out.println("Case #" + (i+1) + ": " + "0");	    		
	    		}
	    		else {
	    			char c[] = robotProgram.toCharArray();
	    			int count = 0;
	    			for(int j = 0; j<stringLength; j++) {
	    				
//	if((robotProgram.charAt(j) == 'C') &&(robotProgram.charAt(j+1) == 'S')) {
	    				int n = 0;
	    				int k = 0;
	    				boolean flag = true;
	    				int getBegIndex[] = new int[10000];

	    				while(flag) {
	    					if(robotProgram.contains("CS")) {
	    						n++;
	    						flag = true;
	    						 getBegIndex[k++] = robotProgram.indexOf("CS");
	    						 
	    							if(robotDamage <= maxShieldDamage) {
			    						++count;
			    						
			    					} 
		    					
		    						} else {
		    							continue;
		    						}
	    						 
	    						 
	    					}
	    					else {
	    						flag = false;
	    					}
	    				}

	    				
//	    				if(robotProgram.contains("CS")) {
//	    						int begIndex = robotProgram.indexOf("CS");
//	    						int endIndex = begIndex+1;
//	    						robotProgram = swap(robotProgram, begIndex, endIndex);
//	    						
//	    						
//	    				//		robotProgram = robotProgram.replace("CS", "SC");
//		    					robotDamage = getTotalDamage(robotProgram);
//		    					System.out.println(robotDamage);
//		
//	    				
//	    				
//		    					if(robotDamage <= maxShieldDamage) {
//		    						++count;
//		    						
//		    					} 
//	    					
//	    						} else {
//	    							continue;
//	    						}
//	    					
	    		//	}
	    			if(robotDamage > maxShieldDamage) {
						System.out.println("Case #" + (i+1) + ": IMPOSSIBLE");
	    					
				}
	    			else {
						System.out.println("Case #" + (i+1) + ": " + (count));
						
	    			}
	    			i++;
	    			}
	    	}
			
			
	  }
	    in.close();
	}
	
	 public static String swap(String str, int i, int j)
	    {
	        //System.out.println(str.charAt(i)+" "+str.charAt(j));
	        StringBuilder sb = new StringBuilder(str);
	        sb.setCharAt(i, str.charAt(j));
	        sb.setCharAt(j, str.charAt(i));
	        //System.out.println(str.charAt(i)+" "+str.charAt(j));
	        return sb.toString();
	    }
	
	public static int getTotalDamage(String robotProgram) {
		int damage = 0, strength = 1, charge = 0;
		for(int i = 0; i<robotProgram.length(); i++) {
			System.out.print(robotProgram.charAt(i));
			 
		if(robotProgram.charAt(i) == 'C') {
			strength = 2*strength;
			charge += strength;
		}
		else {
			
			damage += strength;
		}
		
		}
		System.out.println();
		return damage;
	}
}


