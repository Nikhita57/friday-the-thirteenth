/*
ID: nikhita1
LANG: JAVA
PROG: friday
*/
import java.io.*;
public class friday {

	public static void main(String[] args) {
		int year = 1900;
		int day = 1;
		int month = 1;
		int mday = 1;
		int[] friarray = new int[7];
		
		 try {
		     @SuppressWarnings("resource")
			BufferedReader br = new BufferedReader(new FileReader("friday.in"));
	         int n = Integer.parseInt(br.readLine());  
	         while (year <= (1900+n-1)) {
	        	if (mday == 13) {
					friarray[(day-6)%7]++;
				}
				if (mday == 30 && (month == 4 || month == 6 || month == 9 || month == 11)) {
					mday = 1;
					month++;
										
				} else if (mday == 29 && month == 2 && 
						((year % 4 == 0 && year % 100 != 0) || (year % 100 == 0 && year % 400 == 0))) {
					mday = 1;
					month++;
										
			   } else if (mday == 28 && month == 2 && 
						!((year % 4 == 0 && year % 100 != 0) || (year % 100 == 0 && year % 400 == 0))) {
				    mday = 1;
				    month++;
				    									   
			  } else if (mday == 31 && month == 12) {
				 mday = 1;
				 month = 1;
				 year++;
				 				 
			  } else if (mday == 31) {
				mday = 1;
				month++;
								
			  } else {
				mday++;
				  
			  }
              day++;
				
			 }
	      } catch(Exception e) {
	         e.printStackTrace();
	     
	    }
		 
		
		 
		 

		 FileOutputStream out;
			try {
				out = new FileOutputStream("friday.out");
				String days = friarray[0] + "";
				for (int i = 1; i < friarray.length; i++) {	
					days += " " + friarray[i];
				}
                days += "\n";
				out.write(days.getBytes());
			    out.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}

}
