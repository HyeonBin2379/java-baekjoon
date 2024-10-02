package baekjoon.baekjoon03XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Exercise3230 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Integer> player = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            int rank = Integer.parseInt(br.readLine())-1;
            player.add(rank, i);
        }

        List<Integer> result = new LinkedList<>();
        for (int i = m-1; i >= 0; i--) {
            int num = player.get(i);
            int rank = Integer.parseInt(br.readLine())-1;
            result.add(rank, num);
        }

        for (int i = 0; i < 3; i++) {
            System.out.println(result.get(i)+1);
        }
    }
}
