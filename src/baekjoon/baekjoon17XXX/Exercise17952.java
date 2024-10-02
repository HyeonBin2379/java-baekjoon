package baekjoon.baekjoon17XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Exercise17952 {

    private static class Homework {
        int score, remainedTime;
        public Homework(int score, int remainedTime) {
            this.score = score;
            this.remainedTime = remainedTime;
        }
        public void setRemainedTime(int time) {
            remainedTime = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Deque<Homework> stack = new ArrayDeque<>();
        int totalScore = 0;
        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int query = Integer.parseInt(st.nextToken());
            if (query == 1) {
                int score = Integer.parseInt(st.nextToken());
                int time = Integer.parseInt(st.nextToken());
                stack.push(new Homework(score, time));
            }
            if (!stack.isEmpty() && stack.peek().remainedTime != 0) {
                int time = stack.peek().remainedTime;
                stack.peek().setRemainedTime(time - 1);
            }
            if (!stack.isEmpty() && stack.peek().remainedTime == 0) {
                totalScore += stack.peek().score;
                stack.pop();
            }
        }
        System.out.println(totalScore);
    }
}
