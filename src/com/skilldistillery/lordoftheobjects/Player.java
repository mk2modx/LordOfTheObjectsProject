package com.skilldistillery.lordoftheobjects;


public class Player extends Creature {
	String playerName =("");
	int potions = 0;
	
	public Player() {
		
	}
	
	public Player(int strength, int MaxHP) {
		this.setPlayerName(playerName);
		this.setStrength(5);
		this.setMaxHP(50);
			
	}
	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public int getPotions() {
		return potions;
	}

	public void setPotions(int potions) {
		this.potions = potions;
	}

	public String getInfo() {
		return  playerName+ " has " +maxHP+ " / "+maxHP+"HP";
	}
	
}

