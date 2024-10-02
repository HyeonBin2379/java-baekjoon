package baekjoon.baekjoon25XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise25828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int g = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        br.close();
        int byGroup = g + p * t;
        int byPeople = g * p;
        if (byGroup > byPeople) {
            System.out.println(1);
        } else if (byGroup == byPeople) {
            System.out.println(0);
        } else {
            System.out.println(2);
        }
    }
}
