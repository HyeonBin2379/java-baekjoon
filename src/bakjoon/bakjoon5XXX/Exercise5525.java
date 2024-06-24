package bakjoon.bakjoon5XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise5525 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int len = Integer.parseInt(br.readLine());
        String str = br.readLine();
        br.close();

        int count = 0;
        int result = 0;
        for (int i = 1; i < len-1;) {
            if (str.charAt(i) == 'O' && str.charAt(i+1) == 'I') {
                count++;
                if (count == N) {
                    if (str.charAt(i-2*count+1) == 'I') {
                        result++;
                    }
                    count--;
                }
                i += 2;
            } else {
                count = 0;
                i++;
            }
        }
        System.out.println(result);
    }
}
