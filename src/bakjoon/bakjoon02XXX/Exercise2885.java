package bakjoon.bakjoon02XXX;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Exercise2885 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int chocoChunk = IntStream.iterate(1, i -> i <= (int)Math.pow(2, 20), i -> i*2)
                .filter(value -> value >= k)
                .findFirst()
                .getAsInt();
        System.out.println(chocoChunk + " " + getCount(chocoChunk, k));
    }

    private static int getCount(int chunk, int choco) {
        int count = 0;
        while (choco != chunk && choco > 0) {
            chunk /= 2;
            if (choco >= chunk) {
                choco -= chunk;
            }
            count++;
        }
        return count;
    }
}
