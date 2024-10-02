package baekjoon.baekjoon01XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise1940 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        int num = Integer.parseInt(br.readLine());

        int[] materials = new int[len];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < materials.length; i++) {
            materials[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(materials);

        int first_idx = 0, second_idx = materials.length-1;
        int count = 0;
        while (first_idx < second_idx) {
            if (materials[first_idx]+materials[second_idx] < num) {
                first_idx++;
            }
            else if (materials[first_idx]+materials[second_idx] > num) {
                second_idx--;
            }
            else {
                first_idx++;
                second_idx--;
                count++;
            }
        }

        System.out.println(count);
        br.close();
    }
}
