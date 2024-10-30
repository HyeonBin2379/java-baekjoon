package baekjoon.baekjoon08XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class Exercise8975 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Set<String> songTitle = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            songTitle.add(br.readLine());
        }

        int m = Integer.parseInt(br.readLine());
        Set<String> words = new TreeSet<>();
        for (int i = 1; i <= m; i++) {
            String lyric = br.readLine();
            if (songTitle.contains(lyric)) {
                words.add(lyric);
            }
            if (words.size() >= (int)Math.ceil(n/2.0)) {
                System.out.println(i);
                break;
            }
        }
    }
}
