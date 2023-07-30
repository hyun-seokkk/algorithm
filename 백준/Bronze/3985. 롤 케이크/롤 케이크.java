import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int L = sc.nextInt();
		int N = sc.nextInt();
		
		int[] cake = new int[L];
		int[][] loc = new int[N][2];
		int maxCake = 0;
		int idx = 0;
		
		for(int i=0; i<N; i++) {
			loc[i][0] = sc.nextInt();
			loc[i][1] = sc.nextInt();
			
			int diff = loc[i][1] - loc[i][0] + 1;
			
			if(diff > maxCake) {
				maxCake = diff;
				idx = i+1;
			}
			
			for(int j=loc[i][0]-1; j<loc[i][1]; j++) {
				if(cake[j] == 0) cake[j] = i+1;
			}
		}
		
		int max = 0;
		int res = 0;
		
		for(int i=0; i<N; i++) {
			int temp = 0;
			for(int ele : cake) {
				if (i+1 == ele) temp++;
			}
			if(temp>max) {
				max=temp;
				res = i+1;
			}
		}
		System.out.println(idx);
		System.out.println(res);
		
	}

}
