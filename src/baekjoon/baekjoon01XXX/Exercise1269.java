package baekjoon.baekjoon01XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Exercise1269 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sizeA = Integer.parseInt(st.nextToken());
        int sizeB = Integer.parseInt(st.nextToken());

        Set<Integer> setA = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < sizeA; i++) {
            setA.add(Integer.parseInt(st.nextToken()));
        }

        Set<Integer> setB = new HashSet<>();
        Set<Integer> interSection = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < sizeB; i++) {
            int value = Integer.parseInt(st.nextToken());
            setB.add(value);
            if (setA.contains(value)) {
                interSection.add(value);
            }
        }

        Set<Integer> result = new HashSet<>(setA);
        result.addAll(setB);
        result.removeIf(interSection::contains);
        System.out.println(result.size());
        br.close();
    }
}
