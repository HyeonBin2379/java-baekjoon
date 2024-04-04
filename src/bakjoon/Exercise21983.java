package bakjoon;

import java.util.Scanner;

public class Exercise21983 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long area = sc.nextLong();
        double len = Math.sqrt(area*Math.sqrt(3)*8);
        System.out.printf("%.6f\n", len);
    }
}
