package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class NewsClusteringSolution {
    public int solution(String str1, String str2) {
        List<String> set1 = makeSet(str1);
        List<String> set2 = makeSet(str2);

        List<String> intersection = new ArrayList<>();
        List<String> union = new ArrayList<>();
        for (String element : set1) {
            if (set2.remove(element)) {
                intersection.add(element);
            }
            union.add(element);
        }
        union.addAll(set2);

        if (intersection.size() == 0 && union.size() == 0) {
            return 65536;
        }
        return (int) ((double) intersection.size() * 65536 / union.size());
    }

    public List<String> makeSet(String str) {
        List<String> set = new ArrayList<>();

        for (int i = 0; i < str.length()-1; i++) {
            String temp = str.substring(i, i+2);
            if (temp.matches("^[a-zA-Z]*$")) {
                set.add(temp.toUpperCase());
            }
        }
        Collections.sort(set);
        return set;
    }
}
public class NewsClustering {
    public static void main(String[] args) {
        String str1 = "12";
        String str2 = "12";
        System.out.println(new NewsClusteringSolution().solution(str1, str2));
    }
}
