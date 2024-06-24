package bakjoon.bakjoon16XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise16675 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] hand = Arrays.stream(br.readLine().split(" "))
                .mapToInt("SPR"::indexOf)
                .toArray();
        if (hand[0] == hand[1] &&
                ((hand[0]+2) % 3 == hand[2] || (hand[0]+2) % 3 == hand[3])) {
            System.out.println("TK");
        } else if (hand[2] == hand[3] &&
                ((hand[2]+2) % 3 == hand[0] || (hand[2]+2) % 3 == hand[1])) {
            System.out.println("MS");
        } else {
            System.out.println("?");
        }
    }
}
