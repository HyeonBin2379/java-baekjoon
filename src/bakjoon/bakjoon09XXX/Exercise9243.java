package bakjoon.bakjoon09XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise9243 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] original = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        int[] newFile = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        System.out.println(isDeleted(original, newFile, n) ? "Deletion succeeded" : "Deletion failed");
    }

    private static boolean isDeleted(int[] original, int[] newFile, int count) {
        for (int i = 0; i < original.length; i++) {
            for (int j = 1; j <= count; j++) {
                original[i] ^= 1;
            }
            if (original[i] != newFile[i]) {
                return false;
            }
        }
        return true;
    }
}
