import java.util.Scanner;


public class Calendar {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("��������ݣ�");
		int year = sc.nextInt();
		System.out.println("�������·ݣ�");
		int month = sc.nextInt();
		//������
		int totalDays = 0;
		//�ۼ�1900��������ݼ��������
		for(int i = 1900; i < year; i++){
			//�ж��Ƿ�������
			if(i%4 == 0 && i%100 != 0 || i%400 == 0){
				totalDays+=366;
			}
			else{
				totalDays+=365;
			}
		}
		//�ۼ�1�·��������·ݼ��������
		//ÿ�µ�����
		int days = 0;
		for(int i = 1; i <= month; i++){
			//�ж�ÿ�����Ǵ��»���С�»�����2��
			switch(i){
			case 2:
				//�жϵ�ǰ����Ƿ�������
				if(year%4 == 0 && year%100 != 0 || year%400 == 0){
					days = 29;
				}
				else{
					days = 28;
				}
				break;
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
			//�ۼ�ÿ�µ�����
			if(i < month){
				totalDays+=days;
			}
		}
		//�����·ݵ�һ���������
		int week = (totalDays+1)%7;
		//System.out.println(week);
		System.out.println("������\t����һ\t���ڶ�\t������\t������\t������\t������");
		//�����������������·ݵ�һ��Ĵ�ӡλ��
		for(int i = 1; i <= week; i++){
			System.out.print("\t");
		}
		
		//��ӡ��ǰ�·ݵ�ÿһ��
		for(int i = 1; i <=days; i++){
			System.out.print(i+"\t");
			//�ж��·���ÿһ�������ڼ���������������ͻ���
			if((totalDays+i)%7 == 6){
				System.out.println();
			}
		}
	}
}
