package baekjoon.baekjoon21XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise21573 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int room = Integer.parseInt(st.nextToken());
        int cond = Integer.parseInt(st.nextToken());
        String mode = br.readLine();

        switch (mode) {
            case "freeze" -> System.out.println(Math.min(room, cond));
            case "heat" -> System.out.println(Math.max(room, cond));
            case "auto" -> System.out.println(cond);
            case "fan" -> System.out.println(room);
        }
    }
}
