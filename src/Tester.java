import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;
/**
 *
 * @author Amanda
 */
public class Tester 
{
    public static void main(String args[]) throws FileNotFoundException 
    {
        Scanner keyboard = new Scanner(System.in);
        boolean tracker = true;
        
        String arr [] = new String[9];
        
        ArrayList<Bucket> buckets = new ArrayList<Bucket>(8);
        buckets.add(new Bucket('a', 'b'));
        buckets.add(new Bucket('c', 'c'));
        buckets.add(new Bucket('d', 'f'));
        buckets.add(new Bucket('g', 'k'));
        buckets.add(new Bucket('l', 'o'));
        buckets.add(new Bucket('p', 'r'));
        buckets.add(new Bucket('s', 's'));
        buckets.add(new Bucket('t', 'z'));
        
        FileReader r = null;
        do
        {
            
        try
        {
        System.out.println("What is your input file?");
        String input = keyboard.nextLine();
        r = new FileReader(input);
        tracker = true;
        }
        
        catch(FileNotFoundException e)
        {
            System.out.println("File is not found");
            tracker = false;
        }
        
        }while(!tracker);
        
        Scanner in = new Scanner(r);
        
        while (in.hasNext()) 
        {
            String word = in.next();
            if (word.charAt(word.length() - 1) == ',')
            {
                word = word.substring(0, word.length() - 1);
            }
            
            for (int i = 0; i < buckets.size(); i++) 
            {
                if (word.charAt(0) >= buckets.get(i).getMinInitial() && word.charAt(0) <= buckets.get(i).getMaxInitial()) 
                {
                    buckets.get(i).add(word);
                }
            }
        }
        
        for(int i=0; i < buckets.size(); i++)
        {
            buckets.get(i).sortArray();
        }
        
        System.out.println("What is your output file?");
        String output = keyboard.nextLine();
        PrintWriter out = new PrintWriter(output);

        for (int i = 0; i < buckets.size(); i++) 
        {
            out.println(buckets.get(i).toString());
        }
        System.out.println("Successfully printed, go check out your output file provided");
        
        
        out.close();
    }
}
