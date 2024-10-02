package baekjoon.baekjoon32XXX;

import java.util.Scanner;

public class Exercise32154 {

    private static final String[][] board = {
            {"11", "A B C D E F G H J L M"},
            {"9", "A C E F G H I L M"},
            {"9", "A C E F G H I L M"},
            {"9", "A B C E F G H L M"},
            {"8", "A C E F G H L M"},
            {"8", "A C E F G H L M"},
            {"8", "A C E F G H L M"},
            {"8", "A C E F G H L M"},
            {"8", "A C E F G H L M"},
            {"8", "A B C F G H L M"}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rank = sc.nextInt()-1;
        System.out.println(board[rank][0]);
        System.out.println(board[rank][1]);
    }
}
