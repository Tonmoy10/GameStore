import java.io.*;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.lang.*;

public class game
{
	protected static void PrintInventory()  //Method to show the game list and store them in a text file
	{
		String inventory[][] = new String[6][3] ;
		
		inventory[0][0] = "Name";
		inventory[0][1] = "Price" ; inventory[0][2] = "Rent" ;
		inventory[1][0] = "PUBG" ; inventory[1][1] = "1500" ; inventory[1][2] = "700" ;
		inventory[2][0] = "ANGRY BIRDS" ; inventory[2][1] = "1000" ; inventory[2][2] = "500" ;
		inventory[3][0] = "CALL OF DUTY" ; inventory[3][1] = "3500" ; inventory[3][2] = "600" ;
		inventory[4][0] = "GOD OF WAR" ; inventory[4][1] = "5000" ; inventory[4][2] = "900" ;
		inventory[5][0] = "SPIDERMAN" ; inventory[5][1] = "3000"; inventory[5][2] = "700 \n" ;
		try
		{
			File in= new File("inventory.txt");
			FileWriter w =new FileWriter(in);
				for (int j=0 ; j<6 ; j++)   //For storing game informations in a file
				{
					for( int r =0;r<3;r++)
					{
						w.write(inventory[j][r]);
						for (int g=0;g<20-inventory[j][r].length();g++)
						{
							w.write(" ");
						}
					}
					w.write("\n");
				}
			w.close();
		} 
		catch (IOException e){
			System.out.println("Error");
			e.printStackTrace();
		}
		for(int j=0;j<6;j++)    //For printing the purchases for the customer
		{
			for(int r=0;r<3;r++)
			{
				System.out.print(inventory[j][r]);
				for (int g=0;g<20-inventory[j][r].length();g++)
				{
					System.out.print(" ");
				}
			}
			System.out.print("\n");
		}		
		
	}
	
	
	String name ; int price ; int rent ;
	
	game(){System.out.println("") ;}
	
	game(String name , int price , int rent)
	{
		this.name = name ;
		this.price = price ;
		this.rent = rent ;
	}
	
	public void setName(String name){this.name = name ;}
	public void setPrice(int price){this.price = price ;}
	public void setRent(int rent){this.rent = rent ;}
	
	public String getName(){return this.name ;}
	public int getPrice(){return this.price ;}
	public int getRent(){return this.rent ;}

	
	//Method to show details for a game seperately
	public void showDetails()
	{
		System.out.println("Name = " + this.name) ;
		System.out.println("Price = " + this.price) ;
		System.out.println("Rent rate = " + this.rent) ;
	}
}