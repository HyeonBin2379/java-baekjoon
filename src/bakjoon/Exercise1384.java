package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise1384 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int count = 0;

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }
            String[][] msgLog = new String[n][n];
            sb.append(String.format("Group %d\n", ++count));
            for (int i = 0; i < n; i++) {
                msgLog[i] = br.readLine().split(" ");
            }

            boolean isAllPositive = true;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (msgLog[i][j].equals("N")) {
                        int index = (i < j) ? n-j+i : i-j;
                        sb.append(String.format("%s was nasty about %s\n", msgLog[index][0], msgLog[i][0]));
                        isAllPositive = false;
                    }
                }
            }
            if (isAllPositive) {
                sb.append("Nobody was nasty\n");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
