package baekjoon.baekjoon21XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Exercise21939 {

    static class Problem implements Comparable<Problem> {
        int level, num;

        public Problem(int num, int level) {
            this.level = level;
            this.num = num;
        }

        @Override
        public int compareTo(Problem o) {
            return this.level != o.level
                    ? Integer.compare(o.level, this.level)
                    : Integer.compare(o.num, this.num);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TreeSet<Problem> tree = new TreeSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        int n = Integer.parseInt(br.readLine());

        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int level = Integer.parseInt(st.nextToken());
            tree.add(new Problem(num, level));
            map.put(num, level);
        }

        int m = Integer.parseInt(br.readLine());
        while (m-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            int num, level;
            switch (command) {
                case "add" -> {
                    num = Integer.parseInt(st.nextToken());
                    level = Integer.parseInt(st.nextToken());
                    tree.add(new Problem(num, level));
                    map.put(num, level);
                }
                case "recommend" -> {
                    int option = Integer.parseInt(st.nextToken());
                    switch (option) {
                        case 1 -> System.out.println(tree.first().num);
                        case -1 -> System.out.println(tree.last().num);
                    }
                }
                case "solved" -> {
                    num = Integer.parseInt(st.nextToken());
                    level = map.get(num);
                    tree.remove(new Problem(num, level));
                    map.remove(num);
                }
            }
        }
    }
}
