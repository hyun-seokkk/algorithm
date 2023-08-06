import java.util.ArrayDeque;

class Solution {
    public int[] solution(int[] prices) {
        int len = prices.length;
        int[] answer = new int[len];
        int[] curPricesArr = new int[len];
        ArrayDeque<Integer> stack = new ArrayDeque<Integer>();
        
        for(int curSec=0; curSec<len; curSec++){
            int curPrice = prices[curSec];
            curPricesArr[curSec] = curPrice;
            
            while(!stack.isEmpty()){
                int lastIdx = stack.peekLast();
                int lastPrice = prices[lastIdx];
                if(curPrice < lastPrice) {
                    answer[lastIdx] = curSec - lastIdx;
                    stack.removeLast();
                } else {
                    break;
                }
            }
            stack.add(curSec);
            
        }
        for(int i=0; i<len; i++) {
            if(answer[i] == 0){
                answer[i] = len-1-i;
            }
        }
        

        return answer;
    }
}