package pack;

public class Load {

	
	public static void loading(int loadLength, int maxValue, int currentValue) {
		if (currentValue > maxValue) {
			throw new Error("Current value of " + currentValue + " is higher than maximum value of " + maxValue);
		}
		
		//if percentage would remain unchanged
		//removes unnecessary prints
		final double PERCENTAGE = ((int) Math.ceil(1000.0 * currentValue / maxValue));
		final double PREV_PERCENTAGE = ((int) Math.ceil(1000.0 * (currentValue - 1) / maxValue));
		if (PERCENTAGE == PREV_PERCENTAGE) {
			return;
		}
		
		System.out.print("[" + repeat("=", (int) Math.ceil(currentValue * loadLength / (1.0 * maxValue)))); 
		System.out.print(repeat(" ", loadLength - (int) Math.ceil(currentValue * loadLength / (1.0 * maxValue))) + "]");
		System.out.print(" " + PERCENTAGE / 10.0 + "%");
		System.out.print("\r");
		
		if (PERCENTAGE == 1000) {
			System.out.print("[" + repeat(" ", loadLength) + "]   \t  \t\r");
		}
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private static String repeat(String str, int num) {
		String output = "";
		for (int i = 0; i < num; i++) {
			output += str;
		}
		return output;
	}

}
