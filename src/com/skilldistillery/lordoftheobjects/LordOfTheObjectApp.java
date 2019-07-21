package com.skilldistillery.lordoftheobjects;

import java.util.Scanner;

public class LordOfTheObjectApp {
	static Player player = new Player(6, 75);
	static Monster goblin = new Monster("Goblin", 3, 15);
	static Monster orc = new Monster("Orc", 7, 25);
	static Monster dragon = new Monster("Dragon", 10, 35);
	Scanner kb = new Scanner(System.in);

	public static void main(String[] args) {
		int playerHP = player.maxHP; 
		String playerName = "";

		LordOfTheObjectApp app = new LordOfTheObjectApp();
		app.welcomePlayer(playerName);
		app.monsterFight(playerName, goblin, playerHP);
		playerHP = player.maxHP;
		System.out.println("You leveled up and gained 10HP");
		playerHP +=10;
		player.maxHP+= 10;
		app.monsterFight(playerName, orc, playerHP);
		System.out.println("You leveled up and gained 20HP");
		playerHP = player.maxHP;
		playerHP +=20;
		player.maxHP+= 20;
		app.monsterFight(playerName, dragon, playerHP);
		if (playerHP <= 0) {
			System.out.println("You died");
		}
		app.theMacGuffin();
//			System.out.println(callStat);

	} // main

	public String welcomePlayer(String playerName) {

		System.out.println("Welcome player what is your name?");
		playerName = kb.nextLine();
		player.setPlayerName(playerName);
		String callStat = player.getInfo();
		System.out.println(playerName + " you are on a quest to retrieve the MacGuffin treasure."
				+ " \"A\" to vanquish your foes.");
		System.out.println(callStat);
		return playerName;
	}
	

	public void monsterFight(String playerName, Monster monster, int playerHP) {
		String monsterStats = monster.monsterStats();
		System.out.println(monsterStats);
		System.out.println(player.playerName + " has encountered a " + monster.getName());
		
		int monsterHP = monster.maxHP;
		while (playerHP > 0 && monsterHP > 0) {
			System.out.println("Enter \"A\" to attack");
			String A = kb.next();
			int playerDamage = player.dealDamage();
			monsterHP = monsterHP - playerDamage;
			System.out.println(player.playerName + " attacks for " + playerDamage + " damage. " + monster.getName()
					+ " has " + monsterHP + "/" + monster.maxHP);
			int monsterDamage = monster.dealDamage();
			playerHP = playerHP - monsterDamage;
			System.out.println(monster.getName() + " attacks for " + monsterDamage + " damage. " + player.playerName
					+ " has " + playerHP + "/" + player.maxHP);
		}
		if (playerHP <= 0) {
			
			System.out.println("You're dead " + player.playerName);
			System.exit(0);
		
		} else {
			System.out.println("--------------------------------------------");
			System.out.println("*                                            *");
			System.out.println("|"+monster.getName()+" is dead.              | ");				
			System.out.println("*                                            *  ");
			System.out.println("|        \"Next\" to continue the journey.   |");
			System.out.println("|                                            |");
			System.out.println("*                Or \"Q\" to quit.           *");
			System.out.println("---------------------------------------------");
			String next = kb.next();
			player.maxHP = playerHP;
			if (next.equalsIgnoreCase("next")) {
	
			} else if (next.equalsIgnoreCase("q")) {

				System.out.print("Goodbye..... coward");
			}
		}
	}
	
	public void theMacGuffin() {
		System.out.println("--------------------------------------------");
		System.out.println("*   You have found the MacGuffin.                *");
		System.out.println("|       ---------------                      | ");				
		System.out.println("*      //                \\                    *");
		System.out.println("|      |      { [] }      |                     |");
		System.out.println("|      |                  |                    |");
		System.out.println("*      |__________________|                  *");
		System.out.println("    Can you handle it?  (Y/N)                     ");
		System.out.println("---------------------------------------------");
		String well = kb.next();
		if (well.equalsIgnoreCase("Y")) {
			System.out.println("u\2603");
			System.out.println("WTF?");
		} else {
		System.out.println("You can't handel the MacGuffin!");
		}	
		
	}

} // public class
