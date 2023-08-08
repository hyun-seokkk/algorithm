import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int T, N, ans, taste[][];
    static boolean v[][];
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            
            N = Integer.parseInt(st.nextToken());
            taste = new int[N][N];
            
            int maxDay = 0;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    int temp = Integer.parseInt(st.nextToken());
                    taste[i][j] = temp;
                    maxDay = Math.max(temp, maxDay);
                }
            }
            
            ans = 0;
            
            for (int day = 0; day <= maxDay; day++) {
                v = new boolean[N][N];
                int cnt = 0;
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        if(taste[i][j] == day) taste[i][j] = -1;
                    }
                }
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        if(dfs(i, j)) cnt++;
                    }
                }
                ans = Math.max(ans, cnt);
            }
            System.out.printf("#%d %d\n", tc, ans);
            
        }
        
    }
    private static boolean dfs(int x, int y) {
        if(taste[x][y] == -1 || v[x][y]) return false;
        v[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(nx>=0&&nx<N&&ny>=0&&ny<N&&taste[nx][ny]!=-1&&!v[nx][ny]) {
                dfs(nx, ny);
            }
        }
        return true;
    }
    private static void print(int[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
        
    }
}