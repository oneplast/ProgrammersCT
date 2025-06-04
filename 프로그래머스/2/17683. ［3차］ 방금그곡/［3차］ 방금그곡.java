import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        PriorityQueue<Music> pq = new PriorityQueue<>();
        int idx = 0;
        for (String musicInfo : musicinfos) {
            String[] bits = musicInfo.split(",");
            String[] startTime = bits[0].split(":");
            String[] endTime = bits[1].split(":");
            String title = bits[2];
            String sounds = bits[3];
            int totalMinute = getMinute(startTime, endTime);

            StringBuilder sb = new StringBuilder();
            int curMinute = totalMinute;

            int curIdx = 0;
            while (curMinute > 0) {
                char ch = sounds.charAt(curIdx++ % sounds.length());
                sb.append(ch);
                if (ch == '#') {
                    continue;
                }

                curMinute--;
            }

            char lastIdx = sounds.charAt(curIdx % sounds.length());
            if (lastIdx == '#') {
                sb.append(lastIdx);
            }

            pq.offer(new Music(idx, totalMinute, title, sb.toString()));
            idx++;
        }

        while (!pq.isEmpty()) {
            Music music = pq.poll();
            String title = music.title;
            String sound = music.sound;

            boolean isNotShop = false;
            if (m.charAt(m.length() - 1) != '#') {
                isNotShop = true;
            }

            if (sound.contains(m)) {
                if (!isNotShop) {
                    return title;
                }

                sound = sound.replaceAll(m + "#", " ");
                if (sound.contains(m)) {
                    return title;
                }
            }
        }

        return "(None)";
    }

    static class Music implements Comparable<Music> {
        int idx;
        int totalMinute;
        String title;
        String sound;

        public Music(int idx, int totalMinute, String title, String sound) {
            this.idx = idx;
            this.totalMinute = totalMinute;
            this.title = title;
            this.sound = sound;
        }

        @Override
        public int compareTo(Music o) {
            if (this.totalMinute == o.totalMinute) {
                return this.idx - o.idx;
            }

            return o.totalMinute - this.totalMinute;
        }
    }

    private int getMinute(String[] startTime, String[] endTime) {
        int startHour = Integer.parseInt(startTime[0]);
        int startMinute = Integer.parseInt(startTime[1]);
        int endHour = Integer.parseInt(endTime[0]);
        int endMinute = Integer.parseInt(endTime[1]);

        return (endHour * 60 + endMinute) - (startHour * 60 + startMinute);
    }
}