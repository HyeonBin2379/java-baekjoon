package bakjoon.bakjoon21XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise21312 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int oddCount = 0;
        long odd = 1, even = 1;
        while (st.hasMoreTokens()) {
            long flavor = Long.parseLong(st.nextToken());
            if (flavor % 2 == 1) {
                odd *= flavor;
                oddCount++;
            } else {
                even *= flavor;
            }
        }
        System.out.println((oddCount > 0) ? odd : even);
    }
}
