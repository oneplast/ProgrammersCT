class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String curPos = pos;
        curPos = skipPos(curPos, op_start, op_end);

        for (String command : commands) {
            switch (command) {
                case "prev":
                    curPos = actionPrev(curPos);
                    break;
                case "next":
                    curPos = actionNext(curPos, video_len);
                    break;
            }
            curPos = skipPos(curPos, op_start, op_end);
        }

        return curPos;
    }

    private String actionPrev(String pos) {
        int posMinute = getMinute(pos);
        int newPos = Math.max(posMinute - 10, 0);
        int hour = newPos / 60;
        int minute = newPos % 60;

        String strHour = String.format("%02d", hour);
        String strMinute = String.format("%02d", minute);
        return strHour + ":" + strMinute;
    }

    private String actionNext(String pos, String video_len) {
        int newPos = getMinute(pos) + 10;
        int videoMinute = getMinute(video_len);

        if (videoMinute - newPos < 10) {
            newPos = videoMinute;
        }

        int hour = newPos / 60;
        int minute = newPos % 60;

        String strHour = String.format("%02d", hour);
        String strMinute = String.format("%02d", minute);
        return strHour + ":" + strMinute;
    }

    private int getMinute(String pos) {
        String[] bits = pos.split(":");
        return Integer.parseInt(bits[0]) * 60 + Integer.parseInt(bits[1]);
    }

    private String skipPos(String pos, String op_start, String op_end) {
        String newPos = pos;
        int posMinute = getMinute(newPos);
        int startMinute = getMinute(op_start);
        int endMinute = getMinute(op_end);
        if (posMinute >= startMinute && posMinute <= endMinute) {
            newPos = op_end;
        }

        return newPos;
    }
}