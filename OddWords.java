import java.io.*;

class OddWords{
    public static void main(String[] args){
	//check that a text file has been provided
	if(args.length < 1 ){
	    System.out.println("Please provide a file");
	}
	else{	    
	    BSTlex tree = new BSTlex(); //Create the BST			
	    
	    try{
		BufferedReader in = new BufferedReader(new FileReader(args[0]));
		
		//read each line in the file
		while(in.ready() == true){
		    //read a line from the file split on instances of non alpha-numeric characters
		    String line = in.readLine();		
		    String[] tokens = line.split("[^A-Za-z\\d]+");

		    //loop through all the strings in the tokens array 
		    for(int i = 0; i < tokens.length; i++){
			String word = tokens[i].toLowerCase();
			//if the tree contains the token remove the word from the BST and print the search path to the word
			if(tree.has(word)){
				tree.remove(word, true);
			}
			//if the tree does not contain the token insert it to the tree and print the search path to the word
			else{
				tree.insert(word);	
			}	
		    }
		}
				
		in.close(); //close the file		
		System.out.println("LEXICON: ");
		tree.traverse(); //Print out the in order traversal of the tree		
		System.out.println("Height: " + tree.height()); //Print out the height of the tree
	    }
	    catch(Exception e){
		System.err.println("Exception: " + e);
	    }    
	}  
    }
}
