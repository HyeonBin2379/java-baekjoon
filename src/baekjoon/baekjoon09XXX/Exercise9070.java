package baekjoon.baekjoon09XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Exercise9070 {

    private static class Matsal implements Comparable<Matsal>{
        int amount, price;

        public Matsal(int amount, int price) {
            this.amount = amount;
            this.price = price;
        }

        @Override
        public int compareTo(Matsal o) {
            double p1 = (double)this.amount/this.price;
            double p2 = (double)o.amount/o.price;
            return p1 != p2 ? Double.compare(p2, p1) : Integer.compare(this.price, o.price);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());
        while (testcase-- > 0) {
            int n = Integer.parseInt(br.readLine());
            PriorityQueue<Matsal> pq = new PriorityQueue<>();
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int amount = Integer.parseInt(st.nextToken());
                int price = Integer.parseInt(st.nextToken());
                pq.offer(new Matsal(amount, price));
            }
            if (!pq.isEmpty()) {
                System.out.println(pq.peek().price);
            }
        }
    }
}
