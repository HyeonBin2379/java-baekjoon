package baekjoon.baekjoon11XXX;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;


public class Exercise11003 {

    private static class Pair {
        private int index;
        private long value;
        public Pair(int index, long value) {
            this.index = index;
            this.value = value;
        }
        public int getIndex() {
            return index;
        }
        public long getValue() {
            return value;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int totalLen = Integer.parseInt(st.nextToken());
        int windowLen = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Pair[] now = new Pair[totalLen+1];
        for (int i = 1; i < now.length; i++) {
            now[i] = Pair.class.getConstructor(int.class, long.class)
                    .newInstance(i, Long.parseLong(st.nextToken()));
        }
        br.close();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Deque<Pair> deque = new ArrayDeque<>();
        for (int i = 1; i < now.length; i++) {
            while (!deque.isEmpty() && deque.getLast().getValue() > now[i].getValue()) {
                deque.removeLast();
            }
            deque.addLast(now[i]);
            if (deque.getFirst().getIndex() <= i - windowLen) {
                deque.removeFirst();
            }
            bw.write(deque.getFirst().getValue()+" ");
        }
        bw.flush();
        bw.close();
    }
}
