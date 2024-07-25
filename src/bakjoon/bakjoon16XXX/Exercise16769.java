package bakjoon.bakjoon16XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise16769 {

    private static class Milk {
        long cap, amount;

        public Milk(long cap, long amount) {
            this.cap = cap;
            this.amount = amount;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Milk[] bucket = new Milk[3];
        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long capacity = Long.parseLong(st.nextToken());
            long amount = Long.parseLong(st.nextToken());
            bucket[i] = new Milk(capacity, amount);
        }

        for (int i = 0; i < 100; i++) {
            switch (i % 3) {
                case 0 -> {
                    long pour1To2 = Math.min(bucket[0].amount, bucket[1].cap - bucket[1].amount);
                    bucket[0].amount -= pour1To2;
                    bucket[1].amount += pour1To2;
                }
                case 1 -> {
                    long pour2To3 = Math.min(bucket[1].amount, bucket[2].cap - bucket[2].amount);
                    bucket[1].amount -= pour2To3;
                    bucket[2].amount += pour2To3;
                }
                case 2 -> {
                    long pour3To1 = Math.min(bucket[2].amount, bucket[0].cap - bucket[0].amount);
                    bucket[2].amount -= pour3To1;
                    bucket[0].amount += pour3To1;
                }
            }
        }
        Arrays.stream(bucket).forEach(b -> System.out.println(b.amount));
    }
}
