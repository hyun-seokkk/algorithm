import java.util.Arrays;

class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] baleum = {"aya", "ye", "woo", "ma"};
        for(int i=0; i<babbling.length; i++) {
            for(String ele : baleum) {
                babbling[i] = babbling[i].replaceAll(ele, " ");
            }
        }
        for(String ele : babbling) {
            String space = "";
            for(int i=0; i<5; i++) {
                space += " ";
                if(ele.equals(space)) {
                    answer++;
                    break;
                }
            }
        }
        return answer;
    }
}