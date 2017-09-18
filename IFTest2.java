package java20170526;

public class IFTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// int su=500;
		int su = 44;
		// 1~100까지 입력받은 숫자만 짝홀 판별하고 시포!
		// 내가 입력 한 값이 100안에 드니? =if ==> 중첩 if

		if ((su >= 1) && (su <= 100)) {
			if (su % 2 == 0) {
				System.out.println(su + "=짝수");
			} else {
				System.out.println(su + "=홀수");
			}
		} else {
			System.out.println("su값은 100이하의 값만 입력 가능합니다.");

		}
		System.out.println("if문 끝!");
	}

}
