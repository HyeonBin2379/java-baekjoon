package baekjoon.baekjoon07XXX;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Exercise7795 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            int[] lengths = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] B = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            Arrays.sort(A);
            Arrays.sort(B);
            int result = 0;
            int pos_A = 0, pos_B = 0;
            while (pos_A < lengths[0] && pos_B < lengths[1]) {
                if (A[pos_A] > B[pos_B]) {
                    result += A.length-pos_A;
                    pos_B++;
                } else {
                    pos_A++;
                }
            }
            bw.write(result+"\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
