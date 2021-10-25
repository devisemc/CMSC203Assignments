/**
 * 
 * @author Donovan deVise
 *
 */
public class Property{
	//Fields
	private String city, owner, propertyName;
	private double rentAmount;
	private Plot plot;
	
	//Constructors
	public Property()
	{
		city = owner = propertyName = "";
		rentAmount = 0;
		plot = new Plot();
	}
	public Property(Property p)
	{
		city = p.getCity();
		owner = p.getOwner();
		propertyName = p.getPropertyName();
		rentAmount = p.getRentAmount();
		plot = p.getPlot();
	}
	public Property(String propertyName, String city, double rentAmount, String owner)
	{
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount;
		this.owner = owner;
	}
	public Property(String propertyName, String city, double rentAmount, String owner, int x, int y, int width, int depth)
	{
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount;
		this.owner = owner;
		plot = new Plot(x, y, width, depth);
	}
	
	public String toString()
	{
		return ("Property Name: " + propertyName + "\nLocated in " + city + "\nBelonging to: " + owner + "\nRent Amount: " + rentAmount);
	}
	//Getters
	public String getCity()
	{
		return city;
	}
	public String getOwner()
	{
		return owner;
	}
	public String getPropertyName()
	{
		return propertyName;
	}
	public double getRentAmount()
	{
		return rentAmount;
	}
	public Plot getPlot()
	{
		return plot;
	}
	
	//Setters
	public Plot setPlot(int x, int y, int width, int depth)
	{
		return new Plot(x, y, width, depth);
	}
	public void setCity(String city)
	{
		this.city = city;
	}
	public void setOwner(String owner)
	{
		this.owner = owner;
	}
	public void setPropertyName(String propertyName)
	{
		this.propertyName = propertyName;
	}
	public void setRentAmount(double rentAmount)
	{
		this.rentAmount = rentAmount;
	}
}
