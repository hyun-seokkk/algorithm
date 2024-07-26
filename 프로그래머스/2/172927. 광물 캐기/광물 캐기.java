import java.util.*;

class Solution {
    
    static class Ore {
        private int diamond;
        private int iron;
        private int stone;
        
        public Ore(int diamond, int iron, int stone) {
            this.diamond = diamond;
            this.iron = iron;
            this.stone = stone;
        }
    }
    
    static int[][] scoreInfo;
    static List<Ore> list;
    
    public int solution(int[] picks, String[] ores) {
        int answer = 0;
        
        scoreInfo = new int[][]{{1, 1, 1}, {5, 1, 1}, {25, 5, 1}};
        
        int totalPicks = Arrays.stream(picks).sum();
        list = new ArrayList<>();
        for(int i = 0; i < ores.length; i+=5) {
            if(totalPicks == 0) break;
            
            int dia = 0, iron = 0, stone = 0;
            for(int j = i; j < i + 5; j++) {
                if(j == ores.length) break;
                
                String ore = ores[j];
                int val = ore.equals("iron") ? 1 : 
                    ore.equals("stone") ? 2 : 0;
                
                dia += scoreInfo[0][val];
                iron += scoreInfo[1][val];
                stone += scoreInfo[2][val];
            }
            
            list.add(new Ore(dia, iron, stone));
            totalPicks--;
        }
        
        Collections.sort(list, ((o1, o2) -> (o2.stone - o1.stone)));
        for(Ore ele : list) {
            int dia = ele.diamond;
            int iron = ele.iron;
            int stone = ele.stone;
            
            if(picks[0] > 0) {
                answer += dia;
                picks[0]--;
                continue;
            }
            if(picks[1] > 0) {
                answer += iron;
                picks[1]--;
                continue;
            }
            if(picks[2] > 0) {
                answer += stone;
                picks[2]--;
                continue;
            }
        }
        
        return answer;
    }
}