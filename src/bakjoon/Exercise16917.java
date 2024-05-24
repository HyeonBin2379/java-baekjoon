package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise16917 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int case1 = a*x + b*y;
        int case2 = (x > y) ? 2*y*c + (x-y)*a : 2*x*c + (y-x)*b;
        int case3 = (x > y) ? 2*x*c : 2*y*c;
        System.out.println(Math.min(Math.min(case1, case2), case3));
    }
}
