package bakjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Exercise2490 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < 3; i++) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int sum = Arrays.stream(input).sum();
            switch (sum) {
                case 0 -> bw.write("D"+"\n");
                case 1 -> bw.write("C"+"\n");
                case 2 -> bw.write("B"+"\n");
                case 3 -> bw.write("A"+"\n");
                case 4 -> bw.write("E"+"\n");
            }
        }
        br.close();

        bw.flush();
        bw.close();
    }
}
