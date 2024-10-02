package baekjoon.baekjoon29XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise29734 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());   // 집에서 과제하는 시간
        long m = Long.parseLong(st.nextToken());   // 독서실에서 과제하는 시간

        st = new StringTokenizer(br.readLine());
        long t = Long.parseLong(st.nextToken()); // 집-독서실 이동 시간
        long s = Long.parseLong(st.nextToken()); // 수면 시간

        long zip = n + (n-1)/ 8 * s;
        long dok = t + m + (m-1)/8 * (2 * t + s);
        if (zip > dok) {
            System.out.println("Dok" + "\n" + dok);
        } else {
            System.out.println("Zip" + "\n" + zip);
        }
    }
}
