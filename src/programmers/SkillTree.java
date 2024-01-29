package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SkillTreeSolution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for (int i = 0; i < skill_trees.length; i++) {
            List<String> temp = new ArrayList<>();
            for (int j = 0; j < skill_trees[i].length(); j++) {
                String ch = String.valueOf(skill_trees[i].charAt(j));
                if (skill.contains(ch)) {
                    temp.add(ch);
                }
            }
            skill_trees[i] = String.join("", temp);

            Integer[] order = Arrays.stream(skill_trees[i].split("")).map(skill::indexOf).toArray(Integer[]::new);
            if (isValidSkillTree(order)) {
                answer++;
            }
        }
        return answer;
    }

    public boolean isValidSkillTree(Integer[] order) {
        return Arrays.stream(order).noneMatch(value -> value != List.of(order).indexOf(value));
    }
}
public class SkillTree {
    public static void main(String[] args) {
        String skill = "CBD";
        String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
        System.out.println(new SkillTreeSolution().solution(skill, skill_trees));
    }
}
