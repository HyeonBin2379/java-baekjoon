package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

class BestAlbumSolution {
    private static class Album {
        int index;
        int plays;

        public Album (int index, int plays) {
            this.index = index;
            this.plays = plays;
        }
    }
    private final Map<String, List<Album>> albumsByGenre = new LinkedHashMap<>();
    private final Map<String, Integer> playsByGenre = new LinkedHashMap<>();

    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < genres.length; i++) {
            if (!albumsByGenre.containsKey(genres[i])) {
                albumsByGenre.put(genres[i], new ArrayList<>());
            }
            albumsByGenre.get(genres[i]).add(new Album(i, plays[i]));
            playsByGenre.put(genres[i], playsByGenre.getOrDefault(genres[i], 0) + plays[i]);
        }

        List<String> sorted = new ArrayList<>(playsByGenre.keySet());
        sorted.sort((o1, o2) -> playsByGenre.get(o2) - playsByGenre.get(o1));
        for (String genre : sorted) {
            albumsByGenre.get(genre).sort((o1, o2) -> {
                int comparison = o2.plays - o1.plays;
                return comparison == 0 ? o1.index - o2.index : comparison;
            });
            for (int i = 0; i < albumsByGenre.get(genre).size(); i++) {
                if (i == 2) {
                    break;
                }
                answer.add(albumsByGenre.get(genre).get(i).index);
            }
        }

        return answer.stream()
                .mapToInt(value -> value)
                .toArray();
    }
}

public class BestAlbum {
    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        System.out.println(Arrays.toString(new BestAlbumSolution().solution(genres, plays)));
    }
}
