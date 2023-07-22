
import java.util.Random;
public class ShowCaseGame 
{
	private String itemName;
	private int itemPrice;
	//purpose of this and the instance variable above is for storing of the values from the prizeList.txt file.
	public ShowCaseGame()
	{	
		this.itemName="";
		this.itemPrice=0;
	}
	public ShowCaseGame(String iN, int iP)
	{	
		this.setItemName(iN);
		this.setItemPrice(iP);
	}
	public String getItemName()
	{
		return this.itemName;
	}
	public void setItemName(String iN)
	{
	if(iN!=null)
	{	
		this.itemName=iN;
	}
	else
	{	
		this.itemName="invalid";
	}
		
	}
	
	public int getItemPrice()
	{
		return this.itemPrice;
	}
	public void setItemPrice(int iP)
	{	
		if(iP>0)
		{
			this.itemPrice=iP;
		}
		else
		{
			this.itemPrice=0;
		}
	}

	public boolean equals(ShowCaseGame sCG)
	{
		return sCG!=null && this.itemName.equals(sCG.getItemName()) && this.itemPrice==sCG.getItemPrice();
	}
	public String toString()
	{
		return "Item Name: "+this.itemName+". Item Price: "+this.itemPrice;
	}
}
