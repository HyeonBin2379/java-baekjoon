package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise31458 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String exp = br.readLine();
            int num = 0;
            int notCnt = 0, factCnt = 0;
            for (int j = 0; j < exp.length(); j++) {
                if (Character.isDigit(exp.charAt(j))) {
                    num = exp.charAt(j)-'0';
                    notCnt = j;
                    factCnt = exp.length()-1-notCnt;
                    break;
                }
            }
            if (num == 0 && factCnt >= 1) {
                num = 1;
            }
            if (notCnt % 2 == 0) {
                num = (num == 1) ? 1 : 0;
            } else {
                num = (num == 1) ? 0 : 1;
            }
            System.out.println(num);
        }
    }
}
