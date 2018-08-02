import java.util.Iterator;
import java.util.LinkedList;
import java.util.Arrays;
/**
 *
 * @author Amanda
 */
public class Bucket 
{
    private char minInitial;
    private char maxInitial;
    private LinkedList <String> list;
    String [] s;
    
    public Bucket(char min, char max)
    {
        minInitial = min;
        maxInitial = max;
        list = new LinkedList <String>();
    }

    /**
     * Returns the minimum character initial of a specific bucket
     * @return minInitial
     */
    public char getMinInitial() 
    {
        return minInitial;
    }

    /**
     * Returns the maximum character initial of a specific bucket
     * @return maxInitia;
     */
    public char getMaxInitial() 
    {
        return maxInitial;
    }
    
    /**
     * Adds the read words to the LinkedList list
     * @param str the words read from the file
     */
    public void add(String str)
    {
        list.addLast(str);
    }
    
    /**
     * Sorts the LinkedLists in alphabetical order by copying their information to an array
     * and sorting the array
     */
    public void sortArray()
    {
        s = new String[list.size()];
        Iterator it = list.listIterator();
        do{
        for(int i=0; i <= list.size()-1; i++)
        {
            s[i] = (String) it.next();
        }
        }while(it.hasNext());
        Arrays.sort(s);
    }
    
    /**
     * Prints the information inside each bucket
     * @return 
     */
    @Override
    public String toString()
    {
        return "Bucket " + minInitial + " - " + maxInitial + ": " + Arrays.toString(s);
    }
}
