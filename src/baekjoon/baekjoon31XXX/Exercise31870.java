package baekjoon.baekjoon31XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise31870 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] input = Arrays.stream(br.readLine().split(" ", n)).map(Integer::parseInt).toArray(Integer[]::new);

        int count1 = ascend(input);
        int count2 = descend(input);

        System.out.println(Math.min(count1, count2));
    }

    private static int ascend(Integer[] arr) {
        Integer[] asc = arr.clone();

        int count = 0;
        while (true) {
            int check = 0;

            for (int i = 0; i < arr.length-1; i++) {
                if (asc[i] > asc[i+1]) {
                    int temp = asc[i+1];
                    asc[i+1] = asc[i];
                    asc[i] = temp;
                    check++;
                }
            }

            if (check == 0) {
                break;
            }
            count += check;
        }
        return count;
    }

    private static int descend(Integer[] arr) {
        Integer[] desc = arr.clone();

        int count = 1;
        while (true) {
            int check = 0;

            for (int i = 0; i < arr.length-1; i++) {
                if (desc[i] < desc[i+1]) {
                    int temp = desc[i+1];
                    desc[i+1] = desc[i];
                    desc[i] = temp;

                    check++;
                }
            }

            if (check == 0) {
                break;
            }
            count += check;
        }
        return count;
    }
}
