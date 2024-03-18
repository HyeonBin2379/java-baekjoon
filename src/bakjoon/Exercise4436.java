package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Exercise4436 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input;
        while ((input = br.readLine()) != null) {
            Set<Integer> digit = new HashSet<>();
            long n = Long.parseLong(input);

            int count = 0;
            long num = n;
            while (digit.size() != 10) {
                String[] numStr = Long.toString(num).split("");
                for (String s : numStr) {
                    digit.add(Integer.parseInt(s));
                }
                num += n;
                count++;
            }
            sb.append(count).append("\n");
        }
        System.out.print(sb);
    }
}
