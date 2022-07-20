# binary-search-tree
BSTlex.java - a simple implentation of a binary search tree (note: it is NOT height-balanced) <br /> 
OddWords.java - using a provided text file tests the implementation of the BSTlex class <br /> 
TestBSTlex.java - JUnit tests for the functionality of the BSTlex class <br /> 

To run the program after compilation: <br /> 
java OddWords textfile.txt <br /> 
where textfile.txt is the name of the textfile to be used to demonstrate maintaining a binary search tree (BST) of words (word in this context means a contiguous sequence of alpha-numeric characters)<br /> 

OddWords takes in a text file and tokenises each line splitting on non alpha-numeric characters, for each produced token it then checks if the token exists in the BST or not: <br /> 
If the token does not exist in the BST it is inserted into it, the search path is printed ending with the token being inserted plus "INSERTED" <br /> 
If the token does exist in the BST it is deleted from it, the search path is printed ending with the token being deleted plus "DELETED" <br /> 
After the full file has been processed, an in-order traversal of the BST is printed along with the height of the BST (height is the longest path from root to a leaf) <br /> <br /> 

The JUnit tests written in TestBSTlex.java work for JUnit 4 <br /> 
To get the files required to be able to run the test file: <br /> 
wget -O junit-4.13.2.jar "https://search.maven.org/remotecontent?filepath=junit/junit/4.13.2/junit-4.13.2.jar" <br /> 
wget -O hamcrest-core-1.3.jar "https://search.maven.org/remotecontent?filepath=org/hamcrest/hamcrest-core/1.3/hamcrest-core-1.3.jar" <br /> 

To run the TestBSTlex file:<br /> 
javac -cp .:junit-4.13.2.jar:hamcrest-core-1.3.jar TestBSTlex.java <br /> 
java -cp .:junit-4.13.2.jar:hamcrest-core-1.3.jar org.junit.runner.JUnitCore TestBSTlex <br /> <br />

In the "test text file and expected output" directory there is an example text file (testFile.txt) and what the expected output from OddWords when given that file is. <br />
It can be tested to be seen if they match using the test.java file: <br />
java OddWords testFile.txt | java test expectedOutput.txt <br />
When the expected output matches the actual output from OddWords a success message is printed, otherwise the first point where there is no match is displayed
