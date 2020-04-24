package shuwei.improve.accu;

public class CarryMulti {

	public static void main(String[] args) {
		System.out.println(carryMul(2, "111"));
	}

	// 将numberStr按照radix进位，算出10进制数
	public static int carryMul(int radix, String numberStr) {
		int total = 0;
		for (int index = 0; index < numberStr.length(); index++) {
			int middle = Integer.parseInt( numberStr.charAt(index) + "");
			total = total * radix + middle;
		}
		return total;
	}
}
