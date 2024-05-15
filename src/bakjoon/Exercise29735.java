package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise29735 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] time = new int[2];
        for (int i = 0; i < 2; i++) {
            int[] temp = Arrays.stream(st.nextToken().split(":")).mapToInt(Integer::parseInt).toArray();
            time[i] = temp[0] * 60 + temp[1];
        }
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        int deliveryPerDay = (time[1]-time[0]-1) / t;
        int deliveryTime = time[0] + (n % deliveryPerDay + 1)*t;
        System.out.println(n / deliveryPerDay);
        System.out.printf("%02d:%02d\n", deliveryTime/60, deliveryTime%60);
    }
}
