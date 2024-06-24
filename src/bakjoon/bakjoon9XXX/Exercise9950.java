package bakjoon.bakjoon9XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise9950 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String input = br.readLine();
            if (input.equals("0 0 0")) {
                break;
            }
            int[] data = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int i = 0; i < data.length; i++) {
                if (data[i] == 0) {
                    switch (i) {
                        case 0 -> data[i] = data[2] / data[1];
                        case 1 -> data[i] = data[2] / data[0];
                        case 2 -> data[i] = data[0] * data[1];
                    }
                }
            }
            Arrays.stream(data).forEach(value -> sb.append(value).append(" "));
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
