public class Item
{
    protected int info;
    protected Item next;
    protected Item prev;

    public Item()
    {
        info = 0;
        next = null;
        prev = null;
    }

    public Item(int i)
    {
        info = i;
        next = null;
        prev = null;
    }
}
