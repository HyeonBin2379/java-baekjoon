package baekjoon.baekjoon20XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Exercise20336 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<List<String>> menuList = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            menuList.add(new ArrayList<>());
            for (int j = 0; j < m; j++) {
                menuList.get(i).add(st.nextToken());
            }
        }

        System.out.println(menuList.get(0).size());
        for (String menuName : menuList.get(0)) {
            System.out.println(menuName);
        }
    }
}
