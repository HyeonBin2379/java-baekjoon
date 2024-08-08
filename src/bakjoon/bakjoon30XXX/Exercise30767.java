package bakjoon.bakjoon30XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise30767 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        long a = Long.parseLong(br.readLine());
        long b = Long.parseLong(br.readLine());
        long c = Long.parseLong(br.readLine());
        long d = Long.parseLong(br.readLine());

        long start = Math.max(a, n-d);
        long end = Math.min(b, n-c);
        System.out.println(Math.max(0, end-start+1));
    }
}
