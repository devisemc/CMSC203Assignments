public class HolidayBonus {
	/**
	 * @author Donovan deVise
	 * @param data
	 * @param high
	 * @param low
	 * @param other
	 * @return
	 */
	static double[] calculateHolidayBonus(double[][] data, double high, double low, double other)
	{
		// Find largest amount of columns
		int largest = 0;
		for (int i = 0; i < data.length; i++)
		{
			if (data[i].length > largest)
				largest = data[i].length;
		}
		double[] arr = new double[data.length];
		
		// Fill arr with baseline values, only adjust the highs and lows
		for (int i = 0; i < arr.length; i++)
			arr[i] = other * data[i].length;
		
		// Setup Vars
		double min, max;
		int index;
		for (int col = 0; col < largest; col++)
		{
			// FIND MINIMUM IN COLUMN
			min = Double.MAX_VALUE;
			index = 0;
			for (int i = 0; i < data.length; i++)
			{
				if (col < data[i].length)
				{
					if (data[i][col] < min)
					{
						min = data[i][col];
						index = i;
					}
				}
			}
			// Replace default-set value with low value
			arr[index] += low - other;
			// FIND MAXIMUM IN COLUMN
			max = Double.MIN_VALUE;
			index = 0;

			for (int i = 0; i < data.length; i++)
			{
				if (col < data[i].length)
				{
					if (data[i][col] > max)
					{
						max = data[i][col];
						index = i;
					}
				}
			}
			// Replace default-set value with high value
			arr[index] += high - other;
		}
		return arr;
	}
	/**
	 * @author Donovan deVise
	 * @param data
	 * @param high
	 * @param low
	 * @param other
	 * @return
	 */
	static double calculateTotalHolidayBonus(double[][] data, double high, double low, double other)
	{
		double[] arr = calculateHolidayBonus(data,high,low,other);
		
		double total = 0;
		for (int i = 0; i < arr.length; i++)
		{
			total += arr[i];
		}
		
		return total;
	}
}
