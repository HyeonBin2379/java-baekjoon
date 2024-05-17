package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise30009 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int left = x-r, right = x+r;
        int inside = 0, boundary = 0;
        for (int i = 0; i < n; i++) {
            int line = Integer.parseInt(br.readLine());
            if (line == left || line == right) {
                boundary++;
            } else if (line > left && line < right) {
                inside++;
            }
        }
        System.out.println(inside + " " + boundary);
    }
}
