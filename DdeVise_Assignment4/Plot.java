/**
 * 
 * @author Donovan deVise
 *
 */
public class Plot {
	//Fields
	private int x, y, width, depth;
	
	//Constructors
	public Plot()
	{
		x = y = 0;
		width = depth = 1;
	}
	public Plot(Plot p)
	{
		x = p.getX();
		y = p.getY();
		width = p.getWidth();
		depth = p.getDepth();
	}
	public Plot(int x, int y, int width, int depth)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.depth = depth;
	}
	
	boolean encompasses(Plot plot)
	{
		if ((x <= plot.getX() && plot.getX() <= (x + width)) && (x <= plot.getX() + plot.getWidth() && plot.getX() + plot.getWidth() <= (x + width) && (y <= plot.getY() + plot.getDepth() && plot.getY() + plot.getDepth() <= (y + depth)) && (y <= plot.getY() && plot.getY() <= (y + depth))))
			return true;
		return false;
	}
	boolean overlaps(Plot plot)
	{
		if (x + width <= plot.getX())
            return false;
        if (x >= plot.getX() + plot.getWidth())
            return false;
        if (y + depth <= plot.getY())
            return false;
        if (y >= plot.getY() + plot.getDepth())
            return false;
        return true;
			
	}
	public String toString()
	{
		return ("Upper left: (" + x + "," + y + "); Width: " + width + " Depth: " + depth);
	}
	
	//Getters
	public int getX()
	{
		return x;
	}
	public int getY()
	{
		return y;
	}
	public int getWidth()
	{
		return width;
	}
	public int getDepth()
	{
		return depth;
	}
	
	//Setters
	public void setX(int x)
	{
		this.x = x;
	}
	public void setY(int y)
	{
		this.y = y;
	}
	public void setWidth(int width)
	{
		this.width = width;
	}
	public void setDepth(int depth)
	{
		this.depth = depth;
	}
}
