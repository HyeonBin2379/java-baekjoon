package baekjoon.baekjoon14XXX;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Exercise14670 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<Integer, Integer> medicine = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int effectiveBy = Integer.parseInt(st.nextToken());
            int medNum = Integer.parseInt(st.nextToken());
            medicine.put(effectiveBy, medNum);
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());

            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < r; j++) {
                int symptom = Integer.parseInt(st.nextToken());
                if (!medicine.containsKey(symptom)) {
                    sb.setLength(0);
                    sb.append("YOU DIED");
                    break;
                }
                sb.append(medicine.get(symptom)).append(" ");
            }
            bw.write(sb + "\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
