import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();//고정비용
		int b = sc.nextInt();//생산비용
		int c = sc.nextInt();//판매가격
		int sum = a;//고정비용+생산비용
		int count = 0;
		
		if(b>=c) {
			count = -1;
		}
			else {
				count = a/(c-b)+1;
			}
		System.out.println(count);		
		
	}
}
