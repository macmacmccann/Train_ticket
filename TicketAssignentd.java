import java.text.DecimalFormat; // Decimal Format is called. 
import java.util.Scanner; // Scanner is imported 

public class TicketAssignentd
{

	static Scanner input = new Scanner(System.in);
	static DecimalFormat currency = new DecimalFormat("0.00");
	static int adultQty = 5; //Quantity of adult tickets 
	static int childQty = 5;  
	static double totalTakings =0;  //totalTakings starts at 0. 
	static int numTransactions =0;  //numTransactions is set to 0.
	static String d = "0";
	static int price = Integer.parseInt(d); // Changing String d to an Integer value of 0
	static String c = "0";
	static double numTranscations = Double.parseDouble(c); // Changing String c to a Double value of 0 
	static int price2 = 0 ;
	static int updatablepricevalue = price;
	static int holdthisvalue = 0;
	
	
	
public static void main(String[] args)
{
	menu(); //Class menu is called. 
}


public static void payment(String adultorchild,String tickettype) {

if (numTranscations == 0 && adultorchild == "Adult" && tickettype  == "Single" )
{
	price = 25; // set value of chosen ticket to 25
	adultQty--;
	numTransactions++;	
}
else if (numTranscations > 0 && adultorchild == "Adult" && tickettype  == "Single" )
	{
		price2 = 25; // set value of chosen ticket to 25
		adultQty--;
		numTransactions++;	
}
else if (adultorchild == "Adult" && tickettype  == "Return")  //if not adult and single may be adult and return to set price 
{
	price = 50; // If two variables chosen match price data-type is set to 50.
	price = 50;
	adultQty--; // Quantity of adult tickets is lowered. 
	numTransactions++; // Number of transactions is set to +1 to represent a transaction done . 
	totalTakings = totalTakings + price; // "Totaltakings" is updated with the added value of price variable. 
	price = price2 + price;
	updatablepricevalue= price ;
	holdthisvalue = updatablepricevalue;
	price = holdthisvalue + price;
}
else if (adultorchild == "Child"  && tickettype == "Single")
{
	price = 15;
	price2 =15;
	childQty--;
	numTransactions++;
	totalTakings = totalTakings + price;
	price = price2 + price;
	updatablepricevalue= price ;
	holdthisvalue = updatablepricevalue;
	price = holdthisvalue + price;
}	
else if (adultorchild == "Child" && tickettype == "Return")
{
	price = 30;
	price2 = 30;
	childQty--;
	numTransactions++;
	totalTakings = totalTakings + price;
	price = price2 + price;
	updatablepricevalue= price ;
	holdthisvalue = updatablepricevalue;
	price = holdthisvalue + price;
	
}


System.out.println("You chose " + adultorchild + " " + tickettype + " ticket.");
System.out.println(" Do you want any more tickets?");
System.out.println("Press 1 for more tickets");
System.out.println("Press 2 to decline and continue ");

{
String choice = input.next();
switch(choice)

{
case "1" :
	menu2();
case "2" :
	break;

}
}
System.out.println("The price is: " +"€" + currency.format(price)); //System displays price 
System.out.println("Please insert cash: ");

double moneygiven = input.nextDouble();//Request user to input cash in the form of a double/ int 

while (moneygiven < price) // An if statement when user hasn't entered enough money. 
	{
	System.out.println("Remaining balance is " + currency.format(price - moneygiven)); //System asks for remaining cash.
	System.out.println("Please insert the required amount of cash");
	moneygiven = moneygiven + input.nextDouble(); // System captures amount of money . 
	System.out.println("Please take your " + adultorchild + " " + tickettype + " ticket.");
	System.out.println("Thank you for using our service ,enjoy your trip.");
	more();

	break;
	}
	if (moneygiven> price) // If user gave more money than needed system gives it back
	{
		System.out.println("Please take your extra " + currency.format(moneygiven - price) + " Thank you "); //System calculates extra amount of money. 
		System.out.println("Please take your " + adultorchild + " " + tickettype + " ticket."); //System displays your choice 
		System.out.println("Thank you for using our service ,enjoy your trip."); 
		more();
		}
	while (moneygiven == price)
	{
		System.out.println("Please take your " + adultorchild + " " + tickettype + " ticket.");
		System.out.println("Thank you for using our service ,enjoy your trip.");
		more();
		menu();
		break;
	}
	}

public static void choosetickettype(String singleorreturn)
{
	System.out.println("Press 1 for Single Way");
	System.out.println("Press 2 for Return");
	String choice = input.next();
	switch (choice)
	{
	case "1":
			payment(singleorreturn, "Single");
			break;
	case "2":
			payment(singleorreturn, "Return");
			
			break;
	default:
		System.out.println("Please try again what you entered is not an option");
		choosetickettype(singleorreturn);
		break;
	}
}
public static void  chooseadultorchild()
{
	String choice = input.next();
	switch (choice)
	{
	case "1":
		if(adultQty== 0)
		{
			System.out.println("Sold out please try again");
		}
		else
		{
			choosetickettype("Adult");
			break;
		}
	
	case "2":
		if(childQty==0) //If quantity of tickets is 0 then choice is refused.
		{
			System.out.println("Sold out please try again");
		}
		else
			choosetickettype("Child");
			break;
			
	default:
		System.out.println("Please try again what you entered is not an option");
		chooseadultorchild();//Should direct to price setting else if part
		break;
		
	case "s":case "S":
	{
		stats(); //Calling stats class 
		break;
	}
	case "r":case"R":
	{
		childQty=5; //Resetting quantity to 5. 
		adultQty=5;
		System.out.println("Tickets reprinted");
		break;
	}
	}
}
public static void menu() //Calling menu class from the main. 
	{
		System.out.println("Welcome to Hueston Station");
		System.out.println("You have chosen to travel to Belfast");
		System.out.println("Press 1 for adult ticket");
		System.out.println("Press 2 for child ticket");
		chooseadultorchild(); // Directing to user to choice of adult or child ticket by calling class. 
		menu();
	}
public static void menu2() //Calling menu class from the main. 
{
	
	System.out.println("Press 1 for adult ticket");
	System.out.println("Press 2 for child ticket");
	chooseadultorchild(); // Directing to user to choice of adult or child ticket by calling class. 
	
}


		public static void stats()
		{
			System.out.println("_____________________");
			System.out.println("Total Transactions:" + numTransactions); //Displaying number of tickets bought. 
			System.out.println( "Total Takings:" + "€" + totalTakings ); //Displaying sum amount of money given to machine. 
			System.out.println("Average Transaction Value " + "€" + currency.format(totalTakings/numTransactions)); // Displaying average amount of payment of any ticket.
			System.out.println("_____________________");
			
		}
		public static void more()
		{
			System.out.println("Do you want to buy more tickets?");
			System.out.println("Press 1 for Yes ");
			System.out.println("Press 2 for No ");
			
			
		}
	}
// can you choose multiple tickets maximum marks  i you don't do that you can
