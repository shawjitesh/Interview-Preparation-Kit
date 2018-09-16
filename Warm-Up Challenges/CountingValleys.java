import java.util.Scanner;

public class CountingValleys {

    static int countingValleys(int n, String s) {

        int valleys = 0;
        int level = 0;

        for(char ch : s.toCharArray()) {
            if(ch == 'U') level++;
            else level--;
            if(level == 0 && ch == 'U') valleys++;
        }
        
        return valleys;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Enter the number of steps in Gary's hike");
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        System.out.println("Enter Gary's path");
        String s = scanner.nextLine();

        int result = countingValleys(n, s);

        System.out.println("Gary walked through " + String.valueOf(result) + " valleys during his hike");

        scanner.close();
    }
}
