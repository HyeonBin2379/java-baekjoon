package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise25642 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int yt = Integer.parseInt(st.nextToken());
        int yj = Integer.parseInt(st.nextToken());

        while (true) {
            if (yj + yt >= 5) {
                System.out.println("yt");
                break;
            }
            yj += yt;
            if (yt + yj >= 5) {
                System.out.println("yj");
                break;
            }
            yt += yj;
        }
    }
}
