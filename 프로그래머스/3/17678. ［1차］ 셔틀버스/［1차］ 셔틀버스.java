import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        int[] crewArr = Arrays.stream(timetable)
                .mapToInt(this::getTotalMinutes)
                .sorted()
                .toArray();

        int busTime = getTotalMinutes("09:00");
        int crewIdx = 0;

        for (int i = 0; i < n; i++) {
            int capacity = 0;

            while (crewIdx < crewArr.length && crewArr[crewIdx] <= busTime && capacity < m) {
                ++crewIdx;
                ++capacity;
            }

            if (i == n - 1) {
                if (capacity < m) {
                    return getCalTime(busTime);
                } else {
                    return getCalTime(crewArr[crewIdx - 1] - 1);
                }
            }

            busTime += t;
        }

        return "";
    }

    private int getTotalMinutes(String time) {
        String[] splitTimes = time.split(":");
        return Integer.parseInt(splitTimes[0]) * 60 + Integer.parseInt(splitTimes[1]);
    }

    private String getCalTime(int totalMinutes) {
        int hour = totalMinutes / 60;
        int minute = totalMinutes % 60;
        return String.format("%02d:%02d", hour, minute);
    }
}