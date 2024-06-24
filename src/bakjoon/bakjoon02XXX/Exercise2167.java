package bakjoon.bakjoon02XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise2167 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] size = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[][] array = new int[size[0]][size[1]];
        for (int i = 0; i < size[0]; i++) {
            array[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            int[] fromTo = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            sb.append(getSum(array, fromTo)).append("\n");
        }
        br.close();
        System.out.print(sb);
    }

    public static int getSum(int[][] array, int[] pos) {
        int sum = 0;
        for (int i = pos[0]-1; i < pos[2]; i++) {
            for (int j = pos[1]-1; j < pos[3]; j++) {
                sum += array[i][j];
            }
        }
        return sum;
    }
}
