package justAnGame;

import java.util.*;
/**
 *
 * @author root
 *
 */
public abstract class Person implements Attackable
{
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + attack;
		result = prime * result + hp;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (attack != other.attack)
			return false;
		if (hp != other.hp)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	private String name = "";
	private int hp = 0;
	private int attack = 0;
	
	
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
	
	public void setHp(int tmpHp)
	{
		hp = tmpHp;
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
	
	public void setAttack(int aAttack)
	{
		attack = aAttack;
	}
}
