package java20170526;

public class IFTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// int su=500;
		int su = 44;
		// 1~100���� �Է¹��� ���ڸ� ¦Ȧ �Ǻ��ϰ� ����!
		// ���� �Է� �� ���� 100�ȿ� ���? =if ==> ��ø if

		if ((su >= 1) && (su <= 100)) {
			if (su % 2 == 0) {
				System.out.println(su + "=¦��");
			} else {
				System.out.println(su + "=Ȧ��");
			}
		} else {
			System.out.println("su���� 100������ ���� �Է� �����մϴ�.");

		}
		System.out.println("if�� ��!");
	}

}
