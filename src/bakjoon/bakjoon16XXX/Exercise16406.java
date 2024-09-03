package bakjoon.bakjoon16XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise16406 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int friendCorrect = Integer.parseInt(br.readLine());
        String me = br.readLine();
        String friend = br.readLine();

        int same = 0;
        for (int i = 0; i < me.length(); i++) {
            if (me.charAt(i) == friend.charAt(i)) {
                same++;
            }
        }
        System.out.println(me.length()-Math.abs(same-friendCorrect));
    }
}
