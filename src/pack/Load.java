package pack;

public class Load {

	
	public static void loading(int loadLength, int maxValue, int currentValue) {
		//if percentage would remain unchanged
		//removes unnecessary prints
		if (((int) Math.ceil(1000.0 * currentValue / maxValue)) == ((int) Math.ceil(1000.0 * (currentValue - 1) / maxValue))) {
			return;
		}
		
		System.out.print("[" + repeat("=", (int) Math.ceil(currentValue * loadLength / (1.0 * maxValue)))); 
		System.out.print(repeat(" ", 20 - (int) Math.ceil(currentValue * loadLength / (1.0 * maxValue))) + "]");
		System.out.print(" " + ((int) Math.ceil(1000.0 * currentValue / maxValue)) / 10.0 + "%");
		System.out.print("\r");
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
