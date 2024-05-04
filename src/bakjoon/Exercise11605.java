package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Exercise11605 {

    private static final List<Command> log = new ArrayList<>();

    private static class Command {
        String operator;
        int operand;

        public Command(String operator, int operand) {
            this.operator = operator;
            this.operand = operand;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String oper = st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            log.add(new Command(oper, num));
        }

        int count = 0;
        for (int i = 1; i <= 100; i++) {
            count += (hasError(i)) ? 1 : 0;
        }
        System.out.println(count);
    }

    private static boolean hasError(int init) {
        int result = init;
        for (Command cmd : log) {
            switch (cmd.operator) {
                case "ADD" -> result += cmd.operand;
                case "SUBTRACT" -> {
                    if (result - cmd.operand < 0) {
                        return true;
                    }
                    result -= cmd.operand;
                }
                case "MULTIPLY" -> result *= cmd.operand;
                case "DIVIDE" -> {
                    if (result % cmd.operand != 0) {
                        return true;
                    }
                    result /= cmd.operand;
                }
            }
        }
        return false;
    }
}
