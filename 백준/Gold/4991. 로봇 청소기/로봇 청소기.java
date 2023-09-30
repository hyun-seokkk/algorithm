import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {
	
	static class Point{
		int x,y,cnt;
		public Point(int x, int y, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + ", cnt=" + cnt + "]";
		}
		
	}
	static Point start;
	static Point[] pArr;
	static int w,h,dirtyCnt,ans, key, dist[][];
	static char map[][];
	static boolean v[][];
	
	
	//순열
	static int[] origin, sel;
	static boolean[] permV;
	
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			if(w == 0 && h == 0) {
				break;
			}
			map = new char[h][w];
			dirtyCnt = 0;
			for (int i = 0; i < h; i++) {
				String str = br.readLine();
				for (int j = 0; j < w; j++) {
					char temp = str.charAt(j);
					if(temp == '*') {
						map[i][j] = (char) (dirtyCnt+'0');
						dirtyCnt++;
					} else if (temp == 'o') {
						start = new Point(i, j, 0);
						map[i][j] = '.';
					} else {
						map[i][j] = temp;
					}
				}
			}

			
			pArr = new Point[dirtyCnt];
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if(map[i][j] >= '0' && map[i][j] <= '9') {
						pArr[map[i][j] - '0'] = new Point(i, j, 0);
					}
				}
			}
			
			dist = new int[dirtyCnt+1][dirtyCnt+1]; // 청소기 - 먼지 / 먼지 - 먼지 사이 거리 저장
			for(int arr[] : dist) {
				Arrays.fill(arr, -1);
			}
			v = new boolean[h][w];
			bfs();

			for (int i = 0; i < pArr.length; i++) {
				v = new boolean[h][w];;
				getDist(pArr[i], i+1);
			}

			int distCheck = 0;
			for (int i = 0; i < dist.length; i++) {
				for (int j = 0; j < dist[i].length; j++) {
					if(dist[i][j] == -1) distCheck++;
				}
			}
			if(distCheck > dirtyCnt+1) {
				System.out.println(-1);
				continue;
			}
			
			permV = new boolean[dirtyCnt];
			sel = new int[dirtyCnt];
			ans = Integer.MAX_VALUE;
			permutation(0);
			

//			print(map);
			key = (1<<dirtyCnt) -1;
			

			System.out.println(ans);
		}
		
	}

	private static void permutation(int k) {
		if(sel.length == k) {
			
			int nowDist = 0;
			nowDist = dist[0][sel[0]];
			for (int i = 0; i < sel.length - 1; i++) {
				nowDist += dist[sel[i]][sel[i+1]];
			}
			ans = Math.min(ans, nowDist);
			
			return;
		}
		
		for(int i=0; i<dirtyCnt; i++) {
			if(!permV[i]) {
				permV[i] = true;
				sel[k] = i+1;
				permutation(k+1);
				permV[i] = false;
			}
		}
	}

	private static void getDist(Point p, int idx) {
		ArrayDeque<Point> q = new ArrayDeque<Point>();
		q.offer(p);
		v[p.x][p.y] = true;
		while(!q.isEmpty()) {
			Point curr = q.poll();
			int x = curr.x;
			int y = curr.y;
			int cnt = curr.cnt;
			
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx<0||ny<0||nx>=h||ny>=w) continue;
				if(map[nx][ny] == 'x' || v[nx][ny]) continue;
				
				q.offer(new Point(nx, ny, cnt+1));
				v[nx][ny] = true;
				if(map[nx][ny] >= '0' && map[nx][ny] <= '9') {
					dist[idx][(int)(map[nx][ny]-'0')+1] = cnt+1;
					dist[(map[nx][ny]-'0')+1][idx] = cnt+1;
				}
				
			}
			
		}
	}

	private static void bfs() {
		ArrayDeque<Point> q = new ArrayDeque<Point>();
		q.offer(start);
		v[start.x][start.y] = true;
		while(!q.isEmpty()) {
			Point curr = q.poll();
			int x = curr.x;
			int y = curr.y;
			int cnt = curr.cnt;
			
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx<0||ny<0||nx>=h||ny>=w) continue;
				if(map[nx][ny] == 'x' || v[nx][ny]) continue;
				
				q.offer(new Point(nx, ny, cnt+1));
				v[nx][ny] = true;
				if(map[nx][ny] >= '0' && map[nx][ny] <= '9') {
					dist[0][(int)(map[nx][ny]-'0')+1] = cnt+1;
					dist[(map[nx][ny]-'0')+1][0] = cnt+1;
				}
				
			}
			
		}
	}

	private static void print(char[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
	private static void print(int[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}