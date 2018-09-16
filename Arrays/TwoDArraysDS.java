import java.util.Scanner;

public class TwoDArraysDS {

    static int maxHourGlass(int[][] arr) {

        int max = arr[0][0], s = 0, k = 0;
        int aux[]=new int[16];

        for(int i = 0; i < 4; i++) {
            s = 0;
            for(int j = 0; j < 4; j++) {
                s = 0;
                for(int p = i; p < i + 3; p++) {
                    for(int q = j; q < j + 3; q++) {
                        if(p == i + 1) {
                            if(q == j + 1)
                                s += arr[p][q];
                        }
                        else
                            s += arr[p][q];
                    }
                }
                aux[k++] = s;
            }
        }

        max = aux[0];

        for(int i = 0; i < k; i++){
            if(aux[i] > max)
                max = aux[i];
        }

        return max;
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int arr[][] = new int[6][6];

        System.out.println("Enter the array elements");
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 6; j++){
                arr[i][j] = in.nextInt();
            }
        }

        in.close();

        System.out.println("The maximum hourglass sum is: " + maxHourGlass(arr));
    }
}
