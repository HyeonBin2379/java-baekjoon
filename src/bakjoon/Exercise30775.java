package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise30775 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long m = Long.parseLong(st.nextToken());
        long k = Long.parseLong(st.nextToken());

        long sum = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            long participants = Long.parseLong(st.nextToken());
            sum += participants;
        }
        System.out.println((long)Math.ceil((double)sum/m));
    }
}
