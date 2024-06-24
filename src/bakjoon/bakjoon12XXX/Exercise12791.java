package bakjoon.bakjoon12XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Exercise12791 {

    private static final Map<String, Integer> albums = new LinkedHashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        setAlbumList();
        for (int i = 0; i < testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int firstYear = Integer.parseInt(st.nextToken());
            int lastYear = Integer.parseInt(st.nextToken());

            List<Entry<String, Integer>> answer = albums.entrySet().stream()
                    .filter(entry -> entry.getValue() >= firstYear && entry.getValue() <= lastYear)
                    .toList();
            System.out.println(answer.size());
            answer.forEach(entry -> System.out.println(entry.getValue() + " " + entry.getKey()));
        }
    }

    private static void setAlbumList() {
        albums.put("DavidBowie", 1967);
        albums.put("SpaceOddity", 1969);
        albums.put("TheManWhoSoldTheWorld", 1970);
        albums.put("HunkyDory", 1971);
        albums.put("TheRiseAndFallOfZiggyStardustAndTheSpidersFromMars", 1972);
        albums.put("AladdinSane", 1973);
        albums.put("PinUps", 1973);
        albums.put("DiamondDogs", 1974);
        albums.put("YoungAmericans", 1975);
        albums.put("StationToStation", 1976);
        albums.put("Low", 1977);
        albums.put("Heroes", 1977);
        albums.put("Lodger", 1979);
        albums.put("ScaryMonstersAndSuperCreeps", 1980);
        albums.put("LetsDance", 1983);
        albums.put("Tonight", 1984);
        albums.put("NeverLetMeDown", 1987);
        albums.put("BlackTieWhiteNoise", 1993);
        albums.put("1.Outside", 1995);
        albums.put("Earthling", 1997);
        albums.put("Hours", 1999);
        albums.put("Heathen", 2002);
        albums.put("Reality", 2003);
        albums.put("TheNextDay", 2013);
        albums.put("BlackStar", 2016);
    }
}
