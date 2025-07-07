package algorithm.map;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Exercise21939 {

    static class Node implements Comparable<Node> {
        int num;
        int level;

        public Node(int num, int level) {
            this.num = num;
            this.level = level;
        }

        @Override
        public int compareTo(Node o) {
            return this.level != o.level
                    ? Integer.compare(this.level, o.level)
                    : Integer.compare(this.num, o.num);
        }
    }

    private static final TreeSet<Node> tree = new TreeSet<>();
    private static final Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            tree.add(new Node(p, l));
            map.put(p, l);
        }

        int m = Integer.parseInt(br.readLine());
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            switch (cmd) {
                case "add" -> {
                    int problem = Integer.parseInt(st.nextToken());
                    int level = Integer.parseInt(st.nextToken());
                    tree.add(new Node(problem, level));
                    map.put(problem, level);
                }
                case "recommend" -> {
                    int option = Integer.parseInt(st.nextToken());
                    Node node = (option == 1) ? tree.last() : tree.first();
                    bw.write(node.num + "\n");
                }
                case "solved" -> {
                    int solved = Integer.parseInt(st.nextToken());
                    int l = map.get(solved);
                    tree.remove(new Node(solved, l));
                    map.remove(solved);
                }
            }
        }
        br.close();
        bw.close();
    }
}
