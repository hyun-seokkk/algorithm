import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N,M, ans=Integer.MAX_VALUE;
	static char map[][];
	static Minsik minsik;
	static boolean v[][][];
	
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {-1, 1, 0, 0};
	
	
	static class Minsik{
		int x,y,cnt,key;

		public Minsik(int x, int y, int cnt, int key) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.key = key;
		}

		@Override
		public String toString() {
			return "Minsik [x=" + x + ", y=" + y + "]";
		}
		
		
		
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				char temp =  str.charAt(j);
				map[i][j] = temp;
				if(temp=='0') {
					minsik = new Minsik(i, j, 0, 0);
				}
			}
		}
		
//		print(map);
		
		v = new boolean[N][M][64];
		map[minsik.x][minsik.y] = '.';
		v[minsik.x][minsik.y][0] = true;
		bfs();
		System.out.println(ans==Integer.MAX_VALUE ? -1 : ans);
		
	}

	private static void bfs() {
		ArrayDeque<Minsik> q = new ArrayDeque<Minsik>();
		q.offer(minsik);
		
		while(!q.isEmpty()) {
			Minsik curr = q.poll();
			if(map[curr.x][curr.y] == '1') ans = Math.min(ans, curr.cnt);
			
			for (int i = 0; i < 4; i++) {
				int nx = curr.x + dx[i];
				int ny = curr.y + dy[i];
				int cnt = curr.cnt;
				int key = curr.key;
				
				
				if(nx>=0&&ny>=0&&nx<N&&ny<M&&map[nx][ny]!='#'&&!v[nx][ny][key]) {
					char nxt = map[nx][ny];
					
					if(nxt >= 'a' && nxt <= 'f') {
						int nxtKey = 1 << (nxt-'a');
						nxtKey = key | nxtKey;
						v[nx][ny][nxtKey] = true;
						q.offer(new Minsik(nx, ny, cnt+1, nxtKey));
					} else if(nxt >= 'A' && nxt <= 'F') {
						if((key & 1 << (nxt- 'A')) == (int)Math.pow(2, nxt - 'A')){
							v[nx][ny][key] = true;
							q.offer(new Minsik(nx, ny, cnt+1, key));
						}
					} else {
						v[nx][ny][key] = true;
	                    q.offer(new Minsik(nx, ny, cnt + 1, key));
					}
					
				}
			}
			
			
		}
		
		
	}
	

}