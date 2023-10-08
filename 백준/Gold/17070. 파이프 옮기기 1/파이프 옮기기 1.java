import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, ans;

    static int[][] map;
    static int[] nx = {-1, 1, 0, 0};
    static int[] ny = {0, 0, -1 ,1};

    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for(int i = 0; i < n; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 1, 0);
        System.out.println(ans);
    }
    
    public static void dfs(int x, int y, int d) {
        if(x == n-1 && y == n-1) {
            ans += 1;
            return;
        }

        if(d == 0) {  // 가로, 대각 이동 가능
            if(y+1 < n && map[x][y+1] == 0) {
                dfs(x, y+1, 0);
            }
            if(x+1 < n && y+1 < n && map[x+1][y] == 0 && map[x][y+1] == 0 && map[x+1][y+1] == 0) {
                dfs(x+1, y+1, 2);
            }
        }else if(d == 1) {  // 세로, 대각 이동 가능
            if(x+1 < n && map[x+1][y] == 0) {
                dfs(x+1, y, 1);
            }
            if(x+1 < n && y+1 < n && map[x+1][y] == 0 && map[x][y+1] == 0 && map[x+1][y+1] == 0) {
                dfs(x+1, y+1, 2);
            }
        }else {  // 가로, 세로, 대각 이동 가능
            if(y+1 < n && map[x][y+1] == 0) {
                dfs(x, y+1, 0);
            }
            if(x+1 < n && map[x+1][y] == 0) {
                dfs(x+1, y, 1);
            }
            if(x+1 < n && y+1 < n && map[x+1][y] == 0 && map[x][y+1] == 0 && map[x+1][y+1] == 0) {
                dfs(x+1, y+1, 2);
            }
        }
    }
}