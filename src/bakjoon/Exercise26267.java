package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise26267 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int bullet = 0, count = 0;
        for (int i = 0; i < n; i++) {
            String cmd = br.readLine();
            switch (cmd) {
                case "save" -> bullet = count;
                case "load" -> count = bullet;
                case "shoot" -> count--;
                case "ammo" -> count += k;
            }
            System.out.println(count);
        }
    }
}
