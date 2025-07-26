package algorithm.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Exercise16953 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(bfs(a, b));
    }

    private static long bfs(long start, long end) {
        Queue<Long[]> queue = new LinkedList<>();
        queue.add(new Long[]{start, 1L});

        while (!queue.isEmpty()) {
            Long[] now = queue.poll();

            if (now[0] == end) {
                return now[1];
            }

            long next = now[0]*2;
            if (next <= end) {
                queue.offer(new Long[]{next, now[1]+1});
            }
            next = 10*now[0]+1;
            if (next <= end) {
                queue.offer(new Long[]{next, now[1]+1});
            }
        }
        return -1;
    }
}
