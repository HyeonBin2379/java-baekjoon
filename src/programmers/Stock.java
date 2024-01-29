package programmers;

import java.util.Arrays;
import java.util.Stack;

class StockSolution {
    private static class Node {
        int price, index;

        public Node(int price, int index) {
            this.price = price;
            this.index = index;
        }
    }

    public int[] solution(int[] prices) {
        Stack<Node> stack = new Stack<>();
        int[] answer = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            for (Node node : stack) {
                answer[node.index]++;
            }
            while (!stack.isEmpty() && stack.peek().price > prices[i]) {
                stack.pop();
            }
            stack.push(new Node(prices[i], i));
        }
        return answer;
    }
}

public class Stock {
    public static void main(String[] args) {
        int[] price = {1, 2, 3, 2, 3};
        System.out.println(Arrays.toString(new StockSolution().solution(price)));
    }
}
