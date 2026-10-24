import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.
        printRect(n);
    }

    private static void printRect(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int val = (i*n+j+1) % 9;
                int num = (val == 0) ? 9 : val;
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}