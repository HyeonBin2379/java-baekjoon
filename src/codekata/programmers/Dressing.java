package codekata.programmers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Dressing {

    private Map<String, HashSet<String>> map = new HashMap<>();

    public int solution(String[][] clothes) {
        int answer = 1;
        setMap(clothes);

        for (Set<String> c : map.values()) {
            // 특정 종류의 옷을 선택하지 않는 것도 종류별 선택지에 포함 -> 옷의 가짓수 + 1
            answer *= (c.size()+1);
        }
        // 가능한 모든 조합 중 어떤 종류의 옷도 선택하지 않는 경우만 제외
        return answer-1;
    }

    private void setMap(String[][] clothes) {
        for (String[] c : clothes) {
            if (!map.containsKey(c[1])) {
                map.put(c[1], new HashSet<>());
            }
            map.get(c[1]).add(c[0]);
        }
    }

    public static void main(String[] args) {
        String[][] clothes = {
                {"yellow_hat", "headgear"},
                {"blue_sunglasses", "eyewear"},
                {"green_turban", "headgear"}
        };
        int result = new Dressing().solution(clothes);
        System.out.println(result);
    }
}
