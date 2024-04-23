package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Exercise2890 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        char[][] rail = new char[r][c];
        Integer[] diff = new Integer[10];
        TreeSet<Integer> temp = new TreeSet<>();
        for (int i = 0; i < r; i++) {
            rail[i] = br.readLine().toCharArray();
            for (int j = c-2; j >= 1; j--) {
                if (rail[i][j] != '.') {
                    int index = rail[i][j]-'0';
                    diff[index] = c-1-j;
                    temp.add(diff[index]);
                    break;
                }
            }
        }

        List<Integer> rank = new ArrayList<>(temp);
        for (int i = 1; i < 10; i++) {
            System.out.println(rank.indexOf(diff[i]) + 1);
        }
    }
}
