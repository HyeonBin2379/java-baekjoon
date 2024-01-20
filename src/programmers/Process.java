package programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class ProcessSolution {
    private static class Node {
        int index;
        int rank;

        public Node(int index, int rank) {
            this.index = index;
            this.rank = rank;
        }
    }

    public int solution(int[] priorities, int location) {
        Queue<Node> queue = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            queue.add(new Node(i, priorities[i]));
        }

        List<Integer> order = new ArrayList<>();
        while (queue.peek() != null) {
            Node now = queue.poll();
            if (queue.stream().anyMatch(node -> node.rank > now.rank)) {
                queue.add(now);
                continue;
            }
            order.add(now.index);
        }
        return order.indexOf(location) + 1;
    }
}
public class Process {
    public static void main(String[] args) {
        int[] priorities = {1, 1, 9, 1, 1, 1};
        int location = 0;
        System.out.println(new ProcessSolution().solution(priorities, location));
    }
}
