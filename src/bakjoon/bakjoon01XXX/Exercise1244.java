package bakjoon.bakjoon01XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise1244 {

    private static boolean[] light;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        light = new boolean[n+1];
        for (int i = 1; i <= n; i++) {
            light[i] = Integer.parseInt(st.nextToken()) == 1;
        }

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            switch (gender) {
                case 1 -> setLightByMale(num, n);
                case 2 -> setLightByFemale(num, n);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append((light[i] ? 1 : 0)).append(" ");
            if (i % 20 == 0) {
                sb.append("\n");
            }
        }
        System.out.print(sb);
    }

    private static void setLightByMale(int num, int n) {
        for (int i = num; i <= n; i += num) {
            light[i] = !light[i];
        }
    }

    private static void setLightByFemale(int num, int n) {
        light[num] = !light[num];
        for (int i = 1; i < n/2; i++) {
            if (num + i > n || num - i < 1) {
                break;
            }
            if (light[num-i] != light[num+i]) {
                break;
            }
            light[num-i] = !light[num-i];
            light[num+i] = !light[num+i];
        }
    }
}
