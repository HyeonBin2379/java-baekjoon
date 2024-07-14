package programmers;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CrossingTruck {

    private static class Node {
        int weight, distance;

        public Node(int weight, int distance) {
            this.weight = weight;
            this.distance = distance;
        }
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> truck = Arrays.stream(truck_weights).boxed().collect(Collectors.toCollection(LinkedList::new));
        Deque<Node> bridge = new ArrayDeque<>();
        int time = 0;
        while (!truck.isEmpty() || !bridge.isEmpty()) {
            if (!bridge.isEmpty() && bridge.peek().distance == 0) {
                bridge.pollFirst();
            }

            int currentWeight = bridge.stream().map(node -> node.weight).reduce(0, Integer::sum);
            if (!truck.isEmpty() && truck.peek() + currentWeight <= weight) {
                bridge.addLast(new Node(truck.poll(), bridge_length));
            }

            IntStream.rangeClosed(0, bridge.size()-1).forEach(i -> {
                Node t = bridge.pollFirst();
                bridge.addLast(new Node(t.weight, t.distance-1));
            });
            time++;
        }
        return time;
    }

    public static void main(String[] args) {
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7, 4, 5, 6};
        System.out.println(solution(bridge_length, weight, truck_weights));
    }
}
