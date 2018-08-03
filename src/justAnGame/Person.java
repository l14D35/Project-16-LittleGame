package justAnGame;

import java.util.*;
/**
 *
 * @author root
 *
 */
public abstract class Person implements Attackable
{
	
	private String name = "";
	private int hp = 0;
	private int attack = 0;
	private int experience = 0;
	
	//////////////////////////////////////////////////////
	public Person(String n)
	{
		name = n;
	}
	
	public Person()
	{
		setName();
	}
	///////////////////////////////////////////////////////
	
	public int getHp()
	{
		return hp;
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getAttack()
	{
		return attack;
	}
	
	public void setHp(int hp)
	{
		this.hp = hp;
	}
	
	public final void setName()
	{
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		String tmpName = "";
		System.out.println("Podaj imie swojej postaci: ");
		tmpName = in.next();
		name = tmpName;
	}
	
	public void setAttack(int attack)
	{
		this.attack = attack;
	}

	public int getExperience()
	{
		return experience;
	}

	public void setExperience(int experience)
	{
		this.experience += experience;
	}
}
