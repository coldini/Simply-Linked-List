//File: SimpleLinkedListTest.java. 
//Add a file header comment or a class header comment to your work.

package assign3_template;
/* CIS 2168 Data Structures
 *  Section Number: 003
 *  Colden Jeanmonod tur26337@temple.edu
 *  Assignment Name: Assign 3
 *  Class Name: SimpleLinkedListTest
 *  This method is to test and see if the items in the SimpleLinkedList
 *  class actually work or not.
 *  
 */
/**
 * Assign 3 Template.
 * Testing different methods (successful and failed calls)
 * 
 */
public class SimpleLinkedListTest {

    public static void main(String[] args) {
        
        //2.2 Revise SimpleLinkedListTest
        
        //create an empty singly linked list of int values        
        //append some integers
    
        //For method size, use one test case.
        //test all other methods using at least 2 calls:
        //  successful call, e.g. call indexOf(..) and pass an existing integer
        //  failed call, e.g. call indexOf(..) and pass a non-existing integer
   
        //You can reuse some of the code below given to you in the lectures.        
        
        //create an empty list
        SimpleLinkedList numbers = new SimpleLinkedList();
        
        //append 3 integers
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        
        //dump the contents in the list in the original order
        System.out.println(numbers);
        
        System.out.println(numbers.size());
        
        System.out.println(numbers.add(40));
        
        numbers.add(50);
        System.out.println(numbers);
        
        System.out.println("Testing add and remove");
        numbers.add(5, 60);
       	System.out.println(numbers);
       	numbers.add(2, 70);
       	numbers.add(0,80);
        System.out.println(numbers.removeByValue(60));
        System.out.println(numbers.removeByValue(90));
        System.out.println(numbers);
        
        System.out.println("");
       
        System.out.println("testing contains");
        System.out.println(numbers.contains(10));
        System.out.println(numbers.contains(100));
        
        System.out.println("");
        
        System.out.println("Testing get");
        System.out.println(numbers.get(1));
        System.out.println(numbers.get(23));
        
        System.out.println("");
        
        System.out.println("testing indexOf");
        System.out.println(numbers.indexOf(70));
        System.out.println(numbers.indexOf(100));
        
        System.out.println("");
        System.out.println("Testing remove by index");
        System.out.println(numbers.removeByIndex(0));
        System.out.println(numbers.removeByIndex(30));
        System.out.println(numbers);
        
        //or use:
        //System.out.println(numbers.toString());        
    }   
    
}
