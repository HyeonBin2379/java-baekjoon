package baekjoon.baekjoon11XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Exercise11000 {

    static class Room {
        int start;
        int end;

        public Room(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Room> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list.add(new Room(start, end));
        }
        list.sort((o1, o2) -> o1.start != o2.start
                ? Integer.compare(o1.start, o2.start)
                : Integer.compare(o1.end, o2.end));

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (Room room : list) {
            pq.add(room.end);
            if (!pq.isEmpty() && pq.peek() <= room.start) {
                pq.poll();
            }
        }

        System.out.println(pq.size());
    }
}
