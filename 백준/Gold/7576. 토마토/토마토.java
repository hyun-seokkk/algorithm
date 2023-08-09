import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	static class Point{
		int x;
		int y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + "]";
		}
		
	}
	
	static int M,N, box[][];
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	static Stack<Point> starts = new Stack<Point>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		box = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int temp = Integer.parseInt(st.nextToken());
				box[i][j] = temp;
				if(temp == 1) {
					starts.push(new Point(i, j));
				}
			}
		}
		//System.out.println("starts "+starts.toString());
		//print(box);
		//System.out.println();
		ArrayList<ArrayDeque<Point>> list = new ArrayList<ArrayDeque<Point>>();
		//System.out.println(starts.size());
		int startSize = starts.size();
		for (int i = 0; i < startSize; i++) {
			ArrayDeque<Point> tempQ = new ArrayDeque<>();
			tempQ.offer(starts.pop());
			//System.out.println("tempQ "+ tempQ);
			list.add(tempQ);
		}
		//System.out.println("list "+ list.toString()+" "+list.size());
		while(!list.isEmpty()) {
			int liSize = list.size();
			for (int i = 0; i < list.size(); i++) {
				ArrayDeque<Point> nowQ = list.get(i);

				if(nowQ.isEmpty()) continue;
				bfs(nowQ);
			}
			for (int i = liSize - 1; i >= 0; i--) {
				if(list.get(i).isEmpty()) list.remove(i);
			}
//			System.out.println("list : "+list.toString());
		}
//		print(box);
		
		int max = 0;
		boolean flag = false;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(box[i][j] == 0) {
					flag = true;
					break;
				}
				max = Math.max(max, box[i][j]);
			}
		}
		System.out.println(flag ? -1 : max-1);
		
	}
	private static void bfs(ArrayDeque<Point> q) {
		int qSize = q.size();
		for (int qs = 0; qs < qSize; qs++) {
			Point loc = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = loc.x + dx[i];
				int ny = loc.y + dy[i];
				if(nx>=0&&nx<N&&ny>=0&&ny<M&&box[nx][ny]==0) {
					box[nx][ny] = box[loc.x][loc.y] +1;
					q.offer(new Point(nx,ny));
				}
			}
			
		}
	
		
	}
	private static void print(int[][] box) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(box[i][j]+"\t");
			}
			System.out.println();
		}
		
	}

}
