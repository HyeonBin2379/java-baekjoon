package baekjoon.baekjoon17XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Exercise17479 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Long> menu = new HashMap<>();
        Set<String> general = new HashSet<>();
        Set<String> service = new HashSet<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        for (int i = 0; i < a; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            long price = Long.parseLong(st.nextToken());
            general.add(name);
            menu.put(name, price);
        }
        for (int i = 0; i < b; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            long price = Long.parseLong(st.nextToken());
            menu.put(name, price);
        }
        for (int i = 0; i < c; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            service.add(name);
        }

        int n = Integer.parseInt(br.readLine());
        int serviceCnt = 0;
        long gPrice = 0, sPrice = 0;
        for (int i = 0; i < n; i++) {
            String menuName = br.readLine();
            if (service.contains(menuName)) {
                serviceCnt++;
                continue;
            }
            if (general.contains(menuName)) {
                gPrice += menu.get(menuName);
            } else {
                sPrice += menu.get(menuName);
            }
        }

        if ((gPrice < 20000 && sPrice > 0) || serviceCnt > 1 || (serviceCnt == 1 && gPrice+sPrice < 50000)) {
            System.out.println("No");
        } else {
            System.out.println("Okay");
        }
    }
}
