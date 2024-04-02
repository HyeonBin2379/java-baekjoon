package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise19786 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int[] rgb = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int[] score = new int[3];
            int max = 0, answer = i;
            for (int j = 0; j < 3; j++) {
                int[] temp = rgb.clone();
                temp[j]++;
                score[j] = a*(temp[0]*temp[0] + temp[1]*temp[1] + temp[2]*temp[2])
                        + c*Arrays.stream(temp).min().getAsInt();
                if (max < score[j]) {
                    max = score[j];
                    answer = j;
                }
            }

            switch (answer) {
                case 0 -> sb.append("RED\n");
                case 1 -> sb.append("GREEN\n");
                case 2 -> sb.append("BLUE\n");
            }
        }
        System.out.print(sb);
    }
}
