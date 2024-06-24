package bakjoon.bakjoon01XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Exercise1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int meetings = Integer.parseInt(br.readLine());
        List<Integer[]> schedule = new ArrayList<>();
        for (int i = 0; i < meetings; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            schedule.add(new Integer[]{end, start});
        }
        br.close();
        schedule.sort((o1, o2) -> {
            int comparison = o1[0] - o2[0];
            return (comparison == 0) ? o1[1] - o2[1] : comparison;
        });

        int count = 0;
        int end = -1;
        for (Integer[] meeting : schedule) {
            if (meeting[1] >= end) {
                end = meeting[0];
                count++;
            }
        }
        System.out.println(count);
    }
}