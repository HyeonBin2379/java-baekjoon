import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        // Please write your code here.
        int k = gcd(n, m);
        System.out.println((n*m)/k);
    }

    private static int gcd(int n, int m) {
        while (m > 0) {
            int temp = n % m;
            n = m;
            m = temp;
        }
        return n;
    }
}