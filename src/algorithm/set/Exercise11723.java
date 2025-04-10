package algorithm.set;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Exercise11723 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        Set<Integer> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            int x;

            switch (cmd) {
                case "add" -> {
                    x = Integer.parseInt(st.nextToken());
                    set.add(x);
                }
                case "remove" -> {
                    x = Integer.parseInt(st.nextToken());
                    set.remove(x);
                }
                case "check" -> {
                    x = Integer.parseInt(st.nextToken());
                    sb.append(set.contains(x) ? 1 : 0).append("\n");
                }
                case "toggle" -> {
                    x = Integer.parseInt(st.nextToken());
                    if (set.contains(x)) {
                        set.remove(x);
                    } else {
                        set.add(x);
                    }
                }
                case "all" -> set = IntStream.rangeClosed(1, 20).boxed().collect(Collectors.toSet());
                case "empty" -> set.clear();
            }
        }
        br.close();
        bw.write(sb.toString());
        bw.close();
    }
}
