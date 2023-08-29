import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int R,C,M, map[][], ans;
	static int[] dx = {0, -1, 1, 0, 0};
	static int[] dy = {0, 0, 0, 1, -1};
	
	static class Shark {
		int r,c,speed,d,size;
		boolean isLive;

		public Shark(int r, int c, int speed, int d, int size) {
			super();
			this.r = r;
			this.c = c;
			this.speed = speed;
			this.d = d;
			this.size = size;
			this.isLive = true;
		}

		@Override
		public String toString() {
			return "Shark [r=" + r + ", c=" + c + ", speed=" + speed + ", d=" + d + ", size=" + size + "]";
		}
		
	}
	
	static ArrayList<Shark> list;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
        //System.setIn(new FileInputStream("src/input.txt")); 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
    
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken()); // 상어 수
        
        map = new int[R][C];
        
        list = new ArrayList<>();
        list.add(null); // 상어번호 1부터 부여하기 위해 0번인덱스에 null추가
        for (int i = 0; i < M; i++) {
        	st = new StringTokenizer(br.readLine());
        	int r = Integer.parseInt(st.nextToken())-1;
        	int c = Integer.parseInt(st.nextToken())-1;
        	int s = Integer.parseInt(st.nextToken());
        	int d = Integer.parseInt(st.nextToken());
        	int z = Integer.parseInt(st.nextToken());
        	
        	list.add(new Shark(r, c, s, d, z)); // 상어정보 추가
		}
        
        for (int i = 1; i <= M; i++) { // 맵에 상어정보 입력
			int r = list.get(i).r;
			int c = list.get(i).c;
			
			map[r][c] = i;
		}
        
        for (int i = 0; i < C; i++) { // 낚시꾼 움직임
			for (int j = 0; j < R; j++) { // 가까운 상어 탐색
				if(map[j][i] != 0) { // 가까운 상어 있으면 잡고 잡으면 멈추기
					int sharkNum = map[j][i];
					ans += list.get(sharkNum).size; // 결과값에 상어크기 더해주기
					list.get(sharkNum).isLive = false; //상어죽임
					map[j][i] = 0; // 맵에서 상어 없애주기
					break;
				}
			}
			
			
			for (int j = 1; j <= M; j++) { // 모든 상어 순회하며 이동시켜줌
				int nowR = list.get(j).r;
				int nowC = list.get(j).c;
				
				if(list.get(j).isLive) { // 살아있으면 이동 ㄱㄱ
					move(j, nowR, nowC, list.get(j).speed, list.get(j).d);					
				}

			}
			
			int[][] tempMap = new int[R][C]; // 이동시킨 상어정보들 임시 맵에 추가
			
			for (int j = 1; j <= M; j++) {
				if(list.get(j).isLive) { // 살아있으면 맵에 배치
					int nxtR = list.get(j).r;
					int nxtC = list.get(j).c;
					if(tempMap[nxtR][nxtC] != 0) { // 배치하려는데 다른상어 만나면
						int temp = tempMap[nxtR][nxtC]; // 다른상어 정보 임시저장
						if(list.get(j).size > list.get(temp).size) { // 이동할 상어가 기존상어보다 크면
							list.get(temp).isLive = false;
							tempMap[nxtR][nxtC] = j; // 이동
						} else {
							list.get(j).isLive = false; // 기존애가 더 크면 먹힘
						}
					} else { // 배치하려는데 아무도 없으면
						tempMap[nxtR][nxtC] = j; // 그냥이동
					}
				}
			}
			map = tempMap;
		}
        
		System.out.println(ans);
		
		
	}

	private static void move(int i, int r, int c, int speed, int d) {
		switch (d) {
		case 1:
			if(speed <= r) {
				list.get(i).r = r-speed;
				list.get(i).d = 1;
				return;
			} else {
				int s = speed - r;
				move(i, 0, c, s, 2);
			}
			break;
		case 2:

			if(speed < R-r) {
				list.get(i).r = r+speed;
				list.get(i).d = 2;
				return;
			} else {
				int s = speed - (R-r-1);
				move(i, R-1, c, s, 1);
			}
			break;
		case 3:
			if(speed < C-c) {
				list.get(i).c = c+speed;
				list.get(i).d = 3;
				return;
			} else {
				int s = speed - (C-c-1);
				move(i, r, C-1, s, 4);
			}
			break;
		case 4:
			if(speed <= c) {
				list.get(i).c = c-speed;
				list.get(i).d = 4;
				return;
			} else {
				int s = speed - c;
				move(i, r, 0, s, 3);
			}
			break;
		}
	}

	private static void print(int[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}

}
