package baekjoon.baekjoon13XXX;

import java.io.*;
import java.util.*;

public class Exercise13414 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int L = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Map<String, Integer> queue = new LinkedHashMap<>();
        for (int i = 1; i <= K; i++) {
            String student = br.readLine();
            queue.put(student, i);
        }
        br.close();

        List<String> keySet = new ArrayList<>(queue.keySet());
        keySet.sort(Comparator.comparing(queue::get));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < Math.min(keySet.size(), L); i++) {
            bw.write(keySet.get(i)+"\n");
        }
        bw.flush();
        bw.close();
    }
}
