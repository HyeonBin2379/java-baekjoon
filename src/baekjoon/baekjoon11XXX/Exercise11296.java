package baekjoon.baekjoon11XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise11296 {

    private enum Discount {
        RED("R", 45),
        GREEN("G", 30),
        BLUE("B", 20),
        YELLOW("Y", 15),
        ORANGE("O", 10),
        WHITE("W", 5);

        private final String color;
        private final int rate;

        Discount(String color, int rate) {
            this.color = color;
            this.rate = rate;
        }

        public double getCost(double cost) {
            return cost * (100-rate)/100.0;
        }

        public static double getDiscount(double cost, String dot) {
            return Arrays.stream(Discount.values())
                    .filter(discount -> discount.color.equals(dot))
                    .findFirst()
                    .get()
                    .getCost(cost);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            double original = Double.parseDouble(st.nextToken());
            String dotColor = st.nextToken();
            String coupon = st.nextToken();
            String payingType= st.nextToken();

            double discounted = Discount.getDiscount(original, dotColor);
            if (coupon.equals("C")) {
                discounted *= 0.95;
            }
            if (payingType.equals("C")) {
                discounted = Math.round(discounted * 10) /10.0;
            }
            System.out.printf("$%.2f\n", discounted);
        }
    }
}
