package baekjoon.baekjoon27XXX;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Exercise27440 {

    private static final Set<Long> visited = new TreeSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        bfs(n);
    }

    private static void bfs(long num) {
        Queue<Long[]> queue = new ArrayDeque<>();
        visited.add(num);
        queue.offer(new Long[]{num, 0L});

        while (!queue.isEmpty()) {
            Long[] now = queue.poll();
            if (now[0] == 1) {
                System.out.println(now[1]);
                break;
            }

            if (now[0] % 3 == 0 && !visited.contains(now[0]/3)) {
                visited.add(now[0]/3);
                queue.add(new Long[]{now[0]/3, now[1]+1});
            }
            if (now[0] % 2 == 0 && !visited.contains(now[0]/2)) {
                visited.add(now[0]/2);
                queue.add(new Long[]{now[0]/2, now[1]+1});
            }
            if (!visited.contains(now[0]-1)){
                visited.add(now[0]-1);
                queue.offer(new Long[]{now[0]-1, now[1]+1});
            }
        }
    }
}
