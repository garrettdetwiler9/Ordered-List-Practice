import java.util.Random;

public class Tester
{
    public static void main()
    {
        System.out.println("Test insert in sorted order");
        Random r = new Random();    // create a new Random object 
        OrderedList list = new OrderedList();

        for (int i = 0; i < 5; ++i)
            list.insertInOrder(r.nextInt(10) + 1);  // gives 1..10 randomly
        System.out.println(list.toString());
        System.out.println(list.stringTo());
        
        System.out.println("\nTest some removes");
        list.removeIndex(1);
        list.removeIndex(3);
        list.removeIndex(0);
        System.out.println(list.toString());
        System.out.println(list.stringTo());
        
        System.out.println("\nTest isEmpty()");
        list.removeIndex(1);
        list.removeIndex(0);
        System.out.println(list.isEmpty());
    }
}