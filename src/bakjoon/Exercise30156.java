package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise30156 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            String input = br.readLine();
            int aCnt = (int) Arrays.stream(input.split("")).filter(s -> s.equals("a")).count();
            System.out.println(Math.min(aCnt, input.length()-aCnt));
        }
    }
}
