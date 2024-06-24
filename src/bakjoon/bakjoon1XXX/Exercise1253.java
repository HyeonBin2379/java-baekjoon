package bakjoon.bakjoon1XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise1253 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        int[] numbers = new int[len];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(numbers);

        int count = 0;
        for (int i = 0; i < numbers.length; i++) {
            int start = 0, end = numbers.length-1;
            int find = numbers[i];
            while (start < end) {
                if (numbers[start] + numbers[end] > find) {
                    end--;
                }
                else if (numbers[start]+numbers[end] < find) {
                    start++;
                }
                else {
                    if (start != i && end != i) {
                        count++;
                        break;
                    }
                    else if (start == i) {
                        start++;
                    }
                    else {
                        end--;
                    }
                }
            }
        }
        System.out.println(count);
        br.close();
    }
}
