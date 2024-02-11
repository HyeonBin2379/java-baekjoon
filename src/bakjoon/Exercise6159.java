package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise6159 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int[] array = new int[n];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }
        br.close();

        Arrays.sort(array);
        int count = 0;
        for (int i = 0; i < array.length-1; i++) {
            for (int j = i+1; j < array.length; j++) {
                if (array[i] + array[j] > s) {
                    break;
                }
                count++;
            }
        }
        System.out.println(count);
    }
}
