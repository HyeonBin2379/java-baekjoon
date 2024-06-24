package bakjoon.bakjoon21XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise21212 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] count = new int[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int required = Integer.parseInt(st.nextToken());
            int inKitchen = Integer.parseInt(st.nextToken());
            count[i] = inKitchen/required;
        }
        System.out.println(Arrays.stream(count).min().getAsInt());
    }
}
