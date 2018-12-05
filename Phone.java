
public class Phone{
	private String areaCode;
	private String number;
	
	public static final String DEFAULT_AC = "000";
	public static final String DEFAULT_NUM = "0000000";
	public static final int VALID_PH_NUM_LEN = 7;
	public static final int VALID_AC_NUM_LEN = 3;
	
	public Phone() {
		number =  DEFAULT_NUM;
		areaCode = DEFAULT_AC;
	}
	
	public Phone(String ac, String num) {
		if(!setPhNum(num))
			number = DEFAULT_NUM;
		if(!setAC(ac))
			areaCode = DEFAULT_AC;
	}
	
	public boolean setPhNum(String num) {
		if(!validPhNumber(num))
			return false;
		number = num;
		return true;
	}
	
	public boolean setAC(String ac) {
		if(!validAC(ac))
			return false;
		areaCode = ac;
		return true;
	}
	
	public boolean setBoth(String ac, String num) {
		boolean retValNum, retValAC;
		
		retValNum = setPhNum(num);
		retValAC = setAC(ac);
		
		return retValNum && retValAC;
	}
	
	public String getAreaCode() {
		return areaCode;
	}
	
	public String getNumber() {
		return number;
	}
	
	public String toString() {
		String result;
		
		result = "(" + areaCode + ")" + number.substring(0,3) + "-" + number.substring(3,7);
		return result;
	}
	
	public void showPhone() {
		System.out.println(toString());
	}
	
	public String dialing() {
		return "Now dialing " + toString() + "\n";
	}
	
	public String redialing(int numTimes) {
		int k;
		
		String retStr = "Trying number " + numTimes + " times...\n";
		
		for(k = 0; k < numTimes; k++)
			retStr += dialing();
		retStr += "done.\n";
		
		return retStr;
	}
	
	protected static boolean isNumber(String s) {
		for(int k = 0; k < s.length(); k++)
			if(!Character.isDigit(s.charAt(k)))
				return false;
		return true;
	}
	
	private static boolean validPhNumber(String s) {
		if(isNumber(s) && (s.length() == VALID_PH_NUM_LEN))
			return true;
		return false;
	}
	
	private static boolean validAC(String s) {
		if(isNumber(s) && (s.length() == VALID_AC_NUM_LEN))
			return true;
		return false;
	}
}