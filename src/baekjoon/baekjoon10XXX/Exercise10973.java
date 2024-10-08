package baekjoon.baekjoon10XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Exercise10973 {
    private static Integer[] original;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        original = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);

        for (int i = n-1; i > 0; i--) {
            if (original[i-1] > original[i]) {
                for (int j = n-1; j > 0; j--) {
                    if (original[i-1] > original[j]) {
                        swap(i-1, j);
                        Integer[] answer = getAnswer(i);
                        Arrays.stream(answer).forEach(value -> System.out.print(value + " "));
                        return;
                    }
                }
            }
        }
        System.out.println(-1);
    }

    private static void swap(int i, int j) {
        int temp = original[i];
        original[i] = original[j];
        original[j] = temp;
    }

    private static Integer[] getAnswer(int index) {
        Integer[] selected = new Integer[original.length];
        Integer[] subArray = Arrays.copyOfRange(original, index, original.length);
        Arrays.sort(subArray, Collections.reverseOrder());
        System.arraycopy(original, 0, selected, 0, index);
        System.arraycopy(subArray, 0, selected, index, subArray.length);
        return selected;
    }
}
