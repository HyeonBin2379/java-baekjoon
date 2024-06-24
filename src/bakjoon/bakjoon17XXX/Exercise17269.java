package bakjoon.bakjoon17XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise17269 {

    private static final int[] num = {3, 2, 1, 2, 4, 3, 1, 3, 1, 1, 3, 1, 3, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String[] name = br.readLine().split(" ");
        int[] cnt = initialize(name, n, m);
        while (cnt.length > 2) {
            cnt = setArray(cnt, cnt.length);
        }
        System.out.printf("%d%%\n", (cnt[0]*10 + cnt[1]));
    }

    private static int[] initialize(String[] names, int n, int m) {
        StringBuilder init = new StringBuilder();
        for (int i = 0; i < Math.min(n, m); i++) {
            init.append(names[0].charAt(i)).append(names[1].charAt(i));
        }
        init.append(n < m ? names[1].substring(n) : names[0].substring(m));

        char[] temp = init.toString().toCharArray();
        int[] result = new int[n+m];
        for (int i = 0; i < temp.length; i++) {
            result[i] = num[temp[i]-'A'];
        }
        return result;
    }

    private static int[] setArray(int[] cnt, int len) {
        int[] result = new int[len-1];
        for (int i = 0; i < len-1; i++) {
            result[i] = (cnt[i] + cnt[i+1]) % 10;
        }
        return result;
    }
}
