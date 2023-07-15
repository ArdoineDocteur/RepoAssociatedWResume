//Ardoine Docteur
import java.util.*;
public class SheepProperties implements Comparable<SheepProperties>
{	private String name;
	private Integer shearingTime;
	private Integer arrivalTime;
	
	
	public int compareTo(SheepProperties sP)
	{	Integer count=this.getShearingTime();
	Integer check=this.getArrivalTime()+(Integer)count;
		if(sP==null || sP.getArrivalTime()==0)
	{	
		return 1;
	}	
		else if(check.compareTo(sP.getArrivalTime())>0)
		{	
//			return this.name.compareTo(sP.getName()); //<-- Either this one yields the correct schedule, or the one below yields the correct schedule.
			return this.getShearingTime().compareTo(sP.getShearingTime());
		}
		else
		{
			return (check).compareTo(sP.getArrivalTime());
		}
	}
	
	
	public SheepProperties()
	{	this.name="";
		this.shearingTime=0;
		this.arrivalTime=0;
	}
	public SheepProperties(String aN, Integer sT, Integer aT)
	{	this.setName(aN);
		this.setShearingTime(sT);
		this.setArrivalTime(aT);
	}
	
	public String getName()
	{
		return this.name;
	}
	public void setName(String aN)
	{	if(aN!=null)
	{
		this.name=aN;
	}
	else
	{
		this.name="";
	}
		
	}
	public Integer getShearingTime()
	{
		return this.shearingTime;
	}
	public void setShearingTime(Integer sT)
	{	if(sT>0)
	{
		this.shearingTime=sT;
	}
	else
	{
		this.shearingTime=0;
	}
		
	}
	public Integer getArrivalTime()
	{
		return this.arrivalTime;
	}
	public void setArrivalTime(Integer aT)
	{	if(aT>0)
	{
		this.arrivalTime=aT;
	}
	else
	{
		this.arrivalTime=0;
	}
		
	}
	public boolean equals(SheepProperties aS)
	{
		return aS!=null && this.name.equals(aS.getName()) && this.arrivalTime.equals(aS.getArrivalTime()) && this.shearingTime.equals(aS.getShearingTime());
	}
	public String toString()
	{
		return "Name: "+this.name+"\t"+"Shearing Time: "+this.shearingTime+"\t"+"Arrival Time: "+this.arrivalTime;
	}
	

}
