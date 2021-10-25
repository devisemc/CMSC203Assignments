import java.io.IOException;

/**
 * 
 * @author Donovan deVise
 *
 */
public class ManagementCompany {
	//Fields
	private int MAX_PROPERTY = 5;
	private double mgmFeePer;
	private String name;
	private Property[] properties;
	private String taxID;
	private int MGMT_WIDTH = 10;
	private int MGMT_DEPTH = 10;
	private Plot plot;
	
	//Constructors
	public ManagementCompany()
	{
		name = taxID = "";
		plot = new Plot(0, 0, 10, 10);
		properties = new Property[MAX_PROPERTY];
	}
	public ManagementCompany(String name, String taxID, double mgmFee)
	{
		this.name = name;
		this.taxID = taxID;
		mgmFeePer = mgmFee;
		plot = new Plot(0, 0, 10, 10);
		properties = new Property[MAX_PROPERTY];
	}
	public ManagementCompany(String name, String taxID,  double mgmFee, int x, int y, int width, int depth)
	{
		this.name = name;
		this.taxID = taxID;
		mgmFeePer = mgmFee;
		plot = new Plot(0, 0, 10, 10);
	}
	public ManagementCompany(ManagementCompany otherCompany)
	{
		name = otherCompany.getName();
		taxID = otherCompany.getTaxID();
		mgmFeePer = otherCompany.getMgmFeePer();
		plot = otherCompany.getPlot();
	}
	//Methods
	public int addProperty(Property property)
	{
		if (property == null)
				return -2;
		if (!plot.encompasses(property.getPlot()))
			return -3;
		for (int i = 0; i < properties.length; i++)
		{
			if (properties[i] != null && property.getPlot().overlaps(properties[i].getPlot()))
				return -4;
			if (properties[i] == null)
			{
				Property propertyCopy = new Property(property);
				properties[i] = propertyCopy;
				return i;
			}
		}
		return -1;
	}
	public int addProperty(String name, String city, double rent, String owner)
	{
		return addProperty(new Property(name, city, rent, owner));
	}
	public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth)
	{
		return addProperty(new Property(name, city, rent, owner, x, y, width, depth));
	}
	public String displayPropertyAtIndex(int i)
	{
		return properties[i].toString();
	}
	public double maxRentProp()
	{
		double max = -1;
		for (int i = 0; i < properties.length; i++)
		{
			if (properties[i] != null && properties[i].getRentAmount() > max)
				max = properties[i].getRentAmount();
		}
		return max;
	}
	public int maxRentPropertyIndex()
	{
		double max = -1;
		int index = 0;
		for (int i = 0; i < properties.length; i++)
		{
			if (properties[i] != null && properties[i].getRentAmount() > max)
			{
				index = i;
				max = properties[i].getRentAmount();
			}
		}
		return index;
	}
	public String toString()
	{
		String total = "";
		for (int i = 0; i < properties.length; i++)
		{
			if (properties[i] != null)
				total += properties[i].toString() + "\n";
		}
		return total;
	}
	public double totalRent()
	{
		double total = 0;
		for (int i = 0; i < properties.length; i++)
		{
			if (properties[i] != null)
				total += properties[i].getRentAmount();
		}
		return total;
	}
	//Getters
	public int getMAX_PROPERTY()
	{
		return MAX_PROPERTY;
	}
	public double getMgmFeePer()
	{
		return mgmFeePer;
	}
	public String getName()
	{
		return name;
	}
	public Property[] getProperties()
	{
		return properties;
	}
	public String getTaxID()
	{
		return taxID;
	}
	public Plot getPlot()
	{
		return plot;
	}
}
