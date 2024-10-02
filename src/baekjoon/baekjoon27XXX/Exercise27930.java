package baekjoon.baekjoon27XXX;

import java.util.Scanner;

public class Exercise27930 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        makeForm(input);
    }

    private static void makeForm(String source) {
        int idx1 = 0, idx2 = 0;

        StringBuilder korea = new StringBuilder();
        StringBuilder yonsei = new StringBuilder();
        for (char ch : source.toCharArray()) {
            if (ch == "KOREA".charAt(idx1)) {
                idx1++;
                korea.append(ch);
                if (korea.toString().equals("KOREA")) {
                    System.out.println("KOREA");
                    return;
                }
            }
            if (ch == "YONSEI".charAt(idx2)) {
                idx2++;
                yonsei.append(ch);
                if (yonsei.toString().equals("YONSEI")) {
                    System.out.println("YONSEI");
                    return;
                }
            }
        }
    }
}
