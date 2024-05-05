package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise5656 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int count = 0;

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            String op = st.nextToken();
            int num2 = Integer.parseInt(st.nextToken());

            if (op.equals("E")) {
                break;
            }
            sb.append(String.format("Case %d: ", ++count));
            switch (op) {
                case "!=" -> sb.append(num1 != num2);
                case ">" -> sb.append(num1 > num2);
                case ">=" -> sb.append(num1 >= num2);
                case "<" -> sb.append(num1 < num2);
                case "<=" -> sb.append(num1 <= num2);
                case "==" -> sb.append(num1 == num2);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
