package bakjoon.bakjoon1XXX;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercise1251 {
    private static final List<String> vocabulary = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();

        for (int i = 1; i < word.length()-1; i++) {
            for (int j = i+1; j < word.length(); j++) {
                StringBuilder token1 = new StringBuilder(word.substring(0, i)).reverse();
                StringBuilder token2 = new StringBuilder(word.substring(i, j)).reverse();
                StringBuilder token3 = new StringBuilder(word.substring(j)).reverse();
                token1.append(token2);
                token1.append(token3);
                vocabulary.add(token1.toString());
            }
        }
        vocabulary.sort(null);
        System.out.println(vocabulary.get(0));
        sc.close();
    }
}
