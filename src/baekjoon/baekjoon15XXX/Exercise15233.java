package baekjoon.baekjoon15XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Exercise15233 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        Set<String> teamA = Arrays.stream(br.readLine().split(" ", a)).collect(Collectors.toSet());
        Set<String> teamB = Arrays.stream(br.readLine().split(" ", b)).collect(Collectors.toSet());

        st = new StringTokenizer(br.readLine());
        int scoreA = 0, scoreB = 0;
        for (int i = 0; i < n; i++) {
            String name = st.nextToken();
            if (teamA.contains(name)) {
                scoreA++;
            } else if (teamB.contains(name)) {
                scoreB++;
            }
        }
        if (scoreA > scoreB) {
            System.out.println("A");
        } else if (scoreA < scoreB) {
            System.out.println("B");
        } else {
            System.out.println("TIE");
        }
    }
}
