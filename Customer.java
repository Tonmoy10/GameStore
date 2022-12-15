import java.util.* ;
public class Customer extends Sell implements Inventory
{
	String name ;
	int days ;
	int total = 0;
	int count ;
	static int p;
	
	Customer(){}
	
	//Constructor for buying the game
	Customer(String name)
	{
		this.name = name ;
	}
	
	//Constructor for renting the game
	Customer(String name , int days)
	{
		this.name = name ;
		this.days = days ;
	}
	
	
	public boolean searchGame()  // method body from inventory interface. Used to search the game from list
	{
		boolean found = false ;
		name = name.toUpperCase() ;
		try
		{
			for(int i = 0; i < info.length ; i++)
			{
				//System.out.println(info[i].getName()) ;
				if(name.equals(info[i].getName()))
				{
					System.out.println("\nGame is available!!") ;
					count = i ;
					found = true ;
					return true ;
				
				}
			}
			
		}
		catch(NullPointerException e)
		{
			System.out.println("\nWe don't have the game!!") ;
		}
		return found ;
	}
	
	
	//Calculating the total price
	public int calcPrice(char status)
	{
		if(status == 'r')
		{
			p = days * info[count].getRent() ;  // Using method from game class due to association
			total += p;
		}
		else
		{
			p = info[count].getPrice();
			total += info[count].getPrice() ;
		}
		return total ;
	}
	
	//Method for giving discount
	protected static int giveDiscount(int total)
	{
		total *= 0.2 ;
		return total ;
	}
}