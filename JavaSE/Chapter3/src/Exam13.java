import java.util.Scanner;


public class Exam13 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入年份：");
		int year = sc.nextInt();
		System.out.println("请输入月份：");
		int month = sc.nextInt();
		
		//判断年份的有效性
		if(!(year >= 1900 && year <= 2050)){
			System.out.println("非法的年份！");
			//return代表退出当前的执行方法
			return;
		}
		//判断月份的有效性
		if(!(month >= 1 && month <= 12)){
			System.out.println("非法的月份！");
			return;
		}
		//System.out.println("合法的年份和月份");
		//保存每个月的天数
		int days;
		//判断月份的范围
		switch(month){
		//2月份
		case 2:
			if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0){
				days = 29;
			}
			else{
				days = 28;
			}
			break;
		//小月
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
		System.out.println(year+"年"+month+"月份一共有"+days+"天");
		
		
	}

}
