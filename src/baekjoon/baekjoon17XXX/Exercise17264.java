package baekjoon.baekjoon17XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Exercise17264 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int g = Integer.parseInt(st.nextToken());

        Set<String> alwaysWin = new HashSet<>();
        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String winOrLose = st.nextToken();
            if (winOrLose.equals("W")) {
                alwaysWin.add(name);
            }
        }
        int score = 0;
        for (int i = 0; i < n; i++) {
            if (score >= g) {
                System.out.println("I AM NOT IRONMAN!!");
                return;
            }
            String player = br.readLine();
            if (alwaysWin.contains(player)) {
                score += w;
            } else {
                score = Math.max(score-l, 0);
            }
        }
        System.out.println("I AM IRONMAN!!");
    }
}
