package baekjoon.baekjoon13XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Exercise13335 {

    private static class Node {
        int weight, distance;

        public Node(int weight, int distance) {
            this.weight = weight;
            this.distance = distance;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        Queue<Integer> truck = Arrays.stream(br.readLine().split(" ", n))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedList::new));
        Deque<Node> bridge = new ArrayDeque<>();
        int time = 0;
        while (!truck.isEmpty() || !bridge.isEmpty()) {
            // 1. 일렬 나열된 트럭 중 맨 앞의 트럭이 다리건너기 완료
            if (!bridge.isEmpty() && bridge.peek().distance == 0) {
                bridge.pollFirst();
            }
            // 2. 다리 위에 있는 트럭의 무게의 총합
            int currentWeight = bridge.stream().map(node -> node.weight).reduce(0, Integer::sum);

            // 3. 다리 위 트럭 무게의 총합+다음 트럭 무게가 다리의 최대하중 이하면 다음 트럭은 다리 위로 이동
            if (!truck.isEmpty() && truck.peek() + currentWeight <= l) {
                bridge.addLast(new Node(truck.poll(), w));
            }
            // 4. 현재 다리 위에 일렬로 나열된 트럭은 단위 길이만큼 이동
            IntStream.rangeClosed(0, bridge.size()-1).forEach(i -> {
                Node t = bridge.pollFirst();
                if (t != null){
                    bridge.addLast(new Node(t.weight, t.distance - 1));
                }
            });
            time++;
        }
        System.out.println(time);
    }
}
