import static org.junit.Assert.*;
import org.junit.Test;

public class TestBSTlex{
    
    @Test
    public void check_height()
    {
	/*
	 * check that height returns the correct height for the trees
	 */
	BSTlex tree = new BSTlex();
	BSTlex tree1 = new BSTlex();
	BSTlex tree2 = new BSTlex();
	BSTlex tree3 = new BSTlex();
	BSTlex tree4 = new BSTlex();
	//System.out.println("CHECK HEIGHT: ");
	tree.insert("apple"); tree.insert("banana"); tree.insert("cloud"); tree.insert("dinosaur"); tree.insert("cream");tree.insert("bread");
	tree1.insert("antelope"); tree1.insert("answer"); tree1.insert("anteater"); tree1.insert("bun"); tree1.insert("brain");tree1.insert("computer"); tree1.insert("dinosaur"); tree1.insert("crocodile");
	tree3.insert("dinosaur");	
	tree4.insert("pineapple"); tree4.insert("monday"); tree4.insert("rhino"); tree4.insert("orange"); tree4.insert("dinosaur");tree4.insert("skeleton"); tree4.insert("quack");	
	assertEquals("The tree should have a height of 4", 4, tree.height()); //apple, banana, cloud, dinosaur, cream, bread
	assertEquals("The tree should have a height of 4", 4, tree1.height()); //antelope, bun, computer, dinosaur, crocodile
	assertEquals("The tree should have a height of -1 it is empty", -1, tree2.height()); //empty tree
	assertEquals("The tree should have a height of 0 it is only one node", 0, tree3.height()); //dinosaur
	assertEquals("The tree should have a height of 2", 2, tree4.height()); //any of the paths the tree is completely balanced
	//System.out.println();
    }

    @Test
    public void check_traverse()
    {
        /*
         * check that traverse returns the correct number of nodes in the tree and prints them out in the correct (alphabetical) order
         */
	//System.out.println("CHECK TRAVERSE: ");
        BSTlex tree = new BSTlex();
        BSTlex tree1 = new BSTlex();
	BSTlex tree2 = new BSTlex();
	BSTlex tree3 = new BSTlex();
	BSTlex tree4 = new BSTlex();
	BSTlex tree5 = new BSTlex();
        tree.insert("zebra"); tree.insert("kitten"); tree.insert("crocodile"); tree.insert("rhino"); tree.insert("snake");tree.insert("kiwi"); tree.insert("lion"); tree.insert("stripes");             
	tree1.insert("antelope"); tree1.insert("kitten"); tree1.insert("anteater"); tree1.insert("anteater"); tree1.insert("ant");tree1.insert("zebra"); tree1.insert("rhino");
	tree3.insert("kitten");
	tree4.insert("kitten"); tree4.insert("cat");
	tree5.insert("kitten"); tree5.insert("cat"); tree5.insert("aligator"); tree5.insert("zebra"); tree5.insert("lemonade");
	//System.out.println("Should print: crocodile kitten kiwi lion rhino snake stripes zebra");
        assertEquals("The tree should contain 8 items", 8, tree.traverse());
	//System.out.println("Should print: ant anteater anteater antelope kitten rhino zebra");
	assertEquals("The tree should contain 7 items", 7, tree1.traverse());
	//System.out.println("Should print: (is an empty tree)");
        assertEquals("The tree should contain 0 items", 0, tree2.traverse());
	//System.out.println("Should print: kitten");
	assertEquals("The tree should contain 1 item", 1, tree3.traverse());
	//System.out.println("Should print: cat kitten");
	assertEquals("The tree should contain 2 items", 2, tree4.traverse());
	//System.out.println("Should print: aligator cat kitten lemonade zebra");
	assertEquals("The tree should contain 5 items", 5, tree5.traverse());
        //tree.traverse(); //print out: "crocodile kitten kiwi lion rhino snake stripes zebra"
        //tree1.traverse(); //print out: "ant anteater anteater antelope kitten rhino zebra" 
	//tree2.traverse(); //print out: 
	//tree3.traverse(); //print out: "kitten"
	//tree4.traverse(); //print out: "cat kitten"
	//tree5.traverse(); //print out: "aligator cat kitten lemonade zebra"
	//System.out.println();
    }
	
    @Test
    public void check_has()
    {
	/*
	 * check that has returns true when passed in a word that exists in the tree
	 */
	//System.out.println("CHECK HAS: ");
	BSTlex tree = new BSTlex();	
	tree.insert("kitten"); tree.insert("penguin"); tree.insert("crocodile"); tree.insert("rhino"); tree.insert("snake");tree.insert("kiwi"); 	
	assertTrue("The tree should contain kitten", tree.has("kitten"));
	assertTrue("The tree should contain penguin", tree.has("penguin"));
	assertTrue("The tree should contain crocodile", tree.has("crocodile"));
	assertTrue("The tree should contain rhino", tree.has("rhino"));
	assertTrue("The tree should contain snake", tree.has("snake"));
	assertTrue("The tree should contain kiwi", tree.has("kiwi"));
	//tree.traverse(); //print out everything in the tree (in order): "crocodile, kitten, kiwi, penguin, rhino, snake"
	//System.out.println();
    }

    @Test
    public void check_insertAndRemove_null(){
	/*
	 * check that insert and remove does not allow a null string to be processed
	 */
	//System.out.println("CHECK INSERT AND REMOVE NULL: ");
	BSTlex tree = new BSTlex();
	String penguin = null;
	tree.insert("kitten"); tree.insert(penguin); //attempt to add a null string to the list
	assertTrue("The tree should contain kitten", tree.has("kitten"));
	assertFalse("The tree should not contain the null string penguin", tree.has(penguin));
	//System.out.println("Should print: kitten");
	assertEquals("The tree should contain 1 item", 1, tree.traverse());
	tree.remove(penguin, true); //trying to remove a null string from the list
	//System.out.println("Should print: kitten");
	assertEquals("The tree should contain 1 item", 1, tree.traverse());
	assertTrue("The tree should contain kitten", tree.has("kitten"));	
    }

    @Test
    public void check_insert_duplicates()
    {
        /*
         * check that insert allows adding duplicates to the tree and reports the correct number of items and height
         */
	//System.out.println("CHECK INSERT DUPLICATES: ");
        BSTlex tree = new BSTlex();
        BSTlex tree1 = new BSTlex();
        tree.insert("kitten"); tree.insert("kitten"); tree.insert("crocodile"); tree.insert("rhino"); tree.insert("snake");tree.insert("kiwi"); tree.insert("rhino");
        tree.insert("crocodile"); tree.insert("kiwi"); tree.insert("snake");
        tree1.insert("kitten"); tree1.insert("kitten"); tree1.insert("crocodile"); tree1.insert("rhino"); tree1.insert("snake");tree1.insert("kiwi"); tree1.insert("rhino");
	//System.out.println("Should print: crocodile, crocodile kitten, kitten kiwi, kiwi, rhino, rhino, snake, snake");
        assertEquals("The tree should contain 10 items", 10, tree.traverse());
	//System.out.println("Should print: crocodile, kitten, kitten kiwi, rhino, rhino, snake");	
        assertEquals("The tree should contain 7 items", 7, tree1.traverse());
        assertEquals("The tree should have a height of 4", 4, tree.height());
        assertEquals("The tree should have a height of 4", 4, tree1.height());
	//System.out.println();
    }

    @Test
    public void check_hasDoesNotExist()
    {
        /*
         * check that has returns false when passed in a word that does not exist in the tree
         */
	//System.out.println("CHECK HAS DOES NOT EXIST: ");
        BSTlex tree = new BSTlex();
        tree.insert("kitten"); tree.insert("penguin"); tree.insert("crocodile"); tree.insert("rhino"); tree.insert("snake");tree.insert("kiwi");
        assertFalse("The tree should not contain kittens", tree.has("kittens"));
        assertFalse("The tree should not contain pavlova", tree.has("pavlova"));
        assertFalse("The tree should not contain penguin", tree.has("zebra"));
	assertFalse("The tree should not contain an empty string", tree.has(""));
        assertFalse("The tree should contain kiwifruit", tree.has("kiwifruit"));
        tree.traverse(); //print out everything in the tree (in order): "crocodile, kitten, kiwi, penguin, rhino, snake"
	//System.out.println();
    }

    @Test
    public void check_remove_onlyNode()
    {
	/*
	 * check that after adding one item to the BST and then removing it reports the height as -1 and that there are no nodes in the tree
	 */
	//System.out.println("CHECK REMOVE ONLY NODE: ");
	BSTlex tree = new BSTlex();
	tree.insert("kitten");
	assertEquals("The tree should have a height of 0 as it contains 1 item", 0, tree.height());
	//System.out.println("Tree before removing only node should print: kitten");
	assertEquals("The tree should contain 1 node", 1, tree.traverse());	
	tree.remove("kitten", true);
	assertEquals("The tree should have a height of -1 as it has 0 items", -1, tree.height());
	//System.out.println("Tree after removing only node should print: (nothing is an empty tree)");	
	assertEquals("The tree should contain 0 nodes", 0, tree.traverse());		
	//System.out.println();
    }

    @Test
    public void check_remove_leafNode()
    {
        /*
         * check that removing a leaf node results in maintaining the correct ordering of the traverse
	 * and the number of nodes decreases by 1
         */	
	//System.out.println("CHECK REMOVE LEAF NODE: ");
        BSTlex tree = new BSTlex();
        tree.insert("kitten"); tree.insert("panda"); tree.insert("anteater"); tree.insert("tiger"); tree.insert("monkey"); tree.insert("fox");
	//System.out.println("Tree before removing a leaf node should print: anteater fox kitten monkey panda tiger");	
        assertEquals("The tree should have a height of 2", 2, tree.height());
	assertEquals("The tree should contain 6 nodes", 6, tree.traverse());
	tree.remove("monkey", true);
	//System.out.println("Tree after removing the leaf node (monkey): should print out anteater fox kitten panda tiger");
	assertEquals("The tree should have a height of 2", 2, tree.height());
	assertEquals("The tree should contain 5 nodes", 5, tree.traverse());
	//System.out.println();
    }

    @Test
    public void check_remove_nodeWithOneChild()
    {
        /*
         * check that removing a node with a one child results in maintaining the correct oreding of traverse
	 * and the number of nodes decreases by 1
         */
	//System.out.println("CHECK REMOVE NODE WITH ONE CHILD: ");
        BSTlex tree = new BSTlex();
	BSTlex tree1 = new BSTlex();
        tree.insert("kitten"); tree.insert("panda"); tree.insert("anteater"); tree.insert("tiger"); tree.insert("monkey"); tree.insert("fox");
	tree1.insert("kitten"); tree1.insert("panda"); tree1.insert("anteater"); tree1.insert("tiger"); tree1.insert("monkey"); tree1.insert("fox");
        tree1.insert("banana"); tree1.insert("free");
        //System.out.println("Trees before removing a node with one child: ");
        assertEquals("The tree should have a height of 2", 2, tree.height());
	//System.out.println("Should print: anteater fox kitten monkey panda tiger");
        assertEquals("The tree should contain 6 nodes", 6, tree.traverse());
	assertEquals("The tree should have a height of 3", 3, tree1.height());
	//System.out.println("Should print: anteater banana fox free kitten monkey panda tiger");
	assertEquals("The tree should contain 8 nodes", 8, tree1.traverse());
        tree.remove("anteater", true);
	tree1.remove("anteater", true);
        //System.out.println("Trees after removing the node with one child (anteater): ");
        assertEquals("The tree should have a height of 2", 2, tree.height());
	//System.out.println("Should print: fox, kitten monkey panda tiger");
        assertEquals("The tree should contain 5 nodes", 5, tree.traverse());
	assertEquals("The tree should have a height of 2", 2, tree1.height());
	//System.out.println("Should print: banana fox free kitten monkey panda tiger");
	assertEquals("The tree should contain 7 nodes", 7, tree1.traverse());
	//System.out.println();
    }

    @Test
    public void check_remove_nodeWithTwoChildren()
    {
        /*
	 * check that removing a node with a two children results in maintaining the correct oreding of traverse
         * and the number of nodes decreases by 1
         */
	//System.out.println("CHECK REMOVE NODE WITH TWO CHILDREN: ");
        BSTlex tree = new BSTlex();
	BSTlex tree1 = new BSTlex();
	BSTlex tree2 = new BSTlex();
        tree.insert("kitten"); tree.insert("panda"); tree.insert("anteater"); tree.insert("tiger"); tree.insert("monkey"); tree.insert("fox");
	tree1.insert("kitten"); tree1.insert("panda"); tree1.insert("anteater"); tree1.insert("tiger"); tree1.insert("monkey"); tree1.insert("fox");
	tree1.insert("lion"); tree1.insert("snake"); tree1.insert("whale");
	tree2.insert("kitten"); tree2.insert("panda"); tree2.insert("anteater"); tree2.insert("tiger"); tree2.insert("monkey"); tree2.insert("fox");
	tree2.insert("octopus"); tree2.insert("snake"); tree2.insert("whale");
        //System.out.println("Trees before removing a node with two children: ");        
        assertEquals("The tree should have a height of 2", 2, tree.height());
	//System.out.println("Should print: anteater fox kitten monkey panda tiger");
        assertEquals("The tree should contain 6 nodes", 6, tree.traverse());
	assertEquals("The tree should have a height of 3", 3, tree1.height());
	//System.out.println("Should print: anteater fox kitten lion monkey panda snake tiger whale");
	assertEquals("The tree should contain 9 nodes", 9, tree1.traverse());
	assertEquals("The tree should have a height of 3", 3, tree2.height());
	//System.out.println("Should print: anteater fox kitten monkey octopus panda snake tiger whale");
	assertEquals("The tree should contain 9 nodes", 9, tree2.traverse());
        tree.remove("panda", true);
	tree1.remove("panda", true);
	tree2.remove("panda", true);
        //System.out.println("Tree after removing the node with two children (panda): ");        
        assertEquals("The tree should have a height of 2", 2, tree.height());
	//System.out.println("Should print: anteater fox kitten monkey tiger");
        assertEquals("The tree should contain 5 nodes", 5, tree.traverse());
	assertEquals("The tree should have a height of 3", 3, tree1.height());
	//System.out.println("Should print: anteater fox kitten lion monkey snake tiger whale");
	assertEquals("The tree should contain 8 nodes", 8, tree1.traverse());
	assertEquals("The tree should have a height of 3", 3, tree2.height());
	//System.out.println("Should print: anteater fox kitten monkey octopus snake tiger whale");
	assertEquals("The tree should contain 8 nodes", 8, tree2.traverse());
	//System.out.println();	
    }

    @Test
    public void check_remove_rootNodeWithOneChild()
    {
        /*
         * check that removing the root node with one child results in maintaining the correct oreding of traverse
         * and the number of nodes decreases by 1
         */
	//System.out.println("CHECK REMOVE ROOT NODE WITH ONE CHILD: ");
        BSTlex tree = new BSTlex();
	BSTlex tree1 = new BSTlex();
        tree.insert("anteater"); tree.insert("kitten"); tree.insert("fox");
	tree1.insert("cereal"); tree1.insert("tea"); tree1.insert("milk"); tree1.insert("yolk");
        //System.out.println("Trees before removing the root node with one child: ");        
        assertEquals("The tree should have a height of 2", 2, tree.height());
	//System.out.println("Should print: anteater fox kitten");
        assertEquals("The tree should contain 3 nodes", 3, tree.traverse());
	assertEquals("The tree should have a height of 2", 2, tree1.height());
	//System.out.println("Should print: cereal milk tea yolk");
	assertEquals("The tree should contain 4 nodes", 4, tree1.traverse());
        tree.remove("anteater", true);
	tree1.remove("cereal", true);
        //System.out.println("Trees after removing the root node with one child (anteater and cereal): ");
        assertEquals("The tree should have a height of 1", 1, tree.height());
	//System.out.println("Should print: fox kitten");
        assertEquals("The tree should contain 2 nodes", 2, tree.traverse());
	assertEquals("The tree should have a height of 2", 2, tree1.height());
	//System.out.println("Should print: milk tea yolk");
	assertEquals("The tree should contain 3 nodes", 3, tree1.traverse());
	//System.out.println();
    }

    @Test
    public void check_remove_rootNodeWithTwoChildren()
    {
        /*
         * check that removing the root node with two children results in maintaining the correct oreding of traverse
         * and the number of nodes decreases by 1
         */
	//System.out.println("CHECK REMOVE ROOT NODE WITH TWO CHILDREN: ");
        BSTlex tree = new BSTlex();
        BSTlex tree1 = new BSTlex();
	BSTlex tree2 = new BSTlex();
        tree.insert("anteater"); tree.insert("kitten"); tree.insert("fox"); tree.insert("accelerate"); tree.insert("all");
        tree1.insert("cereal"); tree1.insert("tea"); tree1.insert("milk"); tree1.insert("yolk");tree1.insert("breakfast"); tree1.insert("apple"); tree1.insert("cake");
	tree2.insert("last"); tree2.insert("first"); tree2.insert("middle"); tree2.insert("note"); tree2.insert("lemon");
        //System.out.println("Trees before removing the root node with two children: ");
        assertEquals("The tree should have a height of 2", 2, tree.height());
	//System.out.println("Should print: accelerate all anteater fox kitten");
        assertEquals("The tree should contain 5 nodes", 5, tree.traverse());	
        assertEquals("The tree should have a height of 2", 2, tree1.height());
	//System.out.println("Should print: apple breakfast cake cereal milk tea yolk");
        assertEquals("The tree should contain 7 nodes", 7, tree1.traverse());
	assertEquals("The tree should have a height of 2", 2, tree2.height());
	//System.out.println("Should print: first last lemon middle note");
	assertEquals("The tree should contain 5 nodes", 5, tree2.traverse());
        tree.remove("anteater", true);
        tree1.remove("cereal", true);
	tree2.remove("last", true);
        //System.out.println("Trees after removing the root node with two children (anteater, last and cereal): ");
        assertEquals("The tree should have a height of 2", 2, tree.height());
	//System.out.println("Should print: accelerate all fox kitten");
        assertEquals("The tree should contain 4 nodes", 4, tree.traverse());
        assertEquals("The tree should have a height of 2", 2, tree1.height());
	//System.out.println("Should print: apple breakfast cake milk tea yolk");
        assertEquals("The tree should contain 6 nodes", 6, tree1.traverse());
	assertEquals("The tree should have a height of 2", 2, tree2.height());
	//System.out.println("Should print: first lemon middle note");
	assertEquals("The tree should contain 4 nodes", 4, tree2.traverse());
	//System.out.println();
    }

}
