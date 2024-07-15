package bakjoon.bakjoon09XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Exercise9934 {

    private static int[] num;
    private static final List<List<Integer>> tree = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        num = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        IntStream.rangeClosed(0, k).forEach(i -> tree.add(new ArrayList<>()));
        getTree(0, num.length-1, 0);
        for (List<Integer> integers : tree) {
            System.out.println(integers.stream()
                    .map(num -> Integer.toString(num))
                    .collect(Collectors.joining(" ")));
        }
    }

    private static void getTree(int start, int end, int depth) {
        if (start == end) {
            tree.get(depth).add(num[start]);
            return;
        }
        int root = (start+end)/2;
        tree.get(depth).add(num[root]);
        getTree(start, root-1, depth+1);
        getTree(root+1, end, depth+1);
    }
}
