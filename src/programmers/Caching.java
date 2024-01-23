package programmers;

import java.util.LinkedList;
import java.util.List;

class CachingSolution {
    private final List<String> cache = new LinkedList<>();

    public int solution(int cacheSize, String[] cities) {
        int answer = 0;

        if (cacheSize == 0) {
            return cities.length * 5;
        }

        for (String s : cities) {
            String city = s.toUpperCase();
            if (cache.contains(city)) {
                cache.remove(city);
                cache.add(city);
                answer += 1;
                continue;
            }

            if (cache.size() == cacheSize) {
                cache.remove(0);
            }
            cache.add(city);
            answer += 5;
        }
        return answer;
    }
}
public class Caching {
    public static void main(String[] args) {
        int cacheSize = 3;
        String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
        System.out.println(new CachingSolution().solution(cacheSize, cities));
    }
}
