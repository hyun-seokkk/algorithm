import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for (int i = 0; i < t; i++) {
			int h = sc.nextInt();
			int w = sc.nextInt();
			int n = sc.nextInt();
			
			int start = 0;
			int end = 0;

			if (n%h == 0) {
				start = h;
				end = n / h;
			} else {
				start = n%h;
				end = (n / h) + 1;	
			}
			
			
			if(end < 10) {
				System.out.println(start+"0"+end);				
			} else {
				System.out.println(start+""+end);
			}
			
		}
	}

}