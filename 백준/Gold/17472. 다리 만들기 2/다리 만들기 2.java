import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static class Node implements Comparable<Node>{
		int to;
		int from;
		int value;
		
		public Node(int to, int from, int value) {
			this.to = to;
			this.from = from;
			this.value = value;
		}

		@Override
		public int compareTo(Node o) {
			return this.value - o.value;
		}

		@Override
		public String toString() {
			return "Node [to=" + to + ", from=" + from + ", value=" + value + "]";
		}
		
		
		
	}
	
	static int n,m,map[][],dist[], landCnt, parents[];
	static boolean v[];
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int[][] adj;
	static PriorityQueue<Node> pq;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				int temp = Integer.parseInt(st.nextToken());
				if(temp == 1) {
					map[i][j] = -1;
				} else {
					map[i][j] = temp;					
				}
			}
		}
		landCnt=1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(map[i][j] == -1) {
					init(i, j, landCnt); // 섬 번호부여
					landCnt++;
				}
			}
		}
		adj = new int[landCnt][landCnt];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(map[i][j] > 0) {
					link(i, j); // 다리연결
				}
			}
		}
		
		pq = new PriorityQueue<Node>();
		
		for (int i = 0; i < landCnt; i++) {
			for (int j = 0; j < landCnt; j++) {
				if(adj[i][j] > 0) {
					pq.offer(new Node(i, j, adj[i][j]));	
				}
			}
		}
		
		parents = new int[landCnt];
		for (int i = 1; i < landCnt; i++) {
			parents[i] = i;
		}
		int ans = kruskal();
		
		System.out.println(ans == 0 ? -1 : ans);


	}

	private static int kruskal() {
		int sum =0;
		int size = pq.size();
		for(int i=0; i< size; i++) {
			Node node = pq.poll();
			int x = node.from;
			int y = node.to;
			
			if(find(x) != find(y)) {
				sum += node.value;
				union(x,y);
			}
		}
		
		int rx = parents[1];
		for(int i=1; i<landCnt; i++) {
			if(rx != find(parents[i])) {
				return 0;
			}
		}
		return sum;
		
	}
	
	static int find(int x) {
		if(parents[x] == x) return x;
		int rx = find(parents[x]);
		return rx;
		
	}
	
	static void union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if(x<y) {
			parents[y]=x;
		}
		else {
			parents[x] =y;
		}
	}
	

	private static void link(int x, int y) {
		int start = map[x][y]; // 현재 섬 번호
		for (int i = 0; i < 4; i++) {
			int weight=1;
			while(true) {
				int nx = x+dx[i]*weight;
				int ny = y+dy[i]*weight;
				if(nx<0||ny<0||nx>=n||ny>=m||map[nx][ny]==start) break;
				if(map[nx][ny] > 0) {
					if(weight<=2) break;
					int end = map[nx][ny];
					int w = weight-1;
					if(adj[start][end] == 0) {
						adj[start][end] = w;
						adj[end][start] = w;
					} else {
						int newW = Math.min(adj[start][end], w);
						adj[start][end] = newW;
						adj[end][start] = newW;
					}
					break;
				}
				weight++;
			}
		}
	}
	

	private static void init(int x, int y, int cnt) {
		if(x<0||y<0||x>=n||y>=m) return;
		if(map[x][y] != -1) return;
		
		map[x][y] = cnt;
		for (int i = 0; i < 4; i++) {
			init(x+dx[i], y+dy[i], cnt);
		}
		
	}


}
