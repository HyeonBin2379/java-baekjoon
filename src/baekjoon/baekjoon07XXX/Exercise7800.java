package baekjoon.baekjoon07XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Exercise7800 {

    private static class Point implements Comparable<Point> {
        int cnt, row, col;
        List<Integer> numbers;

        public Point(List<Integer> numbers, int row, int col) {
            this.cnt = numbers.size();
            this.numbers = numbers;
            this.row = row;
            this.col = col;
        }

        @Override
        public int compareTo(Point o) {
            if (this.numbers.size() != o.numbers.size()) {
                return Integer.compare(this.cnt, o.cnt);
            } else if (!this.numbers.equals(o.numbers)) {
                return findFirstNum(this, o);
            } else if (this.row != o.row) {
                return Integer.compare(this.row, o.row);
            } else {
                return Integer.compare(this.col, o.col);
            }
        }
        private int findFirstNum(Point o1, Point o2) {
            for (int i = 0; i < Math.min(o1.cnt, o2.cnt); i++) {
                if ((int) o1.numbers.get(i) != o2.numbers.get(i)) {
                    return o2.numbers.get(i) - o1.numbers.get(i);
                }
            }
            return 0;
        }
    }
    private static int[][] num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while ((input = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(input);
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            num = new int[n][n];
            for (int i = 0; i < n; i++) {
                num[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }

            PriorityQueue<Point> result = new PriorityQueue<>();
            for (int i = 0; i <= n-m; i++) {
                for (int j = 0; j <= n-m; j++) {
                    result.add(count(i, j, m));
                }
            }
            if (!result.isEmpty()) {
                Point answer = result.peek();
                System.out.println(answer.row + " " + answer.col);
            }
        }
    }

    private static Point count(int row, int col, int size) {
        List<Integer> numSet = new ArrayList<>();
        for (int i = row; i < row+size; i++) {
            for (int j = col; j < col+size; j++) {
                numSet.add(num[i][j]);
            }
        }
        numSet = numSet.stream().distinct().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        return new Point(numSet, row+1, col+1);
    }
}
