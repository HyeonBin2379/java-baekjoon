package bakjoon.bakjoon06XXX;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Exercise6603 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final int[] selected = new int[6];
    private static int[] numSet;
    private static boolean[] checked;

    public static void main(String[] args) throws IOException {
        while (true) {
            numSet = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            if (numSet[0] == 0) {
                break;
            }
            checked = new boolean[numSet[0]+1];
            selectLottoNumber(0);
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }

    public static void selectLottoNumber(int level) throws IOException {
        if (level == 6) {
            for (int i = 0; i < 6; i++) {
                bw.write(selected[i] + " ");
            }
            bw.write("\n");
            return;
        }

        for (int i = 1; i < numSet[0]+1; i++) {
            if (!checked[i]) {
                checked[i] = true;
                selected[level] = numSet[i];
                if (promising(level)) {
                    selectLottoNumber(level+1);
                }
                checked[i] = false;
            }
        }
    }
    private static boolean promising(int level) {
        for (int i = 0; i < level; i++) {
            if (selected[i] >= selected[i+1]) {
                return false;
            }
        }
        return true;
    }
}
