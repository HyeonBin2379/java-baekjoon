package codekata.programmers;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class StockPrice {

    private final Deque<Stock> stack = new ArrayDeque<>();

    static class Stock {
        int price;
        int idx;

        public Stock(int price, int idx) {
            this.price = price;
            this.idx = idx;
        }
    }

    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        // 시간 경과
        for (int i = 0; i < prices.length; i++) {
            // 가격 유지/상승 중인 주식만 stack에 남김
            for (Stock stock : stack) {
                answer[stock.idx]++;
            }
            // 가격이 하락한 주식만 stack에서 제외
            while (!stack.isEmpty() && prices[i] < stack.peek().price) {
                stack.pop();
            }
            stack.push(new Stock(prices[i], i));
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
