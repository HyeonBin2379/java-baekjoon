package bakjoon.bakjoon06XXX;

import java.io.*;
import java.util.*;

public class Exercise6830 {
    private static final Map<String, Integer> temperature = new LinkedHashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int temp;
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String city = st.nextToken();
            temp = Integer.parseInt(st.nextToken());
            temperature.put(city, temp);
            if (city.equals("Waterloo")) {
                break;
            }
        }
        List<String> city = new ArrayList<>(temperature.keySet());
        city.sort(Comparator.comparingInt(temperature::get));
        System.out.println(city.get(0));
    }
}
