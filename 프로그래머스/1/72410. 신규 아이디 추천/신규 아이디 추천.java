import java.util.regex.*;

class Solution {
    public String solution(String new_id) {
        String regex = "[a-zA-Z0-9._-]";
        Pattern pattern = Pattern.compile(regex);
        char[] chars = new_id.toCharArray();

        // 1단계 : 소문자
        for (int i = 0; i < chars.length; i++) {
            if (Character.isAlphabetic(chars[i])) {
                chars[i] = Character.toLowerCase(chars[i]);
            }
        }

        // 2단계 : 정규식
        StringBuilder sb = new StringBuilder();
        for (char ch : chars) {
            if (pattern.matcher(String.valueOf(ch)).matches()) {
                sb.append(ch);
            }
        }

        // 3단계 : .로
        sb = new StringBuilder(sb.toString().replaceAll("\\.{2,}", "."));

        // 4단계 : . 제거
        while (sb.length() != 0 && sb.charAt(0) == '.') {
            sb.deleteCharAt(0);
        }

        while (sb.length() != 0 && sb.charAt(sb.length() - 1) == '.') {
            sb.deleteCharAt(sb.length() - 1);
        }

        // 5단계 : 공백 변환
        if (sb.length() == 0) {
            return "aaa";
        }

        // 6단계 : 15자
        if (sb.length() >= 16) {
            sb.delete(15, sb.length());
            while (sb.charAt(sb.length() - 1) == '.') {
                sb.deleteCharAt(sb.length() - 1);
            }
        }

        // 7단계 : 2자 이하
        if (sb.length() <= 2) {
            while (sb.length() < 3) {
                sb.append(sb.charAt(sb.length() - 1));
            }
        }

        return sb.toString();
    }
}