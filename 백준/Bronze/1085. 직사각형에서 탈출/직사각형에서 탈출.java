import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int x = sc.nextInt();
		int y = sc.nextInt();
		int w = sc.nextInt();
		int h = sc.nextInt();
		int xmin = 0, ymin = 0;
		
		if(w-x > x) 
			xmin = x;//x가 w보다 x축에 가까우면 x출력
		else
			xmin = w-x;//x가 x축보다 w에 가까우면 x에서 w사이의 거리 출력
		if(h-y > y)
			ymin = y;
		else
			ymin = h-y;
		
		if(xmin > ymin) //x와y 중 사각형의 경계선에 더 가까운 좌표 출력
			System.out.println(ymin);
		else
			System.out.println(xmin);
	}

}
