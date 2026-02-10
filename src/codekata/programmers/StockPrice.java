package codekata.programmers;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class StockPrice {

    private final Deque<Stock> stack = new ArrayDeque<>();

    static class Stock {
        int price;
        int time;

        public Stock(int price, int time) {
            this.price = price;
            this.time = time;
        }
    }

    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        // 시간 경과
        for (int i = 0; i < prices.length; i++) {
            // 가격이 하락한 주식은 stack에서 제외, 가격 하락 시점에 계산
            while (!stack.isEmpty() && prices[i] < stack.peek().price) {
                Stock popped = stack.pop();
                answer[popped.time] = i - popped.time;
            }
            stack.push(new Stock(prices[i], i));
        }
        // 시간이 종료될 때까지 가격이 떨어지지 않은 시간 계산
        while (!stack.isEmpty()) {
            Stock popped = stack.pop();
            answer[popped.time] = prices.length-1-popped.time;
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 2, 3};
        StockPrice stockPrice = new StockPrice();
        int[] result = stockPrice.solution(prices);
        System.out.println(Arrays.toString(result));
    }
}
