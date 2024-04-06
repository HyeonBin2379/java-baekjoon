package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise25812 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int[] option = new int[3];
        for (int i = 0; i < n; i++) {
            int sal = Integer.parseInt(br.readLine());
            if (sal+r > sal*2) {
                option[1]++;
            } else if (sal+r < sal*2) {
                option[2]++;
            } else {
                option[0]++;
            }
        }

        if (option[1] > option[2]) {
            System.out.println(1);
        } else if (option[1] < option[2]) {
            System.out.println(2);
        } else {
            System.out.println(0);
        }
    }
}
