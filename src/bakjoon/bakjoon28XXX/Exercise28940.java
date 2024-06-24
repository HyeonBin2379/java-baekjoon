package bakjoon.bakjoon28XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise28940 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] diary = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] letter = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int page = (diary[0]/letter[1])*(diary[1]/letter[2]);
        System.out.println((page == 0) ? -1 : (int) Math.ceil((double) letter[0] / page));
    }
}
