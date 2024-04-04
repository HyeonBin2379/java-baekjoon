package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise30596 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] len = new int[4];
        for (int i = 0; i < 4; i++) {
            len[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(len);
        System.out.println(Math.min(len[2], len[3])*Math.min(len[0], len[1]));
    }
}
