package programmers;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

class ClothesSolution {
    private final Map<String, Set<String>> closet = new LinkedHashMap<>();

    public int solution(String[][] clothes) {
        int answer = 1;
        for (String[] clothe : clothes) {
            if (!closet.containsKey(clothe[1])) {
                closet.put(clothe[1], new HashSet<>());
            }
            closet.get(clothe[1]).add(clothe[0]);
        }

        for (Set<String> category : closet.values()) {
            answer *= (category.size()+1);
        }
        return answer - 1;
    }
}
public class Clothes {
    public static void main(String[] args) {
        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        System.out.println(new ClothesSolution().solution(clothes));
    }
}
