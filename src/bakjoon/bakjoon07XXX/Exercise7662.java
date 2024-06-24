package bakjoon.bakjoon07XXX;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.TreeMap;

public class Exercise7662 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            TreeMap<Integer, Integer> queue = new TreeMap<>();
            int k = Integer.parseInt(br.readLine());

            for (int j = 0; j < k ; j++) {
                String[] input = br.readLine().split(" ");
                int n = Integer.parseInt(input[1]);
                if (input[0].equals("I")) {
                    queue.put(n, queue.getOrDefault(n, 0)+1);
                    continue;
                }

                if (!queue.isEmpty()) {
                    int num = (n == 1) ? queue.lastKey() : queue.firstKey();
                    if (queue.get(num) > 1) {
                        queue.put(num, queue.get(num)-1);
                    } else {
                        queue.remove(num);
                    }
                }
            }

            bw.write(queue.isEmpty() ? "EMPTY\n" : queue.lastKey() + " " + queue.firstKey()+"\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
