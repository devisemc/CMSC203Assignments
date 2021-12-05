// Imports
import java.util.ArrayList;

/**
 * Class to represent a Beverage Shop, implements BevShopInterface
 * @author Donovan deVise
 *
 */
public class BevShop implements BevShopInterfce {
	// Instance Variables
	private int alcoholCount;
	private ArrayList<Order> orders = new ArrayList<Order>();
	
	/**
	 * Adds a new order to list
	 * 
	 * @param time
	 * @param day
	 * @param customerName
	 * @param customerAge
	 */
	public void startNewOrder(int time, DAY day, String customerName, int customerAge) 
	{
		orders.add(new Order(time, day, new Customer(customerName, customerAge)));
	}
	
	/**
	 * Adds a coffee to current order
	 * 
	 * @param bevName
	 * @param size
	 * @param extraShot
	 * @param extraSyrup
	 */
	public void processCoffeeOrder(String bevName, SIZE size, boolean extraShot, boolean extraSyrup) 
	{
		getCurrentOrder().addNewBeverage(bevName, size, extraShot, extraSyrup);
	}
	
	/**
	 * Adds an alcohol to current order
	 * 
	 * @param bevName
	 * @param size
	 */
	public void processAlcoholOrder(String bevName, SIZE size) 
	{
		getCurrentOrder().addNewBeverage(bevName, size);
	}
	
	/**
	 * Adds a smoothie to current order
	 * 
	 * @param bevName
	 * @param size
	 * @param numOfFruits
	 * @param addProtien
	 */
	public void processSmoothieOrder(String bevName, SIZE size, int numOfFruits, boolean addProtien) 
	{
		getCurrentOrder().addNewBeverage(bevName, size, numOfFruits, addProtien);
	}
	
	/**
	 * Checks if order of certain number is in order list
	 * 
	 * @param orderNo
	 * 
	 * @return index of order with matching order number, or -1 if not found
	 */
	public int findOrder(int orderNo) 
	{
		for (int i = 0; i < orders.size(); i++)
		{
			if (orders.get(i).getOrderNo() == orderNo)
				return i;
		}
		return -1;
	}
	
	/**
	 * Gets order price of order at index
	 * 
	 * @param orderNo
	 * 
	 * @return order price of order at index
	 */
	public double totalOrderPrice(int orderNo) {
		return orders.get(findOrder(orderNo)).calcOrderTotal();
	}

	/**
	 * Gets total price of all orders
	 * 
	 * @return total price of all orders
	 */
	public double totalMonthlySale() {
		double total = 0;
		for (int i = 0; i < orders.size(); i++)
		{
			total += orders.get(i).calcOrderTotal();
		}
		return total;
	}

	/**
	 * Sorts all orders by order number
	 */
	public void sortOrders() 
	{
		int minIndex;
		 
        for (int i = 0; i < orders.size() - 1; i++)
        {
            minIndex = i;
            for (int j = i + 1; j < orders.size(); j++)
                if (orders.get(j).getOrderNo() < orders.get(minIndex).getOrderNo())
                	minIndex = j;
 
            Order temp = orders.get(minIndex);
            orders.set(minIndex,  orders.get(i));
            orders.set(i, temp);
        }
	}
	
	/**
	 * Gets order at index in order list
	 * 
	 * @param index
	 * 
	 * @return order at index in order list
	 */
	public Order getOrderAtIndex(int index) {
		return orders.get(index);
	}
	
	/**
	 * Creates string representation of Beverage Shop information
	 * 
	 * @return string representation of Beverage Shop information
	 */
	public String toString()
	{
		String out = "Beverage Shop";
		for (int i = 0; i < orders.size(); i++)
		{
			out += '\n' + orders.get(i).toString();
		}
		out += "\nTotal Monthly Sale: " + totalMonthlySale();
		return out;
	}
	
	/**
	 * Checks if time is between minimum and maximum time
	 * 
	 * @param time
	 * 
	 * @return true if time is between min and max time
	 */
	public boolean validTime(int time) 
	{
		return MIN_TIME <= time && time <= MAX_TIME;
	}
	
	/**
	 * Checks if order is eligible for more alcoholic drinks
	 * 
	 * @return true if order is eligible for more alcoholic drinks, false otherwise
	 */
	public boolean eligibleForMore() 
	{
		return getCurrentOrder().findNumOfBeveType(TYPE.ALCOHOL) < MAX_ORDER_FOR_ALCOHOL;
	}
	
	/**
	 * Checks if age is valid for alcoholic drinks
	 * 
	 * @param age
	 * 
	 * @return true if age is valid, false otherwise
	 */
	public boolean validAge(int age) 
	{
		return age > MIN_AGE_FOR_ALCOHOL;
	}

	/**
	 * Getter method for MAX_ORDER_FOR_ALCOHOL
	 * 
	 * @return
	 */
	public int getMaxOrderForAlcohol() {
		return MAX_ORDER_FOR_ALCOHOL;
	}
	
	/**
	 * Getter method for MIN_AGE_FOR_ALCOHOL
	 * 
	 * @return
	 */
	public int getMinAgeForAlcohol() {
		return MIN_AGE_FOR_ALCOHOL;
	}

	/**
	 * Gets order at end of order list
	 * 
	 * @return order at end of order list
	 */
	public Order getCurrentOrder() {
		return orders.get(orders.size() - 1);
	}

	/**
	 * Gets number of alcoholic drinks in current order
	 * 
	 * @return number of alcoholic drinks in current order
	 */
	public int getNumOfAlcoholDrink() {
		return getCurrentOrder().findNumOfBeveType(TYPE.ALCOHOL);
	}

	/**
	 * Checks if number of fruits is maximum
	 * 
	 * @param numOfFruits
	 * 
	 * @return true if number of fruits is maximum, false otherwise
	 */
	public boolean isMaxFruit(int numOfFruits) {
		return numOfFruits > 5;
	}

	/**
	 * Gets total number of orders
	 * 
	 * @return total number of orders
	 */
	public int totalNumOfMonthlyOrders() {
		return orders.size();
	}
	
	/**
	 * Getter method for order list
	 * 
	 * @return
	 */
	public ArrayList<Order> getOrders()
	{
		return orders;
	}
		
	/**
	 * Getter method for alcoholCount
	 * 
	 * @return
	 */
	public int getAlcoholCount() {
		return alcoholCount;
	}

	/**
	 * Setter method for alcoholCount
	 * 
	 * @param alcoholCount
	 */
	public void setAlcoholCount(int alcoholCount) {
		this.alcoholCount = alcoholCount;
	}
}
