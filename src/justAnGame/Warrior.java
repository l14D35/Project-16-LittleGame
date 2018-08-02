package justAnGame;

import java.util.Random;
/**
 * 
 * @author root
 *
 */
public class Warrior extends Person 
{

	{
		super.setHp(220);
	}
	///////////////////////////////////////////////////
	public Warrior(String n)
	{
		super(n);
	}
	
	public Warrior()
	{
		super();
	}
	///////////////////////////////////////////////////

	@Override
	public void attack()
	{
		Random generate = new Random();
		int tmpA = generate.nextInt(36 - 13) + 13;

		System.out.println(super.getName() + "(" + super.getHp() + ")" + " atakuje: " + tmpA);
		super.setAttack(tmpA);
	}
	
}