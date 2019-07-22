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
		app.defeatedGoblin(playerName);
		playerHP = player.maxHP;
		playerHP += 10;
		player.maxHP += 10;
		app.monsterFight(playerName, orc, playerHP);
		app.defeatedOrc(playerName);
		playerHP = player.maxHP;
		playerHP += 20;
		player.maxHP += 20;
		player.strength = 11;
		app.theDragon(playerName);
		app.monsterFight(playerName, dragon, playerHP);
//		if (playerHP <= 0) {
//			System.out.println("You died");
//		}
		app.defeatedDragon(playerName);
		app.theMacGuffin();
//			System.out.println(callStat);

	} // main

	public String welcomePlayer(String playerName) {

		System.out.println("<<<<<<<<<<<<<<<<<|>>>>>>>>>>>>>>>>>\n" + ": Welcome hero what is your name? :\n"
				+ "<<<<<<<<<<<<<<<<<|>>>>>>>>>>>>>>>>>");
		playerName = kb.nextLine();
		player.setPlayerName(playerName);
		System.out.println("\t<><><><>\n" + "Greetings " + playerName + ".\n"
				+ "You are on a quest to retrieve\nthe MacGuffin treasure.\n"
				+ "\"A\" to vanquish your foes. \"B\" to block their blows.\n"
				+ "Can you survive to claim your prize?\n" + "\"Y\" to begin or \"N\" to retreat.\n" + "\t<><><><>");
		String begin = kb.next();
		if (begin.equalsIgnoreCase("Y")) {
			System.out.println("You begin your journey, venturing into the nearby woods.\n"
					+ "Suddenly you hear rustling in the long grass.");
		} else if (begin.equalsIgnoreCase("N")) {
			System.out.println("But the treasure!");
			System.exit(0);
		}

		return playerName;
	}

	public void defeatedGoblin(String playerName) {
		System.out.println("\t<><><><>\n" + "Having defeated your foe you honor the heroes\n"
				+ "tradition of looting dead bodies by searching the goblin\n"
				+ "for goodies. You find a helmet that gives you a +10HP bonus.\n" + "Well " + playerName
				+ ", will you continue \"Y\"\n" + "or go home \"N\"?\n" + "\t<><><><>");
		String next = kb.next();
		if (next.equalsIgnoreCase("Y")) {
			System.out.println("\t<><><><>\n" + "You push on through the forest.\n"
					+ "Soon you see a wood hut hearing a commotion\n" + "within. As you near, the entire wall drops\n"
					+ "In the cloud of debris and splinters,n\"" + "a primitive roar lashes out at you.\n"
					+ "\t<><><><>");
		} else if (next.equalsIgnoreCase("N")) {
			System.out.println("Maybe you can pawn the helmet for some beans.");
			System.exit(0);
		}
	}

	public void defeatedOrc(String playerName) {
		System.out.println("\t<><><><>\n" + "The orc drops dead. You pass its stinking\n"
				+ "corpse and check inside for survivors.\n" + "The hut owner lies dead but on the wall you\n"
				+ "notice a shield and sword. Why let it go to waste?\n"
				+ "You can an additional 20HP and 5 attack points.\n" + "You are nearing the treasure continue \"Y\"\n"
				+ "or give up and go live in the wagon by the river \"N\"?\n" + "\t<><><><>");
		String next = kb.next();
		if (next.equalsIgnoreCase("Y")) {
			System.out.println("\t<><><><>\n" + "With your new sword and shield in\n"
					+ "hand you push towards your objective.\n" + "The mythical MacGuffin treasure will\n"
					+ "ensure that your name lives on in legend forever.\n" + "Before you claim in you must find\n"
					+ "the cave it resides... with its guardian.\n" + "\t<><><><>");
		} else if (next.equalsIgnoreCase("N")) {
			System.out.println("Maybe that wagon isn't so bad after all.");
			System.exit(0);
		}
	}

	public void theDragon(String playerName) {
		System.out.println("\t<><><><>\n" + "Finally" + playerName + ", you find the cave, pausing \n"
				+ "at its mouth to reflect on your long\n" + "journey of... 2 maybe 3 minutes? You\n"
				+ "can hear the guardians heartbeat and\n" + "smell the brimstone. Do you really want\n"
				+ "to fight \"Y\" or live another day \"N\"?\n" + "No one judging you.... really I swear!\n"
				+ "\t<><><><>");
		String next = kb.next();
		if (next.equalsIgnoreCase("y")) {
			System.out.println("\t<><><><>\n" + "Setting the helmet on your\n" + "head, tightening the straps of your\n"
					+ "shield and unsheating your sword\n" + "you travel inside to meet your fate.\n" + "\t<><><><>");
		} else if (next.equalsIgnoreCase("n")) {
			System.out.println("Yeaaah" + playerName + " I lied, totally judging you.");
		}
	}

	public void monsterFight(String playerName, Monster monster, int playerHP) {
		System.out.println(player.playerName + " has encountered a " + monster.getName());
		String callStat = player.getInfo();
		System.out.println(callStat);
		String monsterStats = monster.monsterStats();
		System.out.println(monsterStats);

		int monsterHP = monster.maxHP;
		while (playerHP > 0 && monsterHP > 0) {
			System.out.println("Enter \"A\" to attack, \"B\" to block.");
			String fight = kb.next();
			if (fight.equalsIgnoreCase("A")) {
				int playerDamage = player.dealDamage();
				monsterHP = monsterHP - playerDamage;
				System.out.println(player.playerName + " attacks for " + playerDamage + " damage. " + monster.getName()
						+ " has " + monsterHP + "/" + monster.maxHP + "HP");
				int monsterDamage = monster.dealDamage();
				playerHP = playerHP - monsterDamage; //MOVED***
				System.out.println(monster.getName() + " attacks for " + monsterDamage + " damage. " + player.playerName
						+ " has " + playerHP + "/" + player.maxHP + "HP");
				player.maxHP = playerHP;//MOVED***
			} else if (fight.equalsIgnoreCase("B")) {
				System.out.println("You block the blow.");
			}
			 else if (monsterHP <= 0) {
			System.out.println("----------------------------------------------");
			System.out.println("*                                            *");
			System.out.println("|   Your enemy lies defeated at your feet.   |");
			System.out.println("*                                            *");
			System.out.println("|      \"Y\" to continue the journey.       |");
			System.out.println("*                                            *");
			System.out.println("|              Or \"N\" to quit.               |");
			System.out.println("----------------------------------------------");
			String next = kb.next();
			if (next.equalsIgnoreCase("y")) {
				
			} else if (next.equalsIgnoreCase("n")) {
				
				System.out.print("Goodbye..... coward");
				System.exit(0);
			}
			 } else if (playerHP <= 0) {

				System.out.println("You're dead " + player.playerName);
				System.exit(0);

			}
		}
	}

	public void defeatedDragon(String playerName) {
		System.out.println("\t<><><><>\n" + "With a final swing of your sword\n" + "the dragon drops dead. Dropping\n"
				+ "the your shield, which has been\n" + "melted to a lump. You wipe the\n"
				+ "blood from your eyes. Eyeing a\n" + "soft golden glow you journey deeper\n"
				+ "You find a mound of treasure with a\n" + "chest sitting atop. It has to be\n"
				+ "the MacGuffin! Open it \"Y\" or\n" + "call it a day \"N\"?\n" + "\t<><><><>");
		String next = kb.next();
		if (next.equalsIgnoreCase("Y")) {
			System.out.println("GOLD, GLORY, FINANCIAL INDEPENDENCE!");
		} else if (next.equalsIgnoreCase("n")) {
			System.out.println("I code, I mean guide you here and\n" + "you leave just like that?!?!?");
		}
	}

	public void theMacGuffin() {
		System.out.println("-------------------------------------");
		System.out.println("*     The MacGuffin Treasure        *");
		System.out.println("|       ------------------          |");
		System.out.println("*      //                \\         *");
		System.out.println("|      |      { [] }      |         |");
		System.out.println("*      |                  |         *");
		System.out.println("|      |__________________|         |");
		System.out.println("*    Can you handle it?  (Y/N)      *");
		System.out.println("-------------------------------------");
		String well = kb.next();
		if (well.equalsIgnoreCase("Y")) {
			System.out.println("\u2603");
			System.out.println("WTF?");
		} else {
			System.out.println("You can't handel the MacGuffin!");
		}

	}

} // public class

