class Solution {
    public String solution(String phone_number) {
        return new StringBuilder(phone_number.substring(0, phone_number.length() - 4)
                .replaceAll(".", "*"))
                .append(phone_number, phone_number.length() - 4, phone_number.length())
                .toString();
    }
}