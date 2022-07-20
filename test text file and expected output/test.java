import java.io.*;
import java.util.*;

class test{
    public static void main(String[] args){
	if(args.length != 1 ){ //make sure the model output is provided
	    System.out.println("Please provide only the file containing the expected output from OddWords"); 
	}
	else{	   
	    try{
	    	//lists to store the actual output from OddWords and the expected output
	    	ArrayList<String> oddWordsOutput = new ArrayList<String>();	    	
	    	ArrayList<String> expectedOutput = new ArrayList<String>();
		Scanner s = new Scanner(System.in);
				
		if(!s.hasNext()) { //make sure input is provided
			s.close();
			System.out.println("Please provide the input from OddWords to check if the expected output has been produced");
		}
		else{
			//read in the output of OddWords
			while (s.hasNextLine()) {
				oddWordsOutput.add(s.nextLine());			
			}
			s.close();
			
			//read in the expected output from the file
			BufferedReader in = new BufferedReader(new FileReader(args[0]));
			while(in.ready() == true){			    
			    expectedOutput.add(in.readLine());					    
			}					
			in.close(); 
			
			//if the two lists aren't the same length then they aren't the same
			if(oddWordsOutput.size() != expectedOutput.size()){
				System.out.println("The expected vs actual inputs are different lengths");
			}
			else{ //compare each line in the two lists to see if they have the same contents
				for(int i = 0; i < expectedOutput.size(); i++){
					if(!expectedOutput.get(i).equals(oddWordsOutput.get(i))){
						System.out.println("Mismatch on line " + i + ": " );
						System.out.println("Expect: |" + expectedOutput.get(i) + "|");
						System.out.println("Actual: |" + oddWordsOutput.get(i) + "|");
						return;
					}
				}
				System.out.println("Everything matched!");
			}
		}
	    }
	    catch(Exception e){
		System.err.println("Exception: " + e);
	    }    
	    
	}  
    }
}
