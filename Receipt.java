import java.io.*;
import java.util.*;
import java.lang.*;

class Receipt extends Customer
{
	static String n;
	static int count=0;
	static String list[][] = new String[50][2];  // 2d array created to store all the purchases(max = 50)
	static int total;
	static int price;
	
	Receipt (String name)
	{
		super(name);  // sending the game name to base class constructor
		this.n=name.toUpperCase();
		this.price = this.p;  // storing the price of the game from customer class in receipt class to show individual price in receipt
	}
	
	protected void setTotal(int total) 
	{
		this.total = total;
	}
	
	
	final static void insertR(int c)  // method to store the purchases in a file and print it after the puchase is done
	{
		try
		{
			list[0][0] = "Cart";	list[0][1] = "Price" ;
			for ( int i = 1 ; i < 48 ; i++ )
			{
				
				if (list[i][0] == null)
				{
					list[i][0] = n;
					list[i][1] = Integer.toString(price);  //converting integer to string
					count++; // to store the number of purchases
					break;
				}
				
			}
			File receipt=new File("Receipt.txt");  // file creation
			FileWriter a=new FileWriter(receipt);
			
			
			for(int j=0 ; j < count+1 ; j++)    //For printing the purchases for the customer
			{
				for(int r=0;r<2;r++)
				{
					if (list[j][r] != null )
					{
						a.write(list[j][r]);
						for (int g=0;g<20-list[j][r].length();g++)
						{
							a.write(" ");
						}
					}
					
					else if ( list[j][r]== null)
					{
						break;
					}
				}
				a.write("\n");			
			}
			a.write("__________________________________\n"); 
			if (c >= 2)
			{
				int discount=giveDiscount(total);  // gives discount using the method from Customer class
				
				a.write("Total               "+Integer.toString(total));
				a.write("\nDiscount 20%       -"+Integer.toString(discount)+"\n");
				a.write("----------------------------------\n");
				a.write("\nGRAND TOTAL         "+Integer.toString(total-discount));
				a.write("\n----------------------------------\n");
			}
			else
			{
				a.write("GRAND TOTAL         "+Integer.toString(total));
			}
			a.close();
		}

		
		catch(IOException e)
		{
			System.out.println("error");
		}
		catch(NullPointerException e)
		{
			System.out.println("Empty");
		}
	}
	
	final static void PrintReceipt()
	{
		try
		{
			
			Scanner out=new Scanner(new FileReader("Receipt.txt"));
			while (out.hasNextLine())
			{
				String show=out.nextLine();
				System.out.println(show);
			}
			out.close();
		}
		catch(FileNotFoundException e)
		{
			System.out.println("No purchases were made.");
		}
	}
}
	
	
	