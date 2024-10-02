package baekjoon.baekjoon21XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeSet;
import java.util.stream.IntStream;

public class Exercise21944 {

    private static class Problem implements Comparable<Problem> {
        int level, num, group;

        public Problem(int num, int level, int group) {
            this.level = level;
            this.num = num;
            this.group = group;
        }

        @Override
        public int compareTo(Problem o) {
            return this.level != o.level
                    ? Integer.compare(this.level, o.level)
                    : Integer.compare(this.num, o.num);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            Problem other = (Problem) obj;
            if (group != other.group) {
                return false;
            }
            if (level != other.level) {
                return false;
            }
            return num == other.num;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TreeSet<Problem> tree = new TreeSet<>();
        List<TreeSet<Problem>> subtrees = IntStream.rangeClosed(0, 100)
                .mapToObj(i -> new TreeSet<Problem>())
                .toList();
        Map<Integer, Integer[]> map = new HashMap<>();

        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int level = Integer.parseInt(st.nextToken());
            int group = Integer.parseInt(st.nextToken());
            subtrees.get(group).add(new Problem(num, level, group));
            tree.add(new Problem(num, level, group));
            map.put(num, new Integer[]{level, group});
        }

        int m = Integer.parseInt(br.readLine());
        while (m-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            int group, option, num, level;
            switch (command) {
                case "recommend" -> {
                    group = Integer.parseInt(st.nextToken());
                    option = Integer.parseInt(st.nextToken());
                    switch (option) {
                        case 1 -> System.out.println(subtrees.get(group).last().num);
                        case -1 -> System.out.println(subtrees.get(group).first().num);
                    }
                }
                case "recommend2" -> {
                    option = Integer.parseInt(st.nextToken());
                    switch (option) {
                        case 1 -> System.out.println(tree.last().num);
                        case -1 -> System.out.println(tree.first().num);
                    }
                }
                case "recommend3" -> {
                    option = Integer.parseInt(st.nextToken());
                    level = Integer.parseInt(st.nextToken());
                    Problem result;
                    switch (option) {
                        case 1 -> {
                            result = tree.ceiling(new Problem(0, level, 0));
                            System.out.println(result == null ? -1 : result.num);
                        }
                        case -1 -> {
                            result = tree.lower(new Problem(0, level, 0));
                            System.out.println(result == null ? -1 : result.num);
                        }
                    }
                }
                case "add" -> {
                    num = Integer.parseInt(st.nextToken());
                    level = Integer.parseInt(st.nextToken());
                    group = Integer.parseInt(st.nextToken());
                    subtrees.get(group).add(new Problem(num, level, group));
                    tree.add(new Problem(num, level, group));
                    map.put(num, new Integer[]{level, group});
                }
                case "solved" -> {
                    num = Integer.parseInt(st.nextToken());
                    level = map.get(num)[0];
                    group = map.get(num)[1];
                    map.remove(num);
                    tree.remove(new Problem(num, level, group));
                    subtrees.get(group).remove(new Problem(num, level, group));
                }
            }
        }
    }
}
