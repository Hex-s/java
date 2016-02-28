package com.niit;
/**
 * 游戏类
 * @author Administrator
 *
 */
public class Game {
	//玩家
	Player[] player;
	//地图
	Map map;
	
	/**
	 * 游戏初始化的方法
	 */
	public void init(){
		
	}
	
	/**
	 * 开始游戏的方法
	 */
	public void start(){
		//选择玩家的昵称
	}
	
	/**
	 * 游戏逻辑过程的方法
	 */
	public void gameLogic(){
		
		//第一个玩家开始游戏
		process(0);
		//第二个玩家开始游戏
		process(1);
		//递归
		gameLogic();
		
		
		//表示某一个玩家
		//player[playerIndex]
		//判断玩家1是否暂停
		//如果不是暂停，玩家1扔骰子
		//玩家1前进
		//根据玩家1目前所在的位置判断不同的情况
//		switch(map.map[player[playerIndex]]){
//		case 1
//		}
		//1.幸运轮盘  如果扔的是123则玩家位置互换，如果扔的是456则多获得一次扔骰子的机会
		//2.地雷  玩家后退6格，需要考虑后退后的情况
		//3.暂停  玩家暂停一轮
		//4.时空隧道  玩家前进至下一个时空隧道的位置
		//5.如果所在位置是玩家2，则玩家2被踩回起点
		
		//第2个玩家进行游戏，逻辑过程同玩家1
		//玩家扔的骰子数超过终点时将会根据目前的格子数倒退
		//任意玩家到达终点的时候游戏结束
		//另一个玩家
		//player[1-playerIndex]
	}
	/**
	 * 每一个玩家的游戏过程的方法
	 * @param index 玩家的索引
	 */
	public void process(int index){
		if(!player[index].isStop){
			//如果玩家可以继续游戏
			//玩家1扔骰子
			int result = player[index].throwDice();
			//计算玩家目前的位置
			calculatLoaction(0, result);
			//判断玩家所在位置对应地图的情况
			switchMap(index);
		}
		else{
			//玩家1处于暂停状态
			System.out.println("本轮"+player[index].nickName+"被暂停");
			//恢复继续游戏的状态
			player[index].isStop = false;
		}
	}
	/**
	 * 计算玩家扔完骰子后所在地图的位置
	 * @param index 辨识玩家的索引
	 * @param diceResult 扔出骰子的结果
	 */
	public void calculatLoaction(int index, int diceResult){
		//将扔出的骰子数累加到玩家目前的地图位置中
		player[index].location+=diceResult;
		//玩家位置超出地图的索引，后退
		if(player[index].location > map.map.length-1){
			
		}
		//玩家位置等于地图的最大索引，游戏结束
		else if(player[index].location == map.map.length-1){
			System.out.println(player[index].nickName+"获得游戏的胜利");
			System.exit(0);
		}
	}
	/**
	 * 判断玩家所在地图中出现的各种情况
	 * @param index 玩家的索引
	 */
	public void switchMap(int index){
		//如果当前玩家和另一个的玩家的位置相同
		if(player[index].location == player[1-index].location){
			//另一个玩家踩回去
			player[1-index].location = 0;
		}
		switch(map.map[player[index].location]){
		case 1:
			//幸运轮盘
			break;
		case 2:
			//地雷
			break;
		case 3:
			//暂停
			break;
		case 4:
			//时空隧道
			break;
		}
	}
}
