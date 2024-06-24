package bakjoon.bakjoon9XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise9398 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            String input = br.readLine();
            int answer = getLength(input);
            System.out.println(answer);
        }
    }

    public static int getLength(String input) {
        int minLen = 201;
        for (int i = 0; i < input.length()-5; i++) {
            for (int j = i+6; j < input.length()+1; j++) {
                String subStr = input.substring(i, j);
                boolean[] hasContained = new boolean[3];
                for (char c : subStr.toCharArray()) {
                    if (c >= 'a' && c <= 'z') {
                        hasContained[0] = true;
                    } else if (c >= 'A' && c <= 'Z') {
                        hasContained[1] = true;
                    } else if (c >= '0' && c <= '9'){
                        hasContained[2] = true;
                    }
                }
                if (hasContained[0] && hasContained[1] && hasContained[2]) {
                    minLen = Math.min(subStr.length(), minLen);
                }
            }
        }
        return minLen != 201 ? minLen : 0;
    }
}
