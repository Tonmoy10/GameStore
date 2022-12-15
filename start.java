import java.util.* ;
import java.lang.* ;

public class start
{
	
	public static void main(String args[])
	{
		Customer customer = null ;  //Creating an object of customer type
		
		//Creating game objects
		game g1 = new game("PUBG" , 1500 , 700) ;
		game g2 = new game("CALL OF DUTY" , 3500 , 600) ;
		game g3 = new game("ANGRY BIRDS" , 1000 , 500) ;
		game g4 = new game("GOD OF WAR" , 5000 , 900) ;
		game g5 = new game() ;
		g5.setName("SPIDERMAN") ;   // Using methods of game class
		g5.setPrice(3000) ;         // Using methods of game class
		g5.setRent(700) ;           // Using methods of game class
		
	
		
		//initializing necessary variables
		int discount=0;
		int days = 0 ;
		char status = 'a';
		int price = 0 ;
		int stop = 0 ;
		int count = 0 ;
		
		
		System.out.println("**********WELCOME TO ONLINE GAME SHOP********** \n\n") ;  // main program starts
		
		game.PrintInventory();   //Printing the game list for customers to choose
		Receipt rece = null;
		
		
		do    // A do while loop is used so the customer can buy more then one game.
		{
			System.out.println("\nDo you want to \n1)Rent \n2)Buy \n(Enter the point number only!!) \n") ;
			Scanner scn = new Scanner(System.in) ;
			
			
			//Exception Handling for input error
			try
			{
				int input = scn.nextInt() ;
				if(input == 1)
				{
					System.out.println("\nFor how many days?") ;
					days = scn.nextInt() ;
					status = 'r' ;   // Used to calculate the total price  using different method based on satus value
				}
				else if(input == 2)
				{
					System.out.println("") ;
					status = 'b' ;     // Used to calculate the total price  using different method based on satus value
				}
				else
				{
					System.out.println("\nYou didn't enter a valid option. Your session is cancelled. \nPlease start over!") ;
					System.exit(0) ;
				}

			}
			catch(InputMismatchException e)
			{
				System.out.println("You didn't enter a valid option. Your session is cancelled. \nPlease start over!") ;
				System.exit(0) ;     //to stop the purchase session
			}
		
		
			Scanner sn = new Scanner(System.in) ;
			System.out.println("\nWhich game do you want to buy? \n") ;
			String name = sn.nextLine() ;
			if(status == 'r')
			{
				customer = new Customer(name , days) ;  //calling the constructor for renting
				
			}
			else if(status == 'b')
			{
				customer = new Customer(name);				//calling the constructor for buying

			}
			
			//The game objects are inserted in the array of customer class.(Association is being done)
			customer.insertDetails(g1) ;
			customer.insertDetails(g2) ;
			customer.insertDetails(g3) ;
			customer.insertDetails(g4) ;
			customer.insertDetails(g5) ;
			

			boolean stat = customer.searchGame() ;    //Checking if the desired game is available
			if(stat == true)
			{
				price += customer.calcPrice(status) ;  // Used method from inventory interface
				System.out.println("\nGame Price = " + customer.total + "\n\n") ;
				rece=new Receipt(name);  // Creating an object of receipt class
				count++ ;  // Storing the number of purchases made
			}
			

			System.out.println("-------------------------------\n Grand Total = " + price + "\n-------------------------------\n") ;
			try
			{
				rece.setTotal(price);   // Used method from receipt class to set total
				rece.insertR(count);    // Used method from receipt class for creating a invoice and storing in a file
			}
			catch(NullPointerException e)
			{
				System.out.println(" ");
			}
			System.out.println("\nDo you want to make more purchases? \n1)Yes \n2)No \n(Enter the point number only) ") ;
			try
			{
				Scanner term = new Scanner(System.in) ;
				stop = term.nextInt() ;
				if(stop <1 || stop > 2) // To restrict input within 1 and 2
				{
					System.out.println("\nYou didn't enter a valid option. Your session is cancelled. \nPlease start over!") ;
					System.exit(0) ;
				}
			}
			catch(InputMismatchException e)
			{
				System.out.println("You didn't enter a valid option. Your session is cancelled. \nPlease start over!") ;
				System.exit(0) ; 
				
			}
		}
		while(stop != 2) ;
		System.out.println("\n Thank You \n") ;
		System.out.println("Receipt \n__________________________________________ \n " );
		rece.PrintReceipt();   // Used method receipt class to print the invoice
		
		
		
		
		
	}
}