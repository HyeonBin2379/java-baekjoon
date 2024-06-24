package bakjoon.bakjoon13XXX;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise13496 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 1; i <= testCase; i++) {
            int[] nsd = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int sum = 0;
            for (int j = 0; j < nsd[0]; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int distance = Integer.parseInt(st.nextToken());
                int ducat = Integer.parseInt(st.nextToken());
                sum += (distance <= nsd[1]*nsd[2]) ? ducat : 0;
            }
            bw.write(String.format("Data Set %d:\n", i));
            bw.write(sum + "\n\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
