package baekjoon.baekjoon02XXX;

import java.io.*;
import java.util.*;

public class Exercise2371 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<Integer> fileSize = new HashSet<>();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            // 맨 마지막 토큰의 -1은 제외
            fileSize.add(st.countTokens()-1);
        }
        System.out.println(fileSize.stream().reduce(0, Integer::max));
    }
}
