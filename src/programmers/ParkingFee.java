package programmers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

class ParkingFeeSolution {
    private final Map<String, Queue<Date>> parkingLog = new TreeMap<>();
    private final Map<String, Integer> result = new TreeMap<>();

    public int[] solution(int[] fees, String[] records) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        for (String record : records) {
            String[] tokens = record.split(" ");
            if (!parkingLog.containsKey(tokens[1])) {
                parkingLog.put(tokens[1], new LinkedList<>());
            }
            parkingLog.get(tokens[1]).offer(sdf.parse(tokens[0]));
        }
        for (Map.Entry<String, Queue<Date>> entry : parkingLog.entrySet()) {
            int size = entry.getValue().size();
            if (size % 2 == 1) {
                entry.getValue().add(sdf.parse("23:59"));
            }
            while (!entry.getValue().isEmpty()) {
                Date date1 = entry.getValue().poll();
                Date date2 = entry.getValue().poll();
                assert date2 != null;
                int diffMin = (int) (date2.getTime() - date1.getTime()) / 60000;
                result.put(entry.getKey(), result.getOrDefault(entry.getKey(), 0) + diffMin);
            }
        }
        return result.values().stream()
                .mapToInt(time -> calculateFee(fees, time))
                .toArray();
    }

    public int calculateFee(int[] fees, int time) {
        return Math.max(fees[1], fees[1] + (int) Math.ceil((double) (time - fees[0]) / fees[2]) * fees[3]);
    }
}
public class ParkingFee {
    public static void main(String[] args) throws ParseException {
        int[] fees = {180, 5000, 10, 600};
        String[] records = {
                "05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT",
                "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN",
                "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"
        };
        System.out.println(Arrays.toString(new ParkingFeeSolution().solution(fees, records)));
    }
}
