package justAnGame;

import java.awt.Color;
import java.util.concurrent.TimeUnit;
import javax.swing.JFrame;

public class MainGame
{
	static String winner;

	public static void main(String[] args)
	{
		Person[] heroes = new Person[2];

		// Nowa tablica majace te same elementy
		// Uzywajac cloned nie zmieniamy oryginalu!
		Person[] cloned = (Person[]) heroes.clone();

		cloned[0] = new Warrior("Klon Kible");
		cloned[1] = new Archer("Klon Dell");

		heroes[0] = new Warrior("Kible");
		heroes[1] = new Archer("Dell");

		pvp(heroes[0], heroes[1]);

		JFrame frame = new FontFrame();
		frame.setTitle("Winner");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(500, 250);
		frame.setVisible(true);
		while(frame.isEnabled())
		{
			try
			{
				frame.getContentPane().setBackground(Color.YELLOW);
				TimeUnit.MILLISECONDS.sleep(300);
				frame.getContentPane().setBackground(Color.BLUE);
				TimeUnit.MILLISECONDS.sleep(300);
				frame.getContentPane().setBackground(Color.GREEN);
				TimeUnit.MILLISECONDS.sleep(300);
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		

		// System.exit(0);
	}

	/**
	 * Outputs info about hero
	 * 
	 * @param p is an created hero
	 */
	public static void createdClass(Person p)
	{
		System.out.println("Your character: ");
		System.out.println("Name: " + p.getName());
		System.out.println("Class: " + p.getClass().getSimpleName());
		System.out.println("Hp: " + p.getHp());
	}

	@SuppressWarnings("serial")
	static class FontFrame extends JFrame
	{
		public FontFrame()
		{
			FrameWinner fw = new FrameWinner();
			fw.setMessage("The winner is: " + winner);
			add(fw);
			pack();
		}
	}

	/**
	 * Simple PVP
	 * 
	 * @param p  first opponent
	 * @param aP second opponent
	 */
	public static void pvp(Person p, Person aP)
	{
		int fHp = 0, sHp = 0;
		// String winner = null;
		fHp = p.getHp();
		sHp = aP.getHp();

		System.out.println("\nPvP between:\nClass: " + p.getClass().getSimpleName());
		System.out.println("Name: " + p.getName() + " HP: " + p.getHp() + "\nAND ");

		System.out.println("Class: " + aP.getClass().getSimpleName());
		System.out.println("Name: " + aP.getName() + " HP: " + aP.getHp() + "\n");

		try
		{
			TimeUnit.SECONDS.sleep(0);
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}

		do
		{
			p.attack();
			try
			{
				TimeUnit.SECONDS.sleep(0);
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			sHp -= p.getAttack();
			aP.setHp(sHp);

			if (sHp <= 0)
			{
				System.out.println(
						"Class: " + p.getClass().getSimpleName() + " - " + p.getName() + " won! With HP: " + p.getHp());
				System.out.println("Class: " + aP.getClass().getSimpleName() + " - " + aP.getName() + " lost! With HP: "
						+ aP.getHp());

				p.setExperience(20);
				winner = p.getClass().getSimpleName();

				break;
			}

			aP.attack();
			try
			{
				TimeUnit.SECONDS.sleep(0);
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			fHp -= aP.getAttack();
			p.setHp(fHp);

			if (fHp <= 0)
			{
				System.out.println("Class: " + aP.getClass().getSimpleName() + " - " + aP.getName() + " won! With HP: "
						+ aP.getHp());
				System.out.println("Class: " + p.getClass().getSimpleName() + " - " + p.getName() + " lost! With HP: "
						+ p.getHp());

				aP.setExperience(20);
				winner = aP.getClass().getSimpleName();

				break;
			}
		} while ((fHp > 0) && (sHp > 0));

	}

}
