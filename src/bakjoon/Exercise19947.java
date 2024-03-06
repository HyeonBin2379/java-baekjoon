package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise19947 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int[] benefit = new int[y+1];
        benefit[0] = h;
        for (int i = 1; i <= y; i++) {
            if (i < 3) {
                benefit[i] = (int) (benefit[i-1]*1.05);
            } else if (i < 5){
                benefit[i] = Math.max((int) (benefit[i-1]*1.05), (int) (benefit[i-3]*1.20));
            } else {
                benefit[i] = Math.max((int) (benefit[i-1]*1.05), Math.max((int) (benefit[i-3]*1.20), (int) (benefit[i-5]*1.35)));
            }
        }
        System.out.println(benefit[y]);
    }
}
