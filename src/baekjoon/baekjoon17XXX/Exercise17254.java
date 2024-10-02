package baekjoon.baekjoon17XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Exercise17254 {

    private static class Node implements Comparable<Node>{
        int keyboardNum, time;
        String letter;

        public Node(int keyboardNum, int time, String letter) {
            this.keyboardNum = keyboardNum;
            this.time = time;
            this.letter = letter;
        }
        @Override
        public int compareTo(Node o) {
            return (this.time != o.time) ? Integer.compare(this.time, o.time) : Integer.compare(this.keyboardNum, o.keyboardNum);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        PriorityQueue<Node> queue = new PriorityQueue<>();
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            String c = st.nextToken();
            queue.add(new Node(a, b, c));
        }
        StringBuilder answer = new StringBuilder();
        while (!queue.isEmpty()) {
            answer.append(queue.poll().letter);
        }
        System.out.println(answer);
    }
}
