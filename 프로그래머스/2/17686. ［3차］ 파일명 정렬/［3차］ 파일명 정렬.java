import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        String[] result = new String[files.length];
        PriorityQueue<Data> pq = new PriorityQueue<>();
        for (int i = 0; i < files.length; i++) {
            String file = files[i];
            boolean findNumPrefix = false;
            char[] chars = file.toCharArray();

            int startIdx = 0;
            int endIdx = -1;

            for (int j = 0; j < chars.length; j++) {
                if (Character.isDigit(chars[j])) {
                    if (!findNumPrefix) {
                        startIdx = j;
                        findNumPrefix = true;
                    }
                } else if (findNumPrefix) {
                    endIdx = j;
                    break;
                }
            }

            if (endIdx == -1) {
                endIdx = chars.length;
            }

            String head = file.substring(0, startIdx);
            String number = file.substring(startIdx, endIdx);
            String tail = file.substring(endIdx);

            pq.offer(new Data(head, number, tail, i));
        }

        int idx = 0;
        while (!pq.isEmpty()) {
            Data data = pq.poll();
            result[idx++] = data.head + data.number + data.tail;
        }

        return result;
    }
}

class Data implements Comparable<Data> {
    String head;
    String number;
    String tail;
    int orgIdx;

    public Data(String head, String number, String tail, int orgIdx) {
        this.head = head;
        this.number = number;
        this.tail = tail;
        this.orgIdx = orgIdx;
    }


    @Override
    public int compareTo(Data o) {
        int headComp = this.head.compareToIgnoreCase(o.head);
        if (headComp != 0) {
            return headComp;
        }

        int numberComp = Integer.parseInt(this.number) - Integer.parseInt(o.number);
        if (numberComp != 0) {
            return numberComp;
        }

        return Integer.compare(this.orgIdx, o.orgIdx);
    }
}