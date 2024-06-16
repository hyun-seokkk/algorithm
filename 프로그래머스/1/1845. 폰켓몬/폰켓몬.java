import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        HashMap<Integer, Integer> map = new HashMap();
        for(int ele : nums) {
            if(!map.containsKey(ele)) {
                map.put(ele, 1);
            } else {
                int temp = map.get(ele);
                map.put(ele, ++temp);
            }
        }
        int half = nums.length / 2;
        return (map.size() >= half) ? half : map.size();
    }
}