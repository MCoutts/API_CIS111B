import java.net.*;
import java.io.*;
//okay let's start by using some packages of the Java API you may not have yet seen



//NOTE::  You probably can't answer these without reading ahead through the code and making some best guesses !
//Question 1 : why are we using java.net package ? What classes are used from that package ? which methods of those classes?
/*
 * 
 	The Java.net package uses classes:
 	 	- URLConnection that is a link between the application and an outside URL
 	 	- URL or Uniform Resource Locator, that directs to a "resource" on the World Wide Web.
  	
  	In this program the class URL defines the variable "epaServer" as a URL with the link given. 
  	
  	Next, URLConnection is used to establish a connection between this link and the program.  
 ___________________________________________________________________________________________________________________________________________
*/
//Question 2: why use the java.io package ? Which classes are we using ? why? which methods ? 
/*
 	Java.io allows data to stream in and out of the program.
 	The Java.io package used these classes: 
 		- InputStreamReader is a bridge from byte size streams to char steams. 
 			essentially it reads bytes and converts them into characters using a charset. 
 			
 		- BufferedReader reads text from a input-stream, it makes efficient reading of 
 		  characters, arrays, and lines. 
 
 */
//

public class API_PracticeEPA 
	{

	   // this first line states that the program may bail out , ie throw an Exception.
	   //Q2: using the java api page for the class URL, find what Exception the constructor for the URL class can throw
	   
	   public static void main(String[] args) throws Exception 
      {
	   
	       // for later.... ! 
          String [] zipCodes = new String[4]; 
          zipCodes [0] = "19422";
          zipCodes [1] = "19464";
          zipCodes [2] = "87101";
         
	       
	      // Now we are going to use a Web Service from the EPA, the Environmental Protection Agency.
	      //
	      // We'll create a query 
	      // and have the EPA server talk to our program and send us the information we request. This is the main
	      //mechanism for communication and xmission of information over the Internet, not printing to the screen!
	      //
	      //
	      // Two popular formats that allow two computers to communicate are XML and JSON. As beginners we'll 
	      // just use an easier format called CSV.
	      // Q3. What is CSV? 
	      /*
	       
	       		CSV is used to store tabular data such as a spreadsheet or database. 
	       		It can be used with but not limited to excel and google sheets. 
	       		
	       		CSV stands for "comma-seperated values" 
	       
	       
	       */
	      // Q4: Go to the documentation page for the EPA API. 
	      //   https://www.epa.gov/enviro/web-services#hourlyzip 
	      // Run this program with the URL query as it is written below. What happens?
	      // Copy the URL from the line below into a new tab of your browser. What does it return?
	      /*
	    
	    	Data for Albuquerque,NM including "ORDER","ZIP CODE","DATE TIME", and "UV VALUE". 
	    
	    	Copying the URL and opening it in a browser just initiated a download for the CSV spreadsheet. 
	    	The same data appeared in the spreedsheet as the code written. 
	    
	    
	    */
         for(int i = 0; i <= 3; i++)
         {
	       URL epaServer = new URL("https://iaspub.epa.gov/enviro/efservice/getEnvirofactsUVHOURLY/ZIP/" + zipCodes[i] + "/CSV" );
	       
	       
	       URLConnection ac = epaServer.openConnection();
	       
	       
	             
	      InputStreamReader inputStream = new InputStreamReader(ac.getInputStream(), "UTF-8");
	      BufferedReader bufferedReader = new BufferedReader(inputStream);
	      StringBuilder responseBuilder = new StringBuilder();
	      
	      
	      String line;
	       
	      while ((line = bufferedReader.readLine()) != null) 
            {
	        responseBuilder.append(line + "\n");
	         }
	      
	      bufferedReader.close();
	      
	      // would rather just have you look at this in the debugger, but for now we'll print ! 
	      System.out.println(responseBuilder.toString() );
         }
         
        	    
	   }
	   // Q5:: edit this program so that you query the EPA for UV levels at a list of locations (Central Campus, West Campus and Albuquerque, NM)
	   // Your program should automatically run through this list of locations and retrieve the data from the EPA for each.   
	          
	   // end of main
}


