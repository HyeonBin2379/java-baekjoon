package bakjoon.bakjoon20XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise20546 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cash = Integer.parseInt(br.readLine());
        int[] stock = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int joon = getBenefitByBNP(cash, stock);
        int seong = getBenefitByTiming(cash, stock);

        if (joon == seong) {
            System.out.println("SAMESAME");
        } else if (joon > seong) {
            System.out.println("BNP");
        } else {
            System.out.println("TIMING");
        }
    }

    private static int getBenefitByBNP(int cash, int[] stock) {
        int cnt = 0;
        for (int j : stock) {
            if (cash/j >= 1) {
                cnt = cash / j;
                cash %= j;
                break;
            }
        }
        return cnt * stock[13] + cash;
    }

    private static int getBenefitByTiming(int cash, int[] stock) {
        int upCombo = 1, downCombo = 0;
        int cnt = 0;
        for (int i = 1; i < stock.length; i++) {
            if (stock[i-1] < stock[i]) {
                upCombo++;
                downCombo = 0;
            } else if (stock[i-1] > stock[i]) {
                downCombo++;
                upCombo = 0;
            }

            if (upCombo >= 3) {
                cash += cnt * stock[i];
                cnt = 0;
            } else if (downCombo >= 3) {
                cnt += cash / stock[i];
                cash %= stock[i];
            }
        }
        return cnt * stock[13] + cash;
    }
}
