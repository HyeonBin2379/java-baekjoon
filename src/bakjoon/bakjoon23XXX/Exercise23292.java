package bakjoon.bakjoon23XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise23292 {

    private static final int[] birthday = new int[3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int birth = Integer.parseInt(br.readLine());
        birthday[0] = birth / 10000;
        birthday[1] = (birth % 10000) / 100;
        birthday[2] = birth % 100;


        int n = Integer.parseInt(br.readLine());
        int max = 0, answer = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int date = Integer.parseInt(br.readLine());
            int result = calculateBioRhythm(date);
            if (max < result) {
                max = result;
                answer = date;
            } else if (max == result) {
                answer = Math.min(date, answer);
            }
        }
        System.out.println(answer);
    }

    private static int calculateBioRhythm(int codingDay) {
        int[] date = new int[3];
        date[0] = codingDay / 10000;
        date[1] = (codingDay % 10000) / 100;
        date[2] = codingDay % 100;

        int result = 1;
        int[] temp = birthday.clone();
        for (int i = 0; i < 3; i++) {
            int sum = 0;
            while (temp[i] > 0 || date[i] > 0) {
                int n1 = temp[i] % 10;
                int n2 = date[i] % 10;
                sum += (n1-n2)*(n1-n2);
                temp[i] /= 10;
                date[i] /= 10;
            }
            result *= sum;
        }
        return result;
    }
}
