import java.util.*;

class Solution {
    List<Integer> result;

    public int[] solution(String today, String[] terms, String[] privacies) {
        result = new ArrayList<>();
        Map<String, Integer> termMap = new HashMap<>();

        for (String term : terms) {
            String[] bits = term.split(" ");
            termMap.put(bits[0], Integer.parseInt(bits[1]));
        }

        convertDate(today, termMap, privacies);

        return result.stream().mapToInt(x -> x).toArray();
    }

    private void convertDate(String today, Map<String, Integer> termMap, String[] privacies) {
        int todayInt = Integer.parseInt(today.replaceAll("\\.", ""));

        int idx = 0;
        for (String privacy : privacies) {
            String[] privacyBits = privacy.split(" ");
            String[] privDateBits = privacyBits[0].split("\\.");
            int termMonth = termMap.get(privacyBits[1]);

            int prevYear = Integer.parseInt(privDateBits[0]);
            int prevMonth = Integer.parseInt(privDateBits[1]);
            int prevDate = Integer.parseInt(privDateBits[2]);

            if (prevDate == 1) {
                prevDate = 28;
                prevMonth -= 1;
            } else {
                prevDate -= 1;
            }

            prevMonth += termMonth;

            prevYear += prevMonth / 12;
            prevMonth = prevMonth % 12;

            if (prevMonth % 12 == 0) {
                prevYear -= 1;
                prevMonth = 12;
            }

            int lastPermitDate = calculateDate(prevYear, prevMonth, prevDate);
            if (lastPermitDate < todayInt) {
                result.add(idx + 1);
            }

            idx++;
        }
    }

    private int calculateDate(int year, int month, int day) {
        return year * 10000 + month * 100 + day;
    }
}