package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Exercise25850 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> total = new ArrayList<>();
        List<List<Integer>> players = new ArrayList<>();
        int p = Integer.parseInt(br.readLine());

        for (int i = 0; i < p; i++) {
            players.add(new ArrayList<>());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int len = Integer.parseInt(st.nextToken());
            for (int j = 0; j < len; j++) {
                int num = Integer.parseInt(st.nextToken());
                players.get(i).add(num);
                total.add(num);
            }
            Collections.sort(players.get(i));
        }
        Collections.sort(total);

        StringBuilder answer = new StringBuilder();
        for (Integer num : total) {
            for (int i = 0; i < players.size(); i++) {
                if (players.get(i).contains(num)) {
                    answer.append((char)('A' + i));
                }
            }
        }
        System.out.println(answer);
    }
}
