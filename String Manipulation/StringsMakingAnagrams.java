import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.Iterator;

public class StringsMakingAnagrams {

    public static int numberNeeded(String first, String second) {

        int firstlen = first.length();
        int secondlen = second.length();

        Map<Character,Integer> firstmap, secondmap;
        Set set;
        Iterator it;
        firstmap = new HashMap<Character,Integer>();
        secondmap = new HashMap<Character,Integer>();

        for(int i = 0; i < firstlen; i++) {
            char ch = first.charAt(i);
            if(firstmap.containsKey(ch)) {
                int freq = firstmap.get(ch);
                firstmap.put(ch,freq + 1);
            }
            else {
                firstmap.put(ch,1);
            }
        }
        for(int i = 0; i < secondlen; i++) {
            char ch = second.charAt(i);
            if(secondmap.containsKey(ch)) {
                int freq = secondmap.get(ch);
                secondmap.put(ch,freq + 1);
            }
            else {
                secondmap.put(ch,1);
            }
        }

        int delete = 0, freqfirst = 0, freqsecond = 0;
        set = firstmap.entrySet();
        it = set.iterator();
        
        while(it.hasNext()) {
            Map.Entry me = (Map.Entry)it.next();
            char ch = (char)me.getKey();
            freqfirst = (int)me.getValue();
            if(!secondmap.containsKey(ch)) {
                delete = delete + freqfirst;
            } else {
                freqsecond = secondmap.get(ch);
                delete = delete + Math.abs(freqfirst - freqsecond);
            }
        }

        set = secondmap.entrySet();
        it = set.iterator();
        
        while(it.hasNext()) {
            Map.Entry me = (Map.Entry)it.next();
            char ch = (char)me.getKey();
            freqsecond = (int)me.getValue();
            if(!firstmap.containsKey(ch)) {
                delete = delete + freqsecond;
            }
        }
        
        return delete;
    }
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter first string");
        String a = br.readLine();
        System.out.println("Enter second string");
        String b = br.readLine();
        System.out.println(numberNeeded(a, b) + " characters to be deleted to make the two strings anagram");
    }
}
