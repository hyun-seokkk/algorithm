import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static class Vertex implements Comparable<Vertex>{
		int e, w;
		Vertex(int e, int w){
			this.e=e;
			this.w=w;
		}
		@Override
		public int compareTo(Vertex o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.w, o.w);
		}
	}
	static int V, E, T;
	static long Ans;
	public static void main(String[] args) {
//		System.setIn(최소스패닝트리_Prim_pq.class.getResourceAsStream("최소스패닝트리.txt"));
		Scanner sc = new Scanner(System.in);

        Ans = 0;
        V=sc.nextInt();
        E=sc.nextInt();
        // 인접리스트
        ArrayList<Vertex> adj[] = new ArrayList[V+1];
        for (int i = 1; i <= V; i++) {
            adj[i]=new ArrayList();
        }
        for (int i = 0; i < E; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            int w = sc.nextInt();
            adj[s].add(new Vertex(e,w));
            adj[e].add(new Vertex(s, w));
        }
        // prim
        // 방문배열
        boolean [] v=new boolean[V+1];
        // 거리배열
        int[] dist = new int[V+1];
        // 무한대로 초기화
        Arrays.fill(dist, Integer.MAX_VALUE);
        // 하나의 점정을 선택 (관습적으로 첫번째거)
        dist[1] = 0;
        PriorityQueue<Vertex> Q = new PriorityQueue<Vertex>();
        Q.add(new Vertex(1, dist[1]));
        int cnt = 0;
        while(!Q.isEmpty()) {
            // 최소비용정점
            Vertex p = Q.poll();
            // 이미 방문한 점정이라면 continue
            if(v[p.e]) continue;
            // 확정된 정점의 값을 추가해준다
            Ans += p.w;
            cnt++;
            // 성능 향상
            if(cnt == V) break;

            // p.e 기준정점으로 삼는다
            v[p.e] = true;
            int size = adj[p.e].size();
            for (int i = 0; i < size; i++) {
                // 기준 점정에서 연결된 정점들
                Vertex next = adj[p.e].get(i);
                // 연결된 정점이 방문되지 안았고
                // 새롭게 찾은 정점의 값이 기존에 찾았던 값보다 작다면
                // 거리배열을 업데이트한다
                if(!v[next.e]&&dist[next.e]>next.w) {
                    dist[next.e]=next.w;
                    // 연결된 정점들을 Q에 저장한다
                    Q.add(new Vertex(next.e,next.w));
                }
            }
        }

        System.out.println(Ans);
		
	}
}
