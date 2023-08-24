import java.beans.Visibility;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Point{
        int x,y;
        // 카운트, 기회 정보 추가
        int cnt, chance;
        public Point(int x, int y, int cnt, int chance) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.chance = chance;
        }
		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + "]";
		}
        
    }
    
    static int K,W,H,map[][], ans;
    static boolean v[][][]; // 서로 다른 경로로 이동했을 때의 방문처리를 따로 관리
    
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[] hdx = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] hdy = {-2, -1, 1, 2, 2, 1, -1, -2}; // 말이동
    
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        //System.setIn(new FileInputStream("src/input.txt")); 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
    
        K = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new int[H][W];

        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        v = new boolean[H][W][K+1]; 

        ans = solution(0,0); // dfs, x/y/이동거리/남은 말이동기회
        
        System.out.println(ans);
        
    }

    
    
	private static int solution(int x, int y) {
		Queue<Point> q = new LinkedList<Point>();
		q.offer(new Point(x, y, 0, K));
		v[x][y][K] = true;
		
		while(!q.isEmpty()) {
			Point curr = q.poll();
			
			if(curr.x == H-1 && curr.y == W-1) { // 목적지 도달했으면 이동거리 리턴
				return curr.cnt;
			}
			
			for (int i = 0; i < 4; i++) { // 일반이동
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];
                
                if(nx>=0&&nx<H&&ny>=0&&ny<W&&map[nx][ny]!=1&&!v[nx][ny][curr.chance]) {
                	v[nx][ny][curr.chance] = true;
                	q.offer(new Point(nx, ny, curr.cnt+1, curr.chance));
                }
			}
			
			if(curr.chance > 0) { // 기회 있다면 말이동
	            for (int i = 0; i < 8; i++) {
	                int nx = curr.x + hdx[i];
	                int ny = curr.y + hdy[i];
	                
	                if(nx>=0&&nx<H&&ny>=0&&ny<W&&map[nx][ny]!=1&&!v[nx][ny][curr.chance-1]) { // 조건 체크한 뒤 말이동 이후 좌표, 경로에 맞게 방문처리 및 정보 큐에 삽입
	                    v[nx][ny][curr.chance-1] = true;
	                    q.offer(new Point(nx, ny, curr.cnt+1, curr.chance-1));
	                }
	            }
			}
		}
		return -1;
		
	}

}