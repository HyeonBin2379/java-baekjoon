package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise2303 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] result = new int[n];

        int max = 0;
        for (int i = 0; i < n; i++) {
            int[] cards = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            result[i] = getNum(cards);
            max = Math.max(result[i], max);
        }

        for (int i = n; i >= 1; i--) {
            if (result[i-1] == max) {
                System.out.println(i);
                break;
            }
        }
    }

    private static int getNum(int[] cards) {
        int max = 0;
        for (int i = 0; i < cards.length-2; i++) {
            for (int j = i+1; j < cards.length-1; j++) {
                for (int k = j+1; k < cards.length; k++) {
                    int num = (cards[i]+cards[j]+cards[k]) % 10;
                    max = Math.max(num, max);
                }
            }
        }
        return max;
    }
}
