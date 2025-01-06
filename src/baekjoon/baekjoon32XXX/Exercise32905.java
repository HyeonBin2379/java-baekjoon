package baekjoon.baekjoon32XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise32905 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        String[][] arr = new String[r][c];
        for (int i = 0; i < r; i++) {
            arr[i] = br.readLine().split(" ");
            long count = Arrays.stream(arr[i]).filter(s -> s.equals("A")).count();
            if (count != 1) {
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");
    }
}
