package baekjoon.baekjoon16XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.Arrays;

public class Exercise16199 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] birth = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] today = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        LocalDate pivot = LocalDate.of(today[0], birth[1], birth[2]);
        LocalDate now = LocalDate.of(today[0], today[1], today[2]);

        System.out.println(now.equals(pivot) || now.isAfter(pivot) ? today[0]-birth[0] : today[0]-birth[0]-1);
        System.out.println(today[0]-birth[0]+1);
        System.out.println(today[0]-birth[0]);
    }
}
