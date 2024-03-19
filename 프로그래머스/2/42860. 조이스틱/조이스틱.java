class Solution {
    public int solution(String name) {
        int answer = 0;
        int half = ('Z' - 'A') / 2;
        int len = name.length();
        // System.out.println(half);
        
        int move = len-1;
        
        for(int i=0; i<len; i++) {
            int now = name.charAt(i);
            if(now - 'A' > half) {
                answer += 'Z' - now + 1;
            } else {
                answer += now - 'A';
            }
            
            int idx = i+1;
            while (idx < len && name.charAt(idx) == 'A') {
                idx++;
            }
            
            move = Math.min(move, Math.min((i * 2) + len - idx, (len - idx) * 2 + i));
            
        }
        answer += move;
        
       
        
        return answer;
    }
}