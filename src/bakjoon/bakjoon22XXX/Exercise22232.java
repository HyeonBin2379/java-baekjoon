package bakjoon.bakjoon22XXX;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Exercise22232 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<String> filename = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String name = br.readLine();
            filename.add(name);
        }
        Set<String> extensions = new HashSet<>();
        for (int i = 0; i < m; i++) {
            String ext = br.readLine();
            extensions.add(ext);
        }
        br.close();

        filename.sort((o1, o2) -> {
            String[] file1 = o1.split("\\.");
            String[] file2 = o2.split("\\.");

            int comparison = file1[0].compareTo(file2[0]);
            if (comparison != 0) {
                return comparison;
            }
            boolean contained1 = extensions.contains(file1[1]);
            boolean contained2 = extensions.contains(file2[1]);
            if (contained1 && !contained2) {
                return -1;
            } else if (!contained1 && contained2) {
                return 1;
            }
            return file1[1].compareTo(file2[1]);
        });
        filename.forEach(s -> sb.append(s).append("\n"));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
