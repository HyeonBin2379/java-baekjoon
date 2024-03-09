package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise24830 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        long[] result = new long[count+1];
        result[0] = 1;
        for (int i = 0; i < count; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            String op = st.nextToken();
            long b = Long.parseLong(st.nextToken());

            switch (op) {
                case "+" -> {
                    long temp = (a + b) - result[i];
                    result[i+1] = temp;
                    System.out.println(temp);
                }
                case "-" -> {
                    long temp = (a - b) * result[i];
                    result[i+1] = temp;
                    System.out.println(temp);
                }
                case "*" -> {
                    long temp = (long) Math.pow((a * b), 2);
                    result[i+1] = temp;
                    System.out.println(temp);
                }
                case "/" -> {
                    long temp = (a % 2 == 0) ? a / 2 : (a + 1) / 2;
                    result[i+1] = temp;
                    System.out.println(temp);
                }
            }
        }
    }
}
