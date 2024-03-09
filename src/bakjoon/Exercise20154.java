package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Exercise20154 {
    private static final int[] alpha = {
            3, 2, 1, 2,
            3, 3, 3, 3,
            1, 1, 3, 1,
            3, 3, 1, 2,
            2, 2, 1, 2,
            1, 1, 2, 2,
            2, 1
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] cnt = Arrays.stream(br.readLine().split(""))
                .map(s -> Integer.toString(alpha[s.charAt(0)-'A']))
                .collect(Collectors.joining())
                .toCharArray();

        while (cnt.length > 1) {
            StringBuilder temp = new StringBuilder();
            int len = (cnt.length % 2 == 1) ? cnt.length-1 : cnt.length;

            for (int i = 0; i < len; i += 2) {
                int num = ((cnt[i]-'0') + (cnt[i+1]-'0')) % 10;
                temp.append(num);
            }
            if (cnt.length % 2 == 1) {
                temp.append(cnt[cnt.length-1]);
            }
            cnt = temp.toString().toCharArray();
        }
        System.out.println((cnt[0] % 2 == 1) ? "I'm a winner!" : "You're the winner?");
    }
}
