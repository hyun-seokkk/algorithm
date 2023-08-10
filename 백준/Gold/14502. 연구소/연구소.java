import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	static class Point{
		int x;
		int y;
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	private static int N,M, map[][], ans;
	private static Stack<Point> s, virus;
	static int[] dx= {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		s = new Stack<Point>();
		virus = new Stack<Point>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int temp =Integer.parseInt(st.nextToken());
				map[i][j] = temp;
				if(temp == 0) s.push(new Point(i, j));
				if(temp == 2) virus.push(new Point(i, j));
			}
		}
		ans = 0;
		for (int i = 0; i < s.size(); i++) {
			for (int j = i+1; j < s.size(); j++) {
				for (int k = j+1; k < s.size(); k++) {
					map[s.get(i).x][s.get(i).y] = 1;
					map[s.get(j).x][s.get(j).y] = 1;
					map[s.get(k).x][s.get(k).y] = 1;
					
					bfs();
					
					map[s.get(i).x][s.get(i).y] = 0;
					map[s.get(j).x][s.get(j).y] = 0;
					map[s.get(k).x][s.get(k).y] = 0;
				}
			}
		}
		
		System.out.println(ans);
	}

	private static void bfs() {
		int[][] tmp = new int[N][M];
		for (int i = 0; i < map.length; i++) {
			System.arraycopy(map[i], 0, tmp[i], 0, map[i].length);
		}
		ArrayDeque<Point> q = new ArrayDeque<Point>();
		for (int i = 0; i < virus.size(); i++) {
			q.offer(virus.get(i));
		}
		
		while(!q.isEmpty()) {
			Point loc = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = loc.x + dx[i];
				int ny = loc.y + dy[i];
				if(nx>=0&&nx<N&&ny>=0&&ny<M&&tmp[nx][ny]==0) {
					tmp[nx][ny] = 2;
					q.offer(new Point(nx, ny));
				}
			}
		}
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(tmp[i][j] == 0) cnt++;
			}
		}
		ans = Math.max(ans, cnt);
		
	}
	
	private static void print(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

}
