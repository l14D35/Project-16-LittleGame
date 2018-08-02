package justAnGame;

import java.util.concurrent.TimeUnit;

public class MainGame
{
	public static void main(String[] args) 
	{
		Person[] heroes = new Person[2];
		
		//Nowa tablica majace te same elementy 
		//Uzywajac cloned nie zmieniamy oryginalu!
		Person[] cloned = (Person[]) heroes.clone();
		
		cloned[0] = new Warrior("Klon Kible");
		cloned[1] = new Archer("Klon Dell");
		
		cloned[0].setHp(300);
		
		heroes[0] = new Warrior("Kible");
		heroes[1] = new Archer("Dell");
		
		pvp(heroes[0], heroes[1]);
		
		System.exit(0);
	}
	
	/**
	 * Outputs info about hero
	 * @param p is an created hero
	 */
	public static void createdClass(Person p)
	{
		System.out.println("Your character: ");
		System.out.println("Name: " + p.getName());
		System.out.println("Class: " + p.getClass().getSimpleName());
		System.out.println("Hp: " + p.getHp());
	}
	
	/**
	 * 
	 * @param p first opponent
	 * @param aP second opponent
	 */
	public static void pvp(Person p, Person aP)
	{
		int fHp = 0, sHp = 0;
		String winner = "";
		fHp = p.getHp();
		sHp = aP.getHp();
		
		System.out.println("\nPvP between:\nClass: " + p.getClass().getSimpleName());			
		System.out.println("Name: " + p.getName() + " HP: " + p.getHp() + "\nAND ");
		
		System.out.println("Class: " + aP.getClass().getSimpleName());			
		System.out.println("Name: " + aP.getName() + " HP: " + aP.getHp() + "\n");
		
		
		do
		{
			p.attack();
			try
			{
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			sHp -= p.getAttack();
			aP.setHp(sHp);
			
			if (sHp <= 0)
			{	
				System.out.println("Class: " + p.getClass().getSimpleName() + 
						" - " + p.getName() + " won! With HP: " + p.getHp() );
				System.out.println("Class: " + aP.getClass().getSimpleName() + 
						" - " + aP.getName() + " lost! With HP: " + aP.getHp());
				
				winner = p.getName();
				
				break;
			}
			
			aP.attack();
			try
			{
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			fHp -= aP.getAttack();
			p.setHp(fHp);
			
			if (fHp <= 0)
			{
				System.out.println("Class: " + aP.getClass().getSimpleName() + 
						" - " + aP.getName() + " won! With HP: " + aP.getHp());
				System.out.println("Class: " + p.getClass().getSimpleName() + 
						" - " + p.getName() + " lost! With HP: " + p.getHp());
				
				winner = aP.getName();
				
				break;
			}
		}
		while ( (fHp > 0) && (sHp > 0) );

		System.out.println("The winner is: " + winner);
	}

}
