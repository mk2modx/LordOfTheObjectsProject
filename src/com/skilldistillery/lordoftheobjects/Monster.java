package com.skilldistillery.lordoftheobjects;


public class Monster extends Creature{

public Monster() {
		
	}
	
	
	
	public Monster(String name, int strength, int maxHP) {
	super(name, strength, maxHP);
	
}



	public String getMonster() {
		System.out.println(maxHP);
		return maxHP + "";
	}
	
	public String monsterStats() {
		return this.name+" has : current HP "+maxHP+"/ max HP "+maxHP;
	}
	
}
