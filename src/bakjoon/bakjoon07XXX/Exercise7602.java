package bakjoon.bakjoon07XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise7602 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int count = 0;
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }
            int[] energyByLevel = new int[n];
            for (int i = 0; i < n; i++) {
                energyByLevel[i] = Integer.parseInt(br.readLine());
            }
            sb.append(String.format("Machine %d\n", ++count));
            while (true) {
                String input = br.readLine();
                if (input.equals("# 0")) {
                    break;
                }
                StringTokenizer st = new StringTokenizer(input);
                String name = st.nextToken();
                int e = Integer.parseInt(st.nextToken());

                int total = 0;
                for (int i = 0; i < e; i++) {
                    st = new StringTokenizer(br.readLine());
                    int level = Integer.parseInt(st.nextToken())-1;
                    int minute = Integer.parseInt(st.nextToken());
                    total += energyByLevel[level]*minute;
                }
                sb.append(String.format("%s %d\n", name, total));
            }
        }
        System.out.print(sb);
    }
}
