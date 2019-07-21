package com.skilldistillery.lordoftheobjects;


public class Creature {
	protected String name;
	protected int strength;
//	protected int currentHP;
	protected int maxHP;
//	protected boolean isAlive;
	String stats = "";

//	public boolean isAlive() {
//		if (currentHP > 0);
//		return isAlive;
//	}

	public Creature() {
	}

	

	public Creature(String name, int strength, int maxHP) {
		this.name = name;
		this.strength = strength;
		this.maxHP = maxHP;
		
	}
	
//	public String getInfo() {
//		return name+" has "+currentHP+"/"+maxHP;
//	}

//	public Creature() {
//	}

	public String getName() {
		return name;
	}

	public void setName(String creature) {
		this.name = name;
	}

	public String getStats() {
		return stats;
	}

	public void setStats(String stats) {
		this.stats = stats;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

//	public int getCurrentHP() {
//		return currentHP;
//	}
//
//	public void setCurrentHP(int currentHP) {
//		this.currentHP = currentHP;
//	}

	public int getMaxHP() {
		return maxHP;
	}

	public void setMaxHP(int maxHP) {
		this.maxHP = maxHP;
	}
	
	public int dealDamage () {
		return ((int)(Math.random()*strength)+1);
	}

}
