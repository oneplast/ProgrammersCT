import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, List<String>> map = new TreeMap<>();

        for (String record : records) {
            String[] splitBits = record.split(" ");
            map.putIfAbsent(splitBits[1], new ArrayList<>());
            map.get(splitBits[1]).add(splitBits[0]);
        }

        int[] result = new int[map.size()];

        int idx = 0;
        for (List<String> in_out_times : map.values()) {
            List<String> inTimes = new ArrayList<>();
            List<String> outTimes = new ArrayList<>();

            for (int i = 0; i < in_out_times.size(); i++) {
                if (i % 2 == 0) {
                    inTimes.add(in_out_times.get(i));
                } else {
                    outTimes.add(in_out_times.get(i));
                }
            }

            if (inTimes.size() > outTimes.size()) {
                outTimes.add("23:59");
            }

            int diff = 0;
            for (int i = 0; i < inTimes.size(); i++) {
                diff += getDiff(inTimes.get(i), outTimes.get(i));
            }

            result[idx++] = diff > fees[0] ? calculate(diff, fees) : fees[1];
        }

        return result;
    }

    private int calculate(int time, int[] fees) {
        int rest = time - fees[0];
        int totalFee = fees[1];

        return totalFee + (int) Math.ceil((double) rest / fees[2]) * fees[3];
    }

    private int getDiff(String in, String out) {
        String[] splitBits = in.split(":");
        int intMinute = getMinute(splitBits[0], splitBits[1]);
        splitBits = out.split(":");
        int outMinute = getMinute(splitBits[0], splitBits[1]);

        return outMinute - intMinute;
    }

    private int getMinute(String in, String out) {
        return (Integer.parseInt(in) * 60) + (Integer.parseInt(out));
    }
}