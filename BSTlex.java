class BSTlex{
    private BSTlex left = null;
    private BSTlex right = null;
    private BSTlex parent = null;
    private String root = null;

    /*
     * inserts the passed in string to a BST (in alphabetical order) and creates two empty BST in the left and right pointers to store future values  
     * prints out the search path as it searches where to insert to the word an then the "*wordBeingInserted* INSERTED" when the word is being inserted
     */
    public void insert(String word){
	//if the passed in word is null we will not insert it into the tree so return
	if(word == null)
	    return;
	
	//If the root is null then we can insert our word into this BST
	if(root == null){
	    root = word; //add our word to be the root of the BST
	    //create two empty BST to the left and right of this BST to store future strings
	    left = new BSTlex(); 
	    right = new BSTlex();
	    //link the children to have this BST as the parent
	    left.parent = this;
	    right.parent = this;
	    //print out the word so we know it has been inserted
	    System.out.println(root + " INSERTED"); 
	}
	//keep searching the tree for the word and printing the search path
	else{
	    System.out.print(root + " ");
	    //if the string comes before the current root it belongs in the left subtree
	    if(word.compareTo(root) < 0)
		left.insert(word);
	    //otherwise the string comes after or is equal to the string in the root so insert it in the right subtree
	    else
		right.insert(word);
	}
	return;
    }

    /*
     * searches the tree for the passed in string, if it finds the word it is removed from the tree if the word is not found the method
     * returns without doing anything
     */
    public void remove(String word, boolean printSearchPath){
	//We have reached a leaf node it has no further subtrees so the word isn't in the tree and therefore we can't remove it so return
	//or the passed in word is null so it cannot exist in the tree (null words are not allowed to be inserted into the tree)
        if(root == null || word == null)
            return;
	
        //if the word is the word in the root we have found the word to remove
        if(root.equals(word)){
	    if(printSearchPath){ //only print the earch path if we are not internally restructuring the tree
            	System.out.println(root + " DELETED");
            }
	    //If this BST is a leaf node (its left and right BST roots are null - has no children)
	    if(this.left.root == null && this.right.root == null ){		
		//make the root, left and right subtrees null and return
		root = null;
		left = null;
		right = null;
		return;
	    }
	    //check if this BST only has one child
	    else if(this.left.root == null && this.right.root != null || this.left.root != null && this.right.root == null){
		//flags to check which node is the child and what child of its parent the node is  
		boolean leftChild = false;
		boolean leftChildOfParent = false;
		//Check if this BST has a left child (otherwise it has a right child)
		if(this.left.root != null)
		    leftChild = true;
		
		//Check if this BST doesn't have a parent node (is the root of the entire tree)
		if(this.parent == null){		    		    		    
		    String tmp = "";
		    //if the BST has a left child
		    if(leftChild){
			//retrieve the biggest (alphabetically) word in the left subtree (when it is copied into this node everything in the left subtree
			//will be less than it) 
			tmp = left.largestWord();			
			left.remove(tmp, false); //delete the BST containing this word that will be copied into this BST and dont print the search path as we are internally restructuring		 
		    }
		    //the BST has a right child
		    else{
			//retrieve the smallest (alphabetically) word in the right subtree (when it is copied into this node everything in the right subtree
			//will be greater than it) 
			tmp = right.smallestWord();
			right.remove(tmp, false); //delete the BST containing this word that will be copied into this BST and dont print the search path as we are internally restructuring		 		
		    }
		    //copy the retrieved word into the root of this tree
		    this.root = tmp;		    
		    return;	    
		}
		else{
		    //check if this BST is the left or right child of it's parent BST. if it is the left child the root will be alphabetically
		    //before the parent's root otherwise it is the parent's right child
		    if(root.compareTo(parent.root) < 0)
			leftChildOfParent = true;
		    //if this BST is the left child of its parent make its parents left child node be the child of this BST
		    if(leftChildOfParent){
			if(leftChild){//if has left child link it to its grandparent BST
			    this.parent.left = this.left; //update the grandparent BST to have its grandchild as its child 
			    this.left.parent = this.parent; // update the grandchild BST to have its grandparent as its parent			    
			}
			else{//link the right child of this BST to its grandparent BST
			    this.parent.left = this.right; //update the grandparent BST to have its grandchild as its child
			    this.right.parent = this.parent; // update the grandchild BST to have its grandparent as its parent			    
			}
		    }
		    //update the BST so its parents right child is the child of this BST
		    else{
			if(leftChild){//if has left child link it to its grandparent BST
                            this.parent.right = this.left; //update the grandparent BST to have its grandchild as its child
                            this.left.parent = this.parent; // update the grandchild BST to have its grandparent as its parent
                        }
                        else{//link the right child of this BST to its grandparent BST
                            this.parent.right = this.right; //update the grandparent BST to have its grandchild as its child
                            this.right.parent = this.parent; // update the grandchild BST to have its grandparent as its parent
                        }                        
		    }	
		    //Make this node completely null
		    this.left = null; 
	            this.right = null;
	            this.parent = null;
		    this.root = null;
		    return;
		}
	    }
	    //this BST has two children
	    else{
		//find the smallest (alphabetically) word in the right subtree of the node
		String tmp = right.smallestWord();
		//copy the value into the root of this tree
		this.root = tmp;		
		//delete the BST containing the smallest (alphabetically) word that has just been copied into this node and dont print the search path as we are internally restructuring		
		right.remove(tmp, false);		
		return;
	    }            	    
	}
	//we haven't found the word so keep searching for the word in the tree 
	else{
	    if(printSearchPath){ //only print the search path if we are not internally restructuring the tree
	    	System.out.print(root + " ");  
	    }
	    //if the word comes before the root of this BST search to see if it is in the left subtree
	    if(word.compareTo(root) < 0){
		left.remove(word, printSearchPath);
	    }
	    else{
	    	//otherwise the word comes after the root so check to see if it is in the right subtree
	    	right.remove(word, printSearchPath);
	    }
	}
    }

    /*
     * retrieves the smallest (alphabetically) word from the tree 
     */
    private String smallestWord(){
	//if there is no left subtree then this is the smallest (alphabetically) word in the tree so return it
	if(left.root == null)
	    return root;
	//otherwise there is a smaller (alphabetically) word in the tree so retrieve it
	return left.smallestWord();
    }

    /*
     * retrieves the largest (alphabetically) word from the tree
     */
    private String largestWord(){
        //if there is no right subtree then this is the largest (alphabetically) word in the tree so return it
        if(right.root == null)
            return root;
        //otherwise there is a larger (alphabetically) word in the tree so retrieve it
        return right.smallestWord();
    }

    /*
     * Checks if the tree contains the passed in string, returns true if it exists in the tree otherwise it returns false 
     */
    public boolean has(String word){
	//We have reached a leaf node it has no further subtrees so the word isn't in the tree or the passed in string is null so it isn't in the tree 
	if(root == null || word == null)
	    return false;
	//if the word is the word in the root we have found it  
	if(root.equals(word))
	    return true;
	//if the word comes before the root search to see if it is in the left subtree
	if(word.compareTo(root) < 0)
	    return left.has(word);
	//otherwise the word comes after the root so check to see if it is in the right subtree
	return right.has(word);	    
    }

    /*
     * returns the height of the tree (greatest length from root to leaf)
     */
    public int height(){
	//if the root is null this is a leaf node so return -1 
	if(root == null){
	    return -1;
	}	
	else{ 
	    //calculate the heights of the left and right subtrees
	    int leftHeight = left.height();
	    int rightHeight = right.height();
	    //returns the greater of the two heights plus one (to account for this node) as the height of the tree
	    if(leftHeight > rightHeight){
		return 1 + leftHeight;
	    }
	    else{
		return 1 + rightHeight;
	    }
	}	
    }
    
    /*
     * prints out each node in the tree in alphabetical order and returns the number of nodes in the tree
     */
    public int traverse(){
	int countNodes = 0;    
	//if root is null then we are at a leaf node and can't go any further so return
	if(root == null)
	    return 0;
	//process the words in the left subtree (they come alphabetically before this word)
	countNodes += left.traverse();
	//print out the root as it is the next thing in alphabetical order
	System.out.println(root);
	countNodes++;
	//process the words in the right subtree (they come alphabetically after this word)
	countNodes += right.traverse();	
	return countNodes; //number of nodes in the tree
    }
}
