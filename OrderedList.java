/**
 * OrderedList.java - create a constructor for an ordered list
 * and multiple methods to change the list or test its content
 * 
 * @author Garrett Detwiler 
 * @version 5 November 2023
 */

public class OrderedList
{
    private Item front;
    private Item rear;
    
    //write your new methods here
    //good Javadoc comments are required
    /**
     * Constructor sets the front and rear Items to null
     */
    public OrderedList ()
    {
        front = null;
        rear = null;
    }
    
    /**
     * isEmpty() returns true if the list is empty, false otherwise
     */
    public boolean isEmpty ()
    {
        if (front == null && rear == null)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    /**
     * insertInOrder() inserts an integer into the 
     * correct place in ordered list and updates the 
     * positions and values of front and rear
     */
    public void insertInOrder(int num) 
    {
        Item newItem = new Item(num);
        
        if (isEmpty()) // if list is empty, make front and rear = newItem
        {
            front = newItem;
            rear = newItem;
        } else {
            if (num >= rear.info) {
                newItem.prev = rear;
                newItem.next = null;
                rear.next = newItem;
                rear = newItem;  // update rear if new element is the larger than all current elements
            } else {
                Item r = front;
                // Find the correct position to insert into
                while (r != null && r.info < num) {
                    r = r.next;
                }
    
                // insert new element at the correct position
                newItem.next = r;
                newItem.prev = (r != null) ? r.prev : rear;
                
                // update next and prev
                if (r != null) {
                    r.prev = newItem;
                }
                if (newItem.prev != null) {
                    newItem.prev.next = newItem;
                } else {
                    front = newItem;  // Update front if the new element is the smallest
                }
            }
        }
    }

    
    /**
     * toString() returns a formatted String representing the list
     */
    public String toString()
    {
        Item r = front;
        StringBuilder str = new StringBuilder();
        while (r != null)
        {
            str.append(r.info);
            if (r.next != null)
            {
                str.append(", "); // make-it-look-niiiice
            }
            r = r.next;
        }
        return str.toString();
    }
    
    /**
     * stringTo() returns a String traversing the list backwards
     */
    public String stringTo()
    {
        Item r = rear;
        StringBuilder str = new StringBuilder();
        while (r != null)
        {
            str.append(r.info);
            if (r.prev != null)
            {
                str.append(", "); // make-it-look-niiiice... again
            }
            r = r.prev;
        }
        return str.toString();
    }
    
    /**
     * removeIndex() removes an item at the indicated index, 
     * then updates front and prev
     */
    public String removeIndex(int input)
    {
        int index = 0;
        String str = "";
        Item r = front;
        
        while (r != null)
        {
            if (index == input)
            {
                str = r.info + "";
                // set prev's next (not the same as just r)
                if (r.prev != null)
                {
                    r.prev.next = r.next;
                }
                else
                {
                    front = r.next; 
                }
                // set next's prev
                if (r.next != null)
                {
                    r.next.prev = r.prev;
                }
                else
                {
                    rear = r.prev;
                }
                break; // avoid unnecessary looping
            }
            // move on to next item in list
            index++;
            r = r.next;
        }
        
        return str;
    }
}