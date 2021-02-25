import java.util.*;

public class Main {
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		Random rand = new Random();
		
		//variables
		String[] enemies = {"skeleton","Zoombie","Ghost","Warrior"};
		int maxEnemyHealth = 80;
		int enemyAttackDamage = 20;
		
		int health = 100;
		int attackDamage = 50;
		int numHealthPotions = 3;
		int healthPotionHealAmount = 30;
		int healthPotionDropChance = 50; //percentage
		
		boolean running = true;

		System.out.println("---Welcome to the game---");
		
		GAME:
		while(running)
		{
			System.out.println("-------------------------");
			
			int enemyHealth = rand.nextInt(maxEnemyHealth);
			String enemy = enemies[rand.nextInt(enemies.length)];
			System.out.println("\t# "+ enemy + " has appeared! #\n");
			
			while(enemyHealth > 0)
			{
				System.out.println("\t Your HP : "+health);
				System.out.println("\t"+ enemy+"'s HP : "+enemyHealth);
				System.out.println("\tWhat would you like to do : ");
				System.out.println("\t1. Attack");
				System.out.println("\t2. Drink Health Potion");
				System.out.println("\t3. Run");
				
				String input = sc.nextLine();
				if(input.equals("1"))
				{
					int damageTaken=rand.nextInt(attackDamage);
					int damageDealt=rand.nextInt(enemyAttackDamage);
					
					enemyHealth -= damageTaken;
					health -= damageTaken;
					
					System.out.println("\t You damaged the " + enemy + " for "+ damageDealt + " damage.");
					System.out.println("\t You received " + damageTaken);
					
					if(health <= 1)
					{
						System.out.println("You have taken too much of damage and you are very weak");
						break;
					}
				}
				else if(input.equals("2"))
				{
					if(numHealthPotions > 0)
					{
						health += healthPotionHealAmount;
						numHealthPotions--;
						System.out.println("\tYou drink health potion"+healthPotionHealAmount+"."
						+"\n\tYou now have "+health+" HP."
						+"\n\tYou have "+numHealthPotions+" health potion left.\n");
					}
					else
					{
						System.out.println("\tYou have no health potion left. Defeat the enemy to get health potion.");
					}
				}
				else if(input.equals("3"))
				{
					System.out.println("You run away from "+enemy);
					continue GAME;
				}
				else
				{
					System.out.println("Invalid command ....");
				}
			}
			if(health < 1)
			{
				System.out.println("You are weak for battle, You are out of game");
				break;
			}
			System.out.println("-------------------------------------");
			System.out.println(" # "+enemy+" was defeated #");
			System.out.println("You have "+health+" HP left");
			if(rand.nextInt(100) < healthPotionDropChance)
			{
				numHealthPotions++;
				System.out.println(" # The "+enemy+" dropped a health potion! #");
				System.out.println(" # You now have "+numHealthPotions+"health potion(s). #");
			}
			System.out.println("---------------------------------------------");
			System.out.println("What do you want to do ?");
			System.out.println("1> Continue fighting");
			System.out.println("2> Exit Game");
			
			String input = sc.nextLine();
			
			while(!input.equals("1") && !input.equals("2"))
			{
				System.out.println("Invalid command");
				input = sc.nextLine();
			}
			
			if(input.equals("1"))
			{
				System.out.println("Continue on the adventure ....");
			}
			else if(input.contentEquals("2"))
			{
				System.out.println("You have successfully exitted from the game ....");
				break;
			}
		}
		System.out.println("----------------------------------");
		System.out.println("---Thanks for playing---");
		System.out.println("-----------------------------------");
	}
}
