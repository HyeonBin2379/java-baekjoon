package algorithm.map;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Exercise13414 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        Map<String, Integer> waitingQueue = new HashMap<>();
        for (int i = 1; i <= l; i++) {
            st = new StringTokenizer(br.readLine());
            String id = st.nextToken();
            waitingQueue.put(id, i);
        }
        br.close();

        waitingQueue.keySet().stream()
                .sorted(Comparator.comparingInt(waitingQueue::get))
                .limit(k)
                .forEach(s -> sb.append(s).append("\n"));
        bw.write(sb.toString());
        bw.close();
    }
}
