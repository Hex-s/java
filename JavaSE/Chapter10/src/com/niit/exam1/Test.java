package com.niit.exam1;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//Poker poker = new Poker(Poker.DIAMOND, 8);
		//poker.details();
		
		Poker poker = new Poker(PokerEnum.heart, 10);
		poker.details();
	}

}
