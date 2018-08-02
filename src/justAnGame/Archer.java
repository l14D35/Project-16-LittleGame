package justAnGame;

import java.util.Random;
/**
 * 
 * @author root
 *
 */
public class Archer extends Person 
{

	{
		super.setHp(130);
	}
	
	///////////////////////////////////////////////////////
	public Archer(String n) 
	{
		super(n);
	}

	public Archer() 
	{
		super();
	}
	/////////////////////////////////////////////////////
	
	@Override
	public void attack() 
	{
		Random generate = new Random();
		int tmpA = generate.nextInt(88 - 2) + 2;

		System.out.println(super.getName() + "(" + super.getHp() + ")" + " atakuje: " + tmpA);
		super.setAttack(tmpA);
	}

}
