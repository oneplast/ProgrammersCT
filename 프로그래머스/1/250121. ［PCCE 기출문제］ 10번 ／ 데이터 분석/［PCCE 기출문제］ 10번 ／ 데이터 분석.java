import java.util.*;
import java.util.stream.*;

class Solution {
public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        List<int[]> list = new ArrayList<>();

        for (int[] dt : data) {
            switch (ext) {
                case "code":
                    if (dt[0] < val_ext) {
                        list.add(dt);
                    }
                    break;
                case "date":
                    if (dt[1] < val_ext) {
                        list.add(dt);
                    }
                    break;
                case "maximum":
                    if (dt[2] < val_ext) {
                        list.add(dt);
                    }
                    break;
                default:
                    if (dt[3] < val_ext) {
                        list.add(dt);
                    }
                    break;
            }
        }

        List<int[]> sortedList = list.stream().sorted((a, b) -> {
            if (sort_by.equals("code")) {
                return a[0] - b[0];
            } else if (sort_by.equals("date")) {
                return a[1] - b[1];
            } else if (sort_by.equals("maximum")) {
                return a[2] - b[2];
            } else {
                return a[3] - b[3];
            }
        }).collect(Collectors.toList());

        int[][] result = new int[sortedList.size()][4];
        for (int i = 0; i < result.length; i++) {
            result[i] = sortedList.get(i);
        }

        return result;
    }
}