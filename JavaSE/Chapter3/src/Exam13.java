import java.util.Scanner;


public class Exam13 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("��������ݣ�");
		int year = sc.nextInt();
		System.out.println("�������·ݣ�");
		int month = sc.nextInt();
		
		//�ж���ݵ���Ч��
		if(!(year >= 1900 && year <= 2050)){
			System.out.println("�Ƿ�����ݣ�");
			//return�����˳���ǰ��ִ�з���
			return;
		}
		//�ж��·ݵ���Ч��
		if(!(month >= 1 && month <= 12)){
			System.out.println("�Ƿ����·ݣ�");
			return;
		}
		//System.out.println("�Ϸ�����ݺ��·�");
		//����ÿ���µ�����
		int days;
		//�ж��·ݵķ�Χ
		switch(month){
		//2�·�
		case 2:
			if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0){
				days = 29;
			}
			else{
				days = 28;
			}
			break;
		//С��
		case 4:
		case 6:
		case 9:
		case 11:
			days = 30;
			break;
		default:
			days = 31;
			break;
		}
		System.out.println(year+"��"+month+"�·�һ����"+days+"��");
		
		
	}

}
