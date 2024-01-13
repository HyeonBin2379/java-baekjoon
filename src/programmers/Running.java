package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

class RunningSolution {
    private final Map<String, Integer> rank = new LinkedHashMap<>();

    public String[] solution(String[] players, String[] callings) {
        for (int i = 0; i < players.length; i++) {
            rank.put(players[i], i);
        }
        for (String player : callings) {
            int currentRank = rank.get(player);
            String frontPlayer = players[currentRank-1];

            changeRanking(frontPlayer, currentRank, players);
            changeRanking(player, currentRank-1, players);
        }

        List<String> result = new ArrayList<>(rank.keySet());
        result.sort((o1, o2) -> rank.get(o1) - rank.get(o2));
        return result.toArray(new String[0]);
    }

    public void changeRanking(String player, int ranking, String[] players) {
        rank.replace(player, ranking);
        players[ranking] = player;
    }
}
public class Running {
    public static void main(String[] args) {
        String[] players = {"mumu", "soe", "poe", "kai", "mine"};
        String[] callings = {"kai", "kai", "mine", "mine"};
        System.out.println(Arrays.toString(new RunningSolution().solution(players, callings)));
    }
}
