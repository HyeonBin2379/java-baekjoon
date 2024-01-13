package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class DataAnalysisSolution {
    private final List<String> standard = new ArrayList<>(List.of("code", "date", "maximum", "remain"));

    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        List<int[]> selected = Arrays.stream(data)
                .filter(ints -> ints[standard.indexOf(ext)] < val_ext)
                .sorted((o1, o2) -> o1[standard.indexOf(sort_by)] - o2[standard.indexOf(sort_by)])
                .collect(Collectors.toList());

        return selected.toArray(int[][]::new);
    }
}
public class DataAnalysis {
    public static void main(String[] args) {
        int[][] data = {{1, 20300104, 100, 80}, {2, 20300804, 847, 37}, {3, 20300401, 10, 8}};
        String ext = "date";
        int val_ext = 20300501;
        String sort_by = "remain";
        System.out.println(Arrays.deepToString(new DataAnalysisSolution().solution(data, ext, val_ext, sort_by)));
    }
}
