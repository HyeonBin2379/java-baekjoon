package bakjoon.bakjoon22XXX;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Exercise22233 {

    private static final Set<String> keyword = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            keyword.add(word);
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < m; i++) {
            Set<String> post = Arrays.stream(br.readLine().split(","))
                    .filter(keyword::contains)
                    .collect(Collectors.toSet());
            keyword.removeAll(post);
            bw.write(keyword.size() + "\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
