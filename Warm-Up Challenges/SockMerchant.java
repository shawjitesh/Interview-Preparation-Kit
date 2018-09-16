import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SockMerchant {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("Enter the number of socks");
        int n = in.nextInt();
        int c[] = new int[n];

        System.out.println("Enter the colors of the socks");
        for(int i=0; i < n; i++){
            c[i] = in.nextInt();
        }

        HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();

        for(int i=0;i<n;i++){
            hm.put(c[i],0);
        }
        for(int i=0;i<n;i++){
            int x=hm.get(c[i]);
            x+=1;
            hm.put(c[i],x);
        }

        Set set=hm.entrySet();
        Iterator it=set.iterator();
        
        int count=0;
        while(it.hasNext()){
            Map.Entry me=(Map.Entry)it.next();
            int x=(int)me.getValue();
            if(x>1){
                count=count+(x/2);
            }
        }
        
        System.out.println("John can sell " + count + " matching pair of socks");
    }
}
