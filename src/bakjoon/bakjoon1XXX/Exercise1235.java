package bakjoon.bakjoon1XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise1235 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] stuNum = new String[n];
        for (int i = 0; i < n; i++) {
            stuNum[i] = br.readLine();
        }

        for (int i = 1; i <= stuNum[0].length(); i++) {
            int len = i;
            int count = (int) Arrays.stream(stuNum).map(s -> s.substring(stuNum[0].length()-len)).distinct().count();
            if (count == n) {
                System.out.println(i);
                return;
            }
        }
    }
}
