import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.Iterator;

public class HashTablesRansomNote {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("Enter the number of words in magazine and note");
        int num_words_magazine = in.nextInt();
        int num_words_note = in.nextInt();

        String word = "";
        Map<String,Integer> magazine, note;
        magazine = new HashMap<String,Integer>();

        System.out.println("Enter the words in the magazine");
        while(num_words_magazine-- > 0) {
            word = in.next();
            if(!magazine.containsKey(word)) {
                magazine.put(word,1);
            } else {
                int freq = magazine.get(word);
                magazine.put(word,freq + 1);
            }
        }

        note = new HashMap<String,Integer>();

        System.out.println("Enter the words in the note");
        while(num_words_note-- > 0) {
            word = in.next();
            if(!note.containsKey(word)) {
                note.put(word,1);
            } else {
                int freq = note.get(word);
                note.put(word,freq + 1);
            }
        }

        in.close();

        Set set = note.entrySet();
        Iterator it = set.iterator();

        while(it.hasNext()) {
            Map.Entry me = (Map.Entry)it.next();
            word = (String)me.getKey();
            int freq = (int)me.getValue();
            if(!magazine.containsKey(word)) {
                System.out.println("No, Harold can't create an untraceable replica of his ransom note");
                System.exit(1);
            } else {
                int count = magazine.get(word);
                if(freq > count) {
                    System.out.println("No, Harold can't create an untraceable replica of his ransom note");
                    System.exit(1);
                }
            }
        }

        System.out.println("Yes, Harold can create an untraceable replica of his ransom note");
    }
}