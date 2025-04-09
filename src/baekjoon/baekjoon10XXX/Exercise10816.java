package baekjoon.baekjoon10XXX;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Exercise10816 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        Map<Integer, Integer> map = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (n-- > 0) {
            int number = Integer.parseInt(st.nextToken());
            map.merge(number, 1, Integer::sum);
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        br.close();
        while (m-- > 0) {
            int number = Integer.parseInt(st.nextToken());
            bw.write(map.getOrDefault(number, 0) + " ");
        }
        bw.close();
    }
}
