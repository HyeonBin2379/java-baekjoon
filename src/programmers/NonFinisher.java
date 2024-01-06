package programmers;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

class NonFinisherSolution {
    private final Map<String, Integer> raceParticipants = new LinkedHashMap<>();
    private final Map<String, Integer> raceResult = new LinkedHashMap<>();
    public String solution(String[] participant, String[] completion) {
        StringBuilder answer = new StringBuilder();
        for (String name : participant) {
            raceParticipants.put(name, raceParticipants.getOrDefault(name, 0)+1);
        }
        for (String name : completion) {
            raceResult.put(name, raceResult.getOrDefault(name, 0)+1);
        }
        for (String name : raceParticipants.keySet()) {
            if (!raceResult.containsKey(name) || (!Objects.equals(raceResult.get(name), raceParticipants.get(name)))) {
                answer.append(name);
            }
        }

        return answer.toString();
    }
}
public class NonFinisher {
    public static void main(String[] args) {
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};
        NonFinisherSolution result = new NonFinisherSolution();
        System.out.println(result.solution(participant, completion));
    }
}
