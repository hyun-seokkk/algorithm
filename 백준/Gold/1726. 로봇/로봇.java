import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {
	static class Point{
		int x,y,d,cnt; //방향, 이동카운트

		public Point(int x, int y, int d, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.d = d;
			this.cnt = cnt;
		}
		public Point(int x, int y, int d) {
			super();
			this.x = x;
			this.y = y;
			this.d = d;
		}
		
	}
	
	static ArrayList<Point> list;
	static Point goal;
	static int n,m, map[][],ans;
	static boolean v[][][];
	static int[] dx= {0,0,1,-1};
	static int[] dy= {1,-1,0,0}; // 순서대로 동서남북
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		list = new ArrayList<Point>();
		for (int i = 0; i < 2; i++) {
			st = new StringTokenizer(br.readLine());
			int x=Integer.parseInt(st.nextToken());
			int y=Integer.parseInt(st.nextToken());
			int d=Integer.parseInt(st.nextToken());
			
			if(i==0) {
				list.add(new Point(x-1, y-1, d-1, 0));
			} else {
				goal = new Point(x-1, y-1, d-1);
			}
			
		}
		v = new boolean[n][m][4];
		ans = Integer.MAX_VALUE;
		bfs();
		System.out.println(ans);
		
	}

	private static void bfs() {
		Point start = list.get(0);
		ArrayDeque<Point> q = new ArrayDeque<Point>();
		
		q.offer(start);
		
		while(!q.isEmpty()) {
			Point curr = q.poll();
			int nowD = curr.d;
			
			if(curr.x == goal.x && curr.y == goal.y && curr.d == goal.d) {
				ans = Math.min(ans, curr.cnt);
				continue;
			}

			for (int i = 1; i <= 3; i++) {
				int nx = curr.x + dx[curr.d] * i;
				int ny = curr.y + dy[curr.d] * i;
				if(nx>=0&&ny>=0&&nx<n&&ny<m&&!v[nx][ny][nowD]) {
					if(map[nx][ny]==1) {
						break;
					}
					q.add(new Point(nx, ny, curr.d, curr.cnt+1));
					v[nx][ny][nowD] = true;
				}
			}
			
			if(nowD == 0 || nowD == 1) {
				for (int i = 2; i <= 3; i++) {
					if(!v[curr.x][curr.y][i]) {
						q.add(new Point(curr.x, curr.y, i, curr.cnt+1));
						v[curr.x][curr.y][i] = true;					
					}
				}
				if(nowD == 0) {
					if(!v[curr.x][curr.y][1]){
						q.add(new Point(curr.x, curr.y, 1, curr.cnt+2));
						v[curr.x][curr.y][1] = true;						
					}
				} else {
					if(!v[curr.x][curr.y][0]){
						q.add(new Point(curr.x, curr.y, 0, curr.cnt+2));
						v[curr.x][curr.y][0] = true;
					}
				}
			} else {
				for (int i = 0; i <= 1; i++) {
					if(!v[curr.x][curr.y][i]) {
						q.add(new Point(curr.x, curr.y, i, curr.cnt+1));
						v[curr.x][curr.y][i] = true;					
					}
				}
				if(nowD == 2) {
					if(!v[curr.x][curr.y][3]){
						q.add(new Point(curr.x, curr.y, 3, curr.cnt+2));
						v[curr.x][curr.y][3] = true;						
					}
				} else {
					if(!v[curr.x][curr.y][2]){
						q.add(new Point(curr.x, curr.y, 2, curr.cnt+2));
						v[curr.x][curr.y][2] = true;
					}
				}
			}

		}
		
		
	}


	private static void print(int[][] map) {
		// TODO Auto-generated method stub
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		
	}

}