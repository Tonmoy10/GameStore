public class Sell
{
	game info[] = new game[10] ;  //An array to store all the game informations
	
	//Method to insert new games on inventory
	protected void insertDetails(game a)
	{
		boolean status = false ;
		for(int i = 0 ; i<info.length ; i ++)
		{
			if(info[i] == null)
			{
				info[i] = a ;
				status = true ;
				break ;
			}
		}
		if(status == false)
		{
			System.out.println("Inventory is full!") ;
		}
	}
	
	//Method to show all the game details at once
	public void showDetails()
	{
		System.out.println("----------------------------------------");
		for(int i = 0 ; i<info.length ; i++)
		{
			if(info[i] != null)
			{
				System.out.println("Name : " + info[i].getName()) ;
				System.out.println("Price : " + info[i].getPrice()) ;
				System.out.println("Rent rate : " + info[i].getRent()) ;
				System.out.println("----------------------------------------");
			}
		}
		
	}
}