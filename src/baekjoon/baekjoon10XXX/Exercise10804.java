package baekjoon.baekjoon10XXX;

import java.util.Scanner;

public class Exercise10804 {
    private static int[] cards;
    public static void main(String[] args) {
        cards = new int[21];
        for (int i = 1; i < cards.length; i++) {
            cards[i] = i;
        }

        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            reverse(start, end);
        }

        for (int i = 1; i < cards.length; i++) {
            System.out.print(cards[i] + " ");
        }
    }

    public static void reverse(int start, int end) {
        for (int i = start; i <= (start+end)/2; i++) {
            int temp = cards[i];
            cards[i] = cards[start+end-i];
            cards[start+end-i] = temp;
        }
    }
}
