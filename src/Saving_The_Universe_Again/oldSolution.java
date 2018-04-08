package Saving_The_Universe_Again;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

class oldSolution {
	public static void main1s(String[] args) {
		
	    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));	
		
	    int noOfTestCases = in.nextInt();

	    for(int i=0; i<noOfTestCases; i++) {
	    		int strength = 1, charge = 0;
	    		
	    		int maxShieldDamage = in.nextInt();
	    		String robotProgram = in.next().toUpperCase();
		
	    		int totalDamage = getTotalDamage(robotProgram);			
	    		
	    		if(maxShieldDamage >= totalDamage) {
	    			System.out.println("Case #" + (i+1) + ": 0");
	    		}
	    		else {
	    			int count = 0;

	    			char[] c = robotProgram.toCharArray();
	    			
	    			for(int j = 0; j<robotProgram.length(); j++) {
	    				
	    				char temp = c[j];
	    				c[j] = c[j+1];
	    				c[j+1] = temp;
		    			String newProgram = new String(c);
	    				System.out.println(newProgram);

		    			count++;
	    				totalDamage = getTotalDamage(newProgram);
	    				
	    				if(maxShieldDamage >= totalDamage) {
	    	    				System.out.println("Case #" + (i+1) + ": " + count);
	    	    				
	    				}
	    				else if(count == (robotProgram.length()-1)) {
	    					count++;
	    					if(totalDamage > maxShieldDamage) {
	    						System.out.println("Case #" + (i+1) + ": IMPOSSIBLE");
			    				
	    					}
    						System.out.println("Case #" + (i+1) + ": " + count);

	    				}
	    				else {
	    					continue;
	    				}
	    			
	    			}
	    		}
			
			
	    }
	    in.close();
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


