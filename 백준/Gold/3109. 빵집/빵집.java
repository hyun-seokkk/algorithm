import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int R,C, ans;
	static char[][] map;
	static int[] dx = {-1, 0, 1};
	static int[] dy = {1, 1, 1};
	static boolean finish;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		for (int i = 0; i < R; i++) {
			finish = false;
			dfs(i, 0);
		}
		System.out.println(ans);
		
	}
	
	private static void dfs(int x, int y) {
		map[x][y] = 'x';
		if(y==C-1) {
			ans++;
			finish=true;
		}
		for (int i = 0; i < 3; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(nx>=0&&nx<R&&ny>=0&&ny<C&&map[nx][ny]!='x'&&!finish) {

				dfs(nx, ny);
			}
		}
	}

	private static void print(char[][] map) {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}

}
