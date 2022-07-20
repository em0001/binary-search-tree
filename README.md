# binary-search-tree
BSTlex.java - a simple implentation of a binary search tree (note: it is NOT height-balanced) <br /> 
OddWords.java - using a provided text file tests the implementation of the BSTlex class <br /> 

OddWords takes in a text file and tokenises each line splitting on non alpha-numeric characters, for each produced token it then checks if the token exists in the BST or not. <br /> 
If the token does not exist in the BST it is inserted into it, the search path is printed ending with the token being inserted plus "INSERTED" <br /> 
If the token does exist in the BST it is deleted from it, the search path is printed ending with the token being deleted plus "DELETED" <br /> 
After the full file has been processed, an in-order traversal of the BST is printed along with the height of the BST (height is the longest path from root to a leaf)

