package com.niit;
/**
 * ��Ϸ��
 * @author Administrator
 *
 */
public class Game {
	//���
	Player[] player;
	//��ͼ
	Map map;
	
	/**
	 * ��Ϸ��ʼ���ķ���
	 */
	public void init(){
		
	}
	
	/**
	 * ��ʼ��Ϸ�ķ���
	 */
	public void start(){
		//ѡ����ҵ��ǳ�
	}
	
	/**
	 * ��Ϸ�߼����̵ķ���
	 */
	public void gameLogic(){
		
		//��һ����ҿ�ʼ��Ϸ
		process(0);
		//�ڶ�����ҿ�ʼ��Ϸ
		process(1);
		//�ݹ�
		gameLogic();
		
		
		//��ʾĳһ�����
		//player[playerIndex]
		//�ж����1�Ƿ���ͣ
		//���������ͣ�����1������
		//���1ǰ��
		//�������1Ŀǰ���ڵ�λ���жϲ�ͬ�����
//		switch(map.map[player[playerIndex]]){
//		case 1
//		}
		//1.��������  ����ӵ���123�����λ�û���������ӵ���456�����һ�������ӵĻ���
		//2.����  ��Һ���6����Ҫ���Ǻ��˺�����
		//3.��ͣ  �����ͣһ��
		//4.ʱ�����  ���ǰ������һ��ʱ�������λ��
		//5.�������λ�������2�������2���Ȼ����
		
		//��2����ҽ�����Ϸ���߼�����ͬ���1
		//����ӵ������������յ�ʱ�������Ŀǰ�ĸ���������
		//������ҵ����յ��ʱ����Ϸ����
		//��һ�����
		//player[1-playerIndex]
	}
	/**
	 * ÿһ����ҵ���Ϸ���̵ķ���
	 * @param index ��ҵ�����
	 */
	public void process(int index){
		if(!player[index].isStop){
			//�����ҿ��Լ�����Ϸ
			//���1������
			int result = player[index].throwDice();
			//�������Ŀǰ��λ��
			calculatLoaction(0, result);
			//�ж��������λ�ö�Ӧ��ͼ�����
			switchMap(index);
		}
		else{
			//���1������ͣ״̬
			System.out.println("����"+player[index].nickName+"����ͣ");
			//�ָ�������Ϸ��״̬
			player[index].isStop = false;
		}
	}
	/**
	 * ��������������Ӻ����ڵ�ͼ��λ��
	 * @param index ��ʶ��ҵ�����
	 * @param diceResult �ӳ����ӵĽ��
	 */
	public void calculatLoaction(int index, int diceResult){
		//���ӳ����������ۼӵ����Ŀǰ�ĵ�ͼλ����
		player[index].location+=diceResult;
		//���λ�ó�����ͼ������������
		if(player[index].location > map.map.length-1){
			
		}
		//���λ�õ��ڵ�ͼ�������������Ϸ����
		else if(player[index].location == map.map.length-1){
			System.out.println(player[index].nickName+"�����Ϸ��ʤ��");
			System.exit(0);
		}
	}
	/**
	 * �ж�������ڵ�ͼ�г��ֵĸ������
	 * @param index ��ҵ�����
	 */
	public void switchMap(int index){
		//�����ǰ��Һ���һ������ҵ�λ����ͬ
		if(player[index].location == player[1-index].location){
			//��һ����ҲȻ�ȥ
			player[1-index].location = 0;
		}
		switch(map.map[player[index].location]){
		case 1:
			//��������
			break;
		case 2:
			//����
			break;
		case 3:
			//��ͣ
			break;
		case 4:
			//ʱ�����
			break;
		}
	}
}
