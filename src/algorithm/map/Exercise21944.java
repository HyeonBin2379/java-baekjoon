package algorithm.map;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeSet;
import java.util.stream.IntStream;

public class Exercise21944 {

    private static class Problem implements Comparable<Problem> {
        int level, num;

        public Problem(int num, int level) {
            this.level = level;
            this.num = num;
        }

        @Override
        public int compareTo(Problem o) {
            return this.level != o.level
                    ? Integer.compare(this.level, o.level)
                    : Integer.compare(this.num, o.num);
        }
    }

    private static final List<TreeSet<Problem>> subtrees = new ArrayList<>();
    private static final Map<Integer, Integer[]> map = new HashMap<>();
    private static final TreeSet<Problem> tree = new TreeSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        IntStream.rangeClosed(0, 100).forEach(i -> subtrees.add(new TreeSet<>()));

        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int level = Integer.parseInt(st.nextToken());
            int group = Integer.parseInt(st.nextToken());
            subtrees.get(group).add(new Problem(num, level));
            tree.add(new Problem(num, level));
            map.put(num, new Integer[]{level, group});
        }

        int m = Integer.parseInt(br.readLine());
        while (m-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            int x, p, l, g;
            switch (command) {
                case "recommend" -> {
                    g = Integer.parseInt(st.nextToken());
                    x = Integer.parseInt(st.nextToken());
                    switch (x) {
                        case 1 -> bw.write(subtrees.get(g).last().num + "\n");
                        case -1 -> bw.write(subtrees.get(g).first().num + "\n");
                    }
                }
                case "recommend2" -> {
                    x = Integer.parseInt(st.nextToken());
                    switch (x) {
                        case 1 -> bw.write(tree.last().num + "\n");
                        case -1 -> bw.write(tree.first().num + "\n");
                    }
                }
                case "recommend3" -> {
                    x = Integer.parseInt(st.nextToken());
                    l = Integer.parseInt(st.nextToken());
                    Problem result;
                    switch (x) {
                        case 1 -> {
                            result = tree.ceiling(new Problem(0, l));
                            bw.write((result == null ? -1 : result.num) + "\n");
                        }
                        case -1 -> {
                            result = tree.lower(new Problem(0, l));
                            bw.write((result == null ? -1 : result.num) + "\n");
                        }
                    }
                }
                case "add" -> {
                    p = Integer.parseInt(st.nextToken());
                    l = Integer.parseInt(st.nextToken());
                    g = Integer.parseInt(st.nextToken());
                    subtrees.get(g).add(new Problem(p, l));
                    tree.add(new Problem(p, l));
                    map.put(p, new Integer[]{l, g});
                }
                case "solved" -> {
                    p = Integer.parseInt(st.nextToken());
                    l = map.get(p)[0];
                    g = map.get(p)[1];
                    map.remove(p);
                    tree.remove(new Problem(p, l));
                    subtrees.get(g).remove(new Problem(p, l));
                }
            }
        }
        br.close();
        bw.close();
    }
}
