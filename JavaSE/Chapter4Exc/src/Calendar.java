import java.util.Scanner;


public class Calendar {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入年份：");
		int year = sc.nextInt();
		System.out.println("请输入月份：");
		int month = sc.nextInt();
		//总天数
		int totalDays = 0;
		//累加1900至所输年份间的总天数
		for(int i = 1900; i < year; i++){
			//判断是否是闰年
			if(i%4 == 0 && i%100 != 0 || i%400 == 0){
				totalDays+=366;
			}
			else{
				totalDays+=365;
			}
		}
		//累加1月份至所输月份间的总天数
		//每月的天数
		int days = 0;
		for(int i = 1; i <= month; i++){
			//判断每个月是大月还是小月或者是2月
			switch(i){
			case 2:
				//判断当前年份是否是闰年
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
			//累加每月的天数
			if(i < month){
				totalDays+=days;
			}
		}
		//所输月份第一天的星期数
		int week = (totalDays+1)%7;
		//System.out.println(week);
		System.out.println("星期日\t星期一\t星期二\t星期三\t星期四\t星期五\t星期六");
		//星期数决定了所输月份第一天的打印位置
		for(int i = 1; i <= week; i++){
			System.out.print("\t");
		}
		
		//打印当前月份的每一天
		for(int i = 1; i <=days; i++){
			System.out.print(i+"\t");
			//判断月份中每一天是星期几，如果是星期六就换行
			if((totalDays+i)%7 == 6){
				System.out.println();
			}
		}
	}
}
