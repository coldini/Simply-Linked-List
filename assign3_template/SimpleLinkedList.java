//File: SimpleLinkedList.java. 
//Add a file header comment or a class header comment to your work.

package assign3_template;


/* CIS 2168 Data Structures
 *  Section Number: 003
 *  Colden Jeanmonod tur26337@temple.edu
 *  Assignment Name: Assign 3
 *  Class Name: SimpleLinkedList
 *  This class is the initializer for the entirity of the Simple Linked List
 *  And has the methods required to run it
 *  
 */
/**
 * Assign 3 template. Implement more methods in List interface.
 */
public class SimpleLinkedList {

    //-------Start of Assign 3  --------/  
    
    //2.1.2 Coding Requirements
    //You can call other methods to complete a method.
    //You can also add private methods, and then call these methods 
    //  to complete a method required in this assignment. 
    //You are NOT allowed to add or remove data fields to/from SimpleLinkedList class. 
    //You are NOT allowed to change the definition of Node class.
    
    //2.1.1 What Code to Add
    //-----Required ---------------//    
    
    //Remove the first occurrence of the specified item from this linked list. 
    // If success, return true. Otherwise, return false.
	/*Method: removeByValue
	 * parameters: Item: the item that is to be removed
	 * returns: true or false depending on if there is an item to be removed
	 * This goes through the entire array class and checks to make sure there is an item
	 * to be removed, removes it and readjusts the size, then returns true or false
	 */
    public boolean removeByValue(int item) {
        //add your own code
        
        //Hint:
        //  call your indexOf(...) to locate the item,
        //  convert the following in SingleLinkedList<E>
        //     private E removeFirst()        
        //     private Node<E> getNode(int index)         
        //     private E removeAfter(Node<E> node)
    	 int index = indexOf(item);
    	 //checks to make sure that the item actually exists before removing
    	    if (index == -1) {
    	        return false;
    	    }
    	    //makes sure that the item is being put in the correct spot
    	    if (index == 0) {
    	        head = head.next;
    	    } else {
    	    	Node predecessor = getNode(index - 1);
    	        predecessor.next = predecessor.next.next;
    	    }
    	    size--;
    	    return true;
        
        
        //Hint: if you implement this from scratch, remember to save:
        //   predecessor node reference        
        //   current node reference
        

    }

    //add item to be at [index];
    // if index is [0, size-1], insert item between [index-1] and [index]
    // if index is size, append item to the end of this linked list.
    
    /*
     * Method Name: add
     * parameters: Index, the location that the item will be stored, 
     * Item: the new item that will be stored
     * Returns: N/A
     * This will add the item to the list and goes through and makes sure\
     * it can be properly added to the spot.
     */
    public void add(int index, int item) {
        //add your own code
        
    	Node cur = head;
    	
    			//Hint:
        //convert the following in SingleLinkedList<E>
        //    public void add(int index, E item)
 	//    public void addFirst(E item)
        //    private Node<E> getNode(int index)
    	//    private void addAfter(Node<E> node, E item)          
    	   if (index < 0 || index > size) {
    	        throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    	    }

    	   	//If statement to see how the new node will be inserted into the linked list
    	    if (index == 0) {
    	    	 head = new Node(item, head);
    	         size++;
    	    } else if (index == size) {
    	       
    	    	Node newNode = new Node(item);
    	    	//checks to make sure the front is empty, and if it is it inserts itself there
    	    	if (head == null) {
    	            head = newNode;
    	        } else {
//    	        	while loop to make sure that it goes through all items

    	            while (cur.next != null) {
    	                cur = cur.next;
    	            }
    	            cur.next = newNode;
    	        }
    	        size++;
    	    	
    	    } else {
    	       Node newNode = new Node(item);
    	       
    	    	
      	       Node current = getNode(index - 1);
      	       newNode.next = current.next;
      	       
      	       current.next = newNode;
      	       
    	    }
    }

    //Get the integer item at the specified position and return the integer value. 
    //If the index is not valid, throw an exception or print an error message 
    //  and return Integer.MIN_VALUE.
    
    /*
     * Method name: get
     * Parameters: index, the index of what item you would like to know
     * Returns: the item at the location by integer rather than whole nod
     * This method will get the value of the entity at the index
     */
    public int get(int index) {
        //add your own code
        Node cur = head;
        //checks to make sure it is not out of bounds
        if (index < 0 || index >= size) {
            System.out.println("Error: Index out of bounds");
            return Integer.MIN_VALUE;
        }
        //loops through all the cases until it finds the right one
        for (int i = 0; i <= index; i++) {
        	//checks to see if it is the correct index, if not then it goes yo the next node
        	if(i != index) {
        		cur = cur.next;
        	}else if(i == index) {
        		return cur.data;
        	
        	}
        }
        //Hint:
	//convert the following in SingleLinkedList<E>
        //    public E get(int index)
        //    private Node<E> getNode(int index)       
		return Integer.MIN_VALUE;
        
      

    }

    //Search this linked list for the first occurrence of the specified integer: item. 
    //If the item is found, return its index. Otherwise return -1.
    
    /*
     * Method name: IndexOf
     * parameter: Item, the item that you wish to find the index of
     * returns: the index of the aforementioned item
     * This method goes through the list and finds the index of the item that 
     * is inputted
     */
    public int indexOf(int item) {
        //add your own code
        int index = 0;
        Node current = head;
        
        //Hint:
        //use a looping like the one in toString()
        //in addition, add a counter, 
        //    increment the counter for each element checked 
        //can use size for loop control.
//    	while loop to make sure that it goes through all items

    	while(current != null) {
    		//an if else statement, if it is not equal to the correct item, it keeps iterating
    		if(current.data != item) {
    			index ++;
    			current = current.next;
    		}else {
    			return index;
    		}
    	}
        return -1;
        
    }

    //Find out if the specified integer: item is in this linked list. 
    // Returns true if yes, false otherwise.
    /*
     * method name: contains
     * parameters: item, the item that should e checked to see if it is in the list
     * returns: true or false depending on if the item exists in the list
     * This method will go through the list and check to see if the item
     * exists in it, if yes it returns true, if not it returns false
     */
    public boolean contains(int item) {
        //add your own code
        
        //Hint:
        //can either call indexOf(...) 
        //    or directly search for the item using a loop like the one in toString()
    	Node current = head;
    	
//    	while loop to make sure that it goes through all items
    	while(current != null) {
    		//if statement to make sure it is correct
    		if(current.data == item) {
    			return true;
    		}
    		current = current.next;
    	}
    	return false;
        
    }

    //return how many integers are in this linked list
    
    /*
     * Method Name: size
     * parameters: none
     * returns: size of list
     * This will count the size of the list and return the value of it
     */
    public int size() {
        //add your own code
        
        //Hint: this is actually a getter
    	int  count = 0;
    	
    	Node current = head;
    	
//    	counts the size of the list as long as current is not null
    	while(current != null) {
    		count += 1;
    		current = current.next;
    	}
        
        return count;
    }

    //-----Bonus ---------------//
    //Remove the item at the specified position from this linked list and 
    //  return the removed item.
    //If the index is not valid, throw an exception or print an error message 
    //   and return Integer.MIN_VALUE.
    
    /*
     * method name: removeByIndex
     * parameters: index, the location of the item that is to be removed
     * returns, either the value of the removed item, or the Lowest integer value if it is not in the list
     * This method goes through the list and will remove the item that is at that specific location and no where else
     * 
     */
    public int removeByIndex(int index) {
        //Add your own code
     
        //Hint:        
        //verify that index is valid
        //convert the following in SingleLinkedList<E>
        //     private Node<E> getNode(int index) 
        //     private E removeAfter(Node<E> node)        
       
        //Hint: if you implement this from scratch, remember to save:
        //   predecessor node reference        
        //   current node reference
        
    	//checks ti make sure it is not out of bounds
    	if (index < 0 || index >= size) {
            System.out.println("Error: Index out of bounds");
            return Integer.MIN_VALUE;
        }

        Node predecessor = null;
        Node current = head;

        // Find the predecessor node
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        predecessor = current;

      
        current = current.next;

        // Remove the current node
        predecessor.next = current.next;
        int removedItem = current.data;
        current = null;

        size--; 

        return removedItem;
    }
    
    
    private Node getNode(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    
    private void addAfter(Node node, int item) {
        Node newNode = new Node(item);
        newNode.prev = node.prev;
        newNode.next = node.next;
        
        size++;
    }
    //-------End of Assign 3 --------/ 

    //Don't change the code below.
    //Nested class Node, enclosing class: SimpleLinkedList
    private static class Node {

        private int data;
        private Node next;

        //constructor used to create a standalone node without a successor
        private Node(int data) {
            this.data = data;
            next = null;
        }
        
        //constructor used to create a Node with a given successor
        private Node(int dataNew, Node nextNew) {
            data = dataNew;
            next = nextNew;
        }
       
    }

    //the reference to the first Node in this linked list.
    private Node head;
    //the size of this linked list
    private int size;

    //create an empty linked list
    public SimpleLinkedList() {
        head = null;
        size = 0;
    }

    //append newItem
    public boolean add(int newItem) {
        Node temp = new Node(newItem);
        if (head == null) { //empty list
            head = temp;
        } else { //non-empty list
            //locate last node
            Node current = head;    //start with the first node
            while (current.next != null) {  //check if current node is not the last node
                current = current.next;     //move on to the next node on the list
            }
            current.next = temp;    //append the new node immediately following the current node
        }
        size++;
        return true;
    }

    //return a string that contains all integers (in the original sequence) in this linked list.
    @Override
    public String toString() {
        String result = "";     //result string
        Node current = head;        //start with first Node
        while (current != null) {   //check if there is still nodes remaining
            result += current.data; //add the integer in current Node to the result string
            result += "-->";
            current = current.next; //move on to the next Node
        }
        return result;
    }
}
