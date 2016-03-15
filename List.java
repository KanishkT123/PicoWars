package edu.hmc.cs.cs60;

/**
 * List class
 * 
 * This class creates Objects that can represent a List of Strings.
 * 
 * Implementation details:
 * This List class
 *   - is a singly-linked list (references pointing from front to back)
 *   - has an *inner* class (ListNode) that works just like Racket lists
 *   - each ListNode has data (a String, named data)
 *                   and a reference to another ListNode (next)
 *
 */
public class List {

    /** the first node in the list */
    private ListNode head;
    
    /** the number of elements in the list */
    private int size;

    /**
     * creates an empty List
     */
    public List() {
        this.head = null;
        this.size = 0;
    }
    
    /**
     * Represents an element in a linked list
     * (similar to a "cons cell" in Racket)
     */
    public class ListNode {
        /** the element */
        public String data;
        
        /** a reference to the next node */
        public ListNode next;
        
        public ListNode(String element, ListNode next) {
            this.data = element;
            this.next = next;
        }
        
        /**
         * create a one-element list
         * @param element
         */
        public ListNode(String element) {
            this(element, null);
        }
    }

    
    /**
     * isEmpty() checks if this List has no elements
     * @return true if the List contains no ListNodes
     */
    public boolean isEmpty() {
        return this.length() == 0;
    }
    

    /**
     * size() is a "getter" method for the mySize data member of List
     * @return the number of ListNodes in the List.
     */
    public int length() {
        return this.size;
    }
    

    /**
     * contains(String s) computes whether s is in this List
     * @param s, a string to look for in the List.
     * @return true if s is in the list, false otherwise
     */
    public boolean contains(String s) {
        for (ListNode node = this.head; node != null; node = node.next) {
            if (s.equals(node.data)) {
                return true;
            }
        }
        return false;
    }
    

    /**
     * get(int index) returns the element at index index in this List
     * @param the desired index in the List.
     * @return the value of the string at element number index
     * (zero-indexed) from the List
     * @throws IllegalArgumentException if there is no element
     * at that position
     */
    public String get(int index) {
        // check that index is within the bounds of the list  
        if (index < 0) {
            throw new IllegalArgumentException(
                      "Argument to get must be at least 0.");
        }
        if (index >= this.length()) {
            throw new IllegalArgumentException(
                      "Argument to get is too large.");
        }
        
        // iterate through the list and find the right node
        int currentIndex = 0;
        ListNode currentNode = this.head;
        while (currentIndex != index) {
            currentIndex++;
            currentNode = currentNode.next;
        }
        
        return currentNode.data;        
    }

    
    /**
     * addToFront(String str)
     * @param str is a new String to be inserted at the front of the list
     * 
     * Note that addToFront modifies this List; it does *not* return anything.
     * It's different than the constructor, which does create a new list.
     */
    public void addToFront(String str) { //Input: String
        this.addToFront(new ListNode(str, this.head)); //Creates a new node, with node.data = str. 
        											   //Then calls the addToFront(ListNode node).
    }

    // @CS60: here is an example of method overloading (i.e., defining a method
    //        that has the same name as an existing method, but which has 
    //        different argument types).
    //        Note that this method is private.
    /**
     * addToFront(ListNode node)
     * @param node which is a ListNode to be inserted as the first element in
     * the current List.
     * This should modify the List and does not return anything.
     */
    private void addToFront(ListNode node) { //Input: Node. 
        node.next = this.head; //Connects the "next" or the pointer on input node to current first element of list
        this.head = node; //Changes the head of the list to be the input node, which is already connected to the rest of the list. 
        this.size++; //Increases size by 1. 
    }
    

    /**
     * add(String s)
     * 
     * @param s is a String to add to the end of the List.
     * 
     * This should modify the List and does not return anything. If this List is
     * empty, it should add the String to the back of the List. If the List is
     * not empty, it should search to find the last ListNode in the List and
     * then add a new ListNode, containing s, beyond it as the final element.
     */
    public void add(String s) { //Input: String s
    	ListNode mynode = new ListNode(s); //Creates new ListNode, with ListNode.data = s
        this.add(mynode); //Calls this.add(ListNode) in order to add the new node to the list.
    }
    
    
    /**
     * add(ListNode node)
     * 
     * @param node is a ListNode to add to the end of the List.
     * 
     * This should modify the List and does not return anything. If this List is
     * empty, it should add node to the List. If not empty, it should search to
     * find the last ListNode in the List and the add node beyond it as the
     * final element.
     * 
     * Another example of overloading based on input type (private method):
     */
    private void add(ListNode node) { //Input: ListNode
    	if(this.length() == 0){ //Checks to see if the list has a length of 0
        	this.head = node; //If yes, then changes the head element to be the current node.
        	this.size++ ; //Updates the size by 1
        	return; //Stops. No other changes needed. 
        }
        for (ListNode start=this.head; start != null; start = start.next){ //Otherwise, enters the for loop.
        	if(start.next == null){ //Checks to see if the current node is the last element in the list
        		start.next = node; //If yes, then changes the pointer on the node to be the input node
        		this.size++ ; //Updates size by 1
        		return; //Stops
        	}
        }
    }
 
    /**
     * removeFirst()
     * 
     * @return the data (as a String) that was previously stored 
     * in the first ListNode in the List, or null if the list is empty
     * 
     * This should modify the List to remove the first element in the List. The
     * List should be unchanged if this is called on an empty List.
     */
    public String removeFirst() {
        String olddata = this.head.data; //Creates a new string which stores the first element of the list
        this.head = this.head.next; //Makes the head point to the second string element
        							//This removes all references to the first ListNode, thus making it garbage
        this.size-- ; //Reduces list size by 1
        return olddata; //Returns the string that was removed from the list
        
    }
    

    /**
     * appendInPlace(List list2)
     * @param list2 is a List to be appended to the end of this List. 
     * appendInPlace _should_ copy the data from 
     * list2 into new ListNodes at then end of this List. However,
     * appendInPlace should *not* return anything and should *not* modify list2.
     */
    public void appendInPlace(List list2) {
        if(this.size == 0){ //Checks to see if the current size of the list is 0
        	this.add(list2.head.data); //If yes, then adds the first element of list 2 to the current list
        	for(ListNode start = list2.head.next; start!= null; start=start.next){ //For Loop start: 2nd element of list 2
        		ListNode tempnode = new ListNode(start.data); //Creates a new node with the same data as a corresponding node from list2
        		this.add(tempnode); //Adds this temporary node to this
        	}
        	return ; //Stops
        }
        for(ListNode start = list2.head; start!= null; start=start.next){ //If list is not empty, loops from the first Node of list2
    		ListNode tempnode = new ListNode(start.data); //Makes a new node with the same data as list2
    		this.add(tempnode); //Adds this node to the this
        }
        return; //Stops
    }
    

    /**
     * @param stringArray is an array of Strings.
     * 
     * @return a List of the same size as the input strArr and with the content
     * from strArr in the order they appear in strArr.
     * 
     * This method is labeled as STATIC. 
     * 
     * This means you don't need an object of type List to call this method. 
     * Because it's static, there is no "this" reference -- since there is no
     * object calling the method! 
     * 
     * So, to call this method you'd use the class name: List.makeFromArray(stringArray). 
     * We also could have made this a constructor that took in an String[].
     * 
     * You should use addToFront, **not** add, to create elements in the resulting List. 
     * addToFront takes constant time, so this will allow you to add all
     * of the N elements to your List in time proportional stringArray.length
     */
    public static List makeFromArray(String[] stringArray) { //Input: A string array
        List mylist = new List(); //Makes a new empty List
        for(int i = stringArray.length-1; i>=0; i--){ //Loops across all elements of the string in reverse
        	mylist.addToFront(stringArray[i]); //Adds each element to the front of the list
        									   //Add to front used instead of add because it is constant time instead of being O(n)
        }
        return mylist; //stops
                
    }
    

    /**
     * makeEquivalentArray()
     *  
     * @return an String[] with the contents from the List in the same order in
     * which they appear in the List.
     * 
     * It should not modify the List.
     */
    public String[] makeEquivalentArray(){
    	String[] newstringer = new String[this.length()]; //Creates a new string array with the same length as the input list
    	int i = 0; //Initialise an integer, value 0
    	for(ListNode start = this.head; start!= null; start=start.next){ //Starts a for loop from the first Node of the list
    		newstringer[i] = start.data; //Change the value of the current position i of the string array to be the data of the node
    		i++ ; //Increment i
    	}
    return newstringer; //Return the string array
    }
    

    /**
     * reverse()
     * 
     * @return none
     * 
     * This method should reverse the contents of the List without creating any
     * new ListNode Objects or any new List Objects and without creating an
     * Array or other structures. You can create references to Objects, but you
     * can't call new. This type of restriction is called doing something
     * "in place" because it does not require any additional Objects to be
     * created.
     * 
     * If you do this recursively, you'll be able to use removeFirst; if you
     * use loops, you will need a few ListNode references. Specifically, if you
     * are looping, we'd recommend creating ListNode references to refer to the
     * previous, current, and next ListNode as your code "walks" the list...
     */
    public void reverse() {
    	if(this.length() == 0){ //If the input string is empty, return it
    		return;
    	}
    	String mine = this.removeFirst(); //Initialise a string object to be the string data of the first node of the list
    	this.reverse(); //Recursively call reverse on the list
    	this.add(mine); //Add the removed string data to the back of the reversed list
    
    } 
    

    /**
     * split()
     * 
     * @return a new List that contains the second half of the elements in the
     * original List.
     * 
     * The current list (this) should be modified to now only have a list of
     * half the length. 
     * 
     * If the current list (this) has only 1 element, the List should be
     * unmodified and should return an empty List.
     * 
     * If the current list (this) has an odd number of elements, the current
     * List should have one more element than the List that is returned.
     */
    public List split() { 
    	List mylist  =  new List(); //Initialize a new list
    	int count = this.length()/2; //The split point is going to be at half the list
    	mylist.size = count; //Update the size of the new list to be equal to the split amount
    						 //As Integer division will give floor values anyway
    	if(this.length()%2 != 0){ //If the length of the input list is odd
    		count ++; //Increase split point by 1 so that the current list has one more element than the returned list
    	}
    	this.size = count; //Update the size of the current list to be equal to the final split point index
    	for(ListNode start = this.head; start!= null; start=start.next){ //Loop over the current list
    		if(count == 1){ //Check to see if the count is 1 yet (i.e., next element is the split element)
    			if(start.next == null){ //If the list ends here, i.e, there is no next element
    				return mylist; //Return the second list and stop
    			}
    			mylist.head = start.next; //Otherwise, make the first element of mylist the next element in this list
    			start.next =  null; //Cut off the current list at this element
    			return mylist; //Return the new mylist
    		}
    		count--; //Decrease distance to split point
    	} 
    	return mylist; //Return the new mylist
    }
    
    
    /**
     * merge(List list2)
     * 
     * @param list2 is an already sorted List to be merged with the current List
     * (this).
     * 
     * The method should modify the current List to contain the merged
     * combination of the current List (this) and the input List (list2).
     * 
     * The method merge should only be called on a List that is already in
     * sorted order.
     * 
     * You will find Java's compareTo method helpful. Find information about
     * String's compareTo here:
     * http://docs.oracle.com/javase/7/docs/api/java/lang/String.html#compareTo(java.lang.String)
     * 
     * It's OK to make an extra List object (such as the mergedList that will
     * become the result), but you should not create any new ListNode Objects
     * You'll find the method removeFirst() and addToFront(ListNode node)
     * helpful.
     * 
     * Think carefully! Java doesn't let you assign to this.
     *     
     * This method will modify this and list2. When completed, list2 should be
     * empty and the current List (this) should contain all elements in sorted
     * order.
     */

    public void merge(List list2) {
    	int sizer = list2.length() + this.length(); //Calculate the length of the merged list
    	if(this.head == null){ //If the first list is empty
        	this.add(list2.head); //Add the elements of list2 to the current list
    		list2 = new List(); //Empty the second list
    		return; //Return nothing
    	}
    	
    	if(list2.head == null){ //If the second list is empty
    		return; //Do nothing, return nothing.
    	}
    	
    	if(this.head.data.compareTo(list2.head.data)<=0){ //If the first element of the current list is less than the first element of the second list
    		ListNode temp = this.head; //Make a ListNode reference pointing to the first node of the current list
    		this.removeFirst(); //Remove the first node from the current list
    		temp.next = null; //Cut off all connections between the first node and the rest of the list (as there is still a reference to the first node)
    		this.merge(list2); //Recursively merge the current list and list 2
    		this.addToFront(temp); //Add back the removed ListNode to the current list
    		this.size = sizer; //Update size of list
    		list2.head = null;
    		list2.size = 0; //Empty the second list
    		return; //Stop
    	}
    	if(this.head.data.compareTo(list2.head.data)>0){ //If the first element of list2 is before the first element of list1
    		ListNode temp = list2.head; //Make a temp reference pointing to the first node of list2
    		list2.removeFirst(); //Remove this node
    		temp.next = null; //Cut all connections between the node and the list 
    		this.merge(list2); //Call the merge function recursively
    		this.addToFront(temp); //Add the node back to the front
    		this.size = sizer; //Update the size of the lists
    		list2.head = null;
    		list2.size = 0; 
    		return; //stop
    	}
    	return; //stop statement because Java acts like a worried mother about eventualities that cannot possibly occur
    }
  
    /**
     * mergeSort()
     * 
     * The method mergeSort should use split() and merge(List list2) to execute
     * mergesort on a List.
     * 
     * This method will modify the List.
     */
    public void mergeSort() {
    	
    	if(this.length() == 2){ //If the length of the list is 2
    		if(this.head.data.compareTo(this.head.next.data) > 0){ //Check to see if it is ordered
    			this.reverse(); //If not, reverse it so it is
    			}
    	return; //stop, return nothing. 
    	}
    	
    	if(this.length() > 2){ //If list length is greater than 2
    		List templist = this.split(); //Split the list. templist is a reference pointing to the second half
    		this.mergeSort(); //Do a mergesort on each half of the list
    		templist.mergeSort(); //As above
    		this.merge(templist); //Merge the two mergesorted lists
    		return; //Stop
    	}
    	
    	return; //Java worries that a number might not be equal, less than or greater than 2. So...imaginary?

    }
    
    // @CS60: You don't need to understand the code below this point,
    // but feel free to take a look and ask questions about it,
    // if you're interested!
    
    /**
     * toString() produces a string representation for this List
     * @return a String representation of the contents of the List
     */
    public String toString() {
        String result = "( ";
        for (ListNode node = this.head; node != null; node = node.next) {
            result = result + node.data + " ";
        }
        return result + ")";
    }
    

    /**
     * equals(List list2) 
     * @param obj is an Object to compare this List to.
     * @return true if obj is a list with the same elements in the
     * same order as this; false otherwise
     */
    private boolean equals(List list2) {
        // if the two lists are different sizes, they are not equal
        if (this.size != list2.size) {
            return false;
        }
        
        // compare element by element
        ListNode node1 = this.head;
        ListNode node2 = list2.head;
        for (int i = 0; i < this.size; i++) {
            // get the two strings, so we can compare them
            String s1 = node1.data;
            String s2 = node2.data;
            if (!s1.equals(s2)) { 
                return false;
            }
            node1 = node1.next; // "walk" down this list
            node2 = node2.next; // "walk" down list2
        }
        
        return true;
    }
    
    /**
     * equals(Object obj) 
     * @param obj is an Object to compare this List to.
     * @return true if obj is a list with the same elements in the
     * same order as this; false otherwise
     */
    public boolean equals(Object obj) {
        // if obj is not of type List, they are not equal
        if (!(obj instanceof List)) {
            return false;
        }
        
        // otherwise, convert the object to a List and use the 
        // overloaded version of equals
        List list2 = (List) obj;
        return this.equals(list2);
    }
}
