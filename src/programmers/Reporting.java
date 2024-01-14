package programmers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

class ReportingSolution {
    private final Map<String, Set<String>> reporting = new LinkedHashMap<>();
    private final Map<String, Set<String>> reported = new LinkedHashMap<>();

    public int[] solution(String[] id_list, String[] report, int k) {
        for (String id : id_list) {
            reporting.put(id, new HashSet<>());
            reported.put(id, new HashSet<>());
        }
        for (String eachReport : report) {
            String[] token = eachReport.split(" ");
            reporting.get(token[0]).add(token[1]);
            reported.get(token[1]).add(token[0]);
        }

        List<String> malUser = reported.keySet().stream()
                .filter(id -> reported.get(id).size() >= k)
                .collect(Collectors.toList());

        int[] answer = new int[id_list.length];
        getResult(id_list, answer, malUser);
        return answer;
    }

    public void getResult(String[] id_list, int[] answer, List<String> malUser) {
        for (String id : malUser) {
            countResult(id_list, answer, id);
        }
    }

    public void countResult(String[] id_list, int[] answer, String id) {
        for (int i = 0; i < id_list.length; i++) {
            if (reporting.get(id_list[i]).contains(id)) {
                answer[i]++;
            }
        }
    }
}
public class Reporting {
    public static void main(String[] args) {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;
        System.out.println(Arrays.toString(new ReportingSolution().solution(id_list, report, k)));
    }
}
