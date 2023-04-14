package vtiger.Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPracticeTest 
{
	@Test(dataProvider = "getData")
	public void addToCart(String name, int price, int qty, String color, boolean isAvailable)
	{
		System.out.println("-----"+name+" "+price+" "+qty+" "+color+" "+isAvailable+"-----");
	}
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data = new Object[2][5];//first array specifies row, second array specified cell i.e 2 rows of data sets with 5 different details
		data[0][0]="Samsung";
		data[0][1]=1000;
		data[0][2]=12;
		data[0][3]="Black";
		data[0][4]=true;
		
		data[1][0]="Iphone";
		data[1][1]=2000;
		data[1][2]=5;
		data[1][3]="White";
		data[1][4]=false;
		
		return data;
		
	}
	
	@Test(dataProvider = "getLaptopdetails")
	public void addToWishlist(String brand, int price, int qty, String color)
	{
		System.out.println(brand+" "+price+" "+qty+" "+color);
	}
	
	@DataProvider
	public Object[][] getLaptopdetails()
	{
		Object[][] data = new Object[3][4];
		
		data[0][0]="Lenovo";
		data[0][1]=1000;
		data[0][2]=100;
		data[0][3]="Red";
		
		data[1][0]="HP";
		data[1][1]=1200;
		data[1][2]=200;
		data[1][3]="Orange";
		
		data[2][0]="Azus";
		data[2][1]=1500;
		data[2][2]=250;
		data[2][3]="Black";
		
		return data;
	}

}
