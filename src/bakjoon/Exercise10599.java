package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise10599 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String input = br.readLine();
            if (input.equals("0 0 0 0")) {
                break;
            }
            StringTokenizer st = new StringTokenizer(input);
            int minBirth = Integer.parseInt(st.nextToken());
            int maxBirth = Integer.parseInt(st.nextToken());
            int minDeath = Integer.parseInt(st.nextToken());
            int maxDeath = Integer.parseInt(st.nextToken());

            System.out.println((minDeath-maxBirth) + " " + (maxDeath-minBirth));
        }
    }
}
