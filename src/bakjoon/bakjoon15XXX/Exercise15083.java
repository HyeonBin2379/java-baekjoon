package bakjoon.bakjoon15XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise15083 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] price = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] coupon = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        double one = Arrays.stream(price).sum()*coupon[0]/100.0;
        Arrays.sort(price);

        double two = price[1]*Math.min(coupon[1], coupon[2])/100.0 + price[2]*Math.max(coupon[1], coupon[2])/100.0;
        if (Double.compare(one, two) > 0) {
            System.out.printf("one %.2f\n", one);
        } else {
            System.out.printf("two %.2f\n", two);
        }
    }
}
