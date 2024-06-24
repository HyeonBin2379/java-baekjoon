package bakjoon.bakjoon08XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Exercise8669 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<Integer> treeType = new HashSet<>();
        int treeCount = Integer.parseInt(br.readLine());

        for (int i = 0; i < treeCount; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int thickness = Integer.parseInt(st.nextToken());
            int type = Integer.parseInt(st.nextToken());
            treeType.add(type);
        }
        System.out.println(treeType.size());
    }
}
