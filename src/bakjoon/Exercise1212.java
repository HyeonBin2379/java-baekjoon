package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise1212 {
    private static final String[] octToBinary = {"000", "001", "010", "011", "100", "101", "110", "111"};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder binary = new StringBuilder();
        int[] oct = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        for (int i : oct) {
            binary.append(octToBinary[i]);
        }
        String result = binary.toString();
        System.out.println((result.contains("1")) ? result.substring(result.indexOf("1")) : "0");
    }
}
