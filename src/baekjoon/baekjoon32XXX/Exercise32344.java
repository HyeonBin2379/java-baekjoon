package baekjoon.baekjoon32XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Exercise32344 {

    private static class Piece {
        int v, h;

        public Piece(int v, int h) {
            this.v = v;
            this.h = h;
        }
    }

    private static final Map<Integer, List<Piece>> artifacts = new TreeMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            if (!artifacts.containsKey(a)) {
                artifacts.put(a, new ArrayList<>());
            }
            artifacts.get(a).add(new Piece(v, h));
        }

        Map<Integer, Long> size = new TreeMap<>();
        for (int num : artifacts.keySet()) {
            List<Piece> temp = artifacts.get(num);
            if (temp.size() == 1) {
                size.put(num, 1L);
                continue;
            }
            temp.sort(Comparator.comparingInt(o -> o.v));
            long vertLen = temp.get(temp.size()-1).v-temp.get(0).v+1;

            temp.sort(Comparator.comparingInt(o -> o.h));
            long horLen = temp.get(temp.size()-1).h-temp.get(0).h+1;
            size.put(num, vertLen*horLen);
        }
        Map.Entry<Integer, Long> answer = size.entrySet()
                .stream()
                .max(Comparator.comparingLong(Entry::getValue))
                .get();
        System.out.println(answer.getKey() + " " + answer.getValue());
    }
}
