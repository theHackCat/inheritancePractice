
public class PhoneWX extends Phone{
	
	private String extension;
	
	public static final String DEFAULT_EXT = "00";
	public static final int VALID_EXT_LEN = 2;
	
	public PhoneWX() {
		super();
		extension = DEFAULT_EXT;
	}
	
	public PhoneWX(String ac, String num, String ext) {
		super(ac, num);
		
		if(!setExt(ext)) 
			extension = DEFAULT_EXT;
	}
	
	public boolean setExt(String ext) {
		if(!validExt(ext))
			return false;
		extension = ext;
		return true;
	}
	
	public boolean setAll(String ac, String num, String ext) {
		boolean retValSetBoth, retValSetExt;
		
		retValSetBoth = setBoth(ac, num);
		
		retValSetExt = setExt(ext);
		
		return retValSetBoth && retValSetExt;
	}
	
	public String getExt() {
		return extension;
	}
	
	public String toString() {
		return super.toString() + " ext: " + extension;
	}
	
	public void showPhone() {
		System.out.println(toString());
	}
	
	public void showPhoneWithoutExtension() {
		System.out.println(super.toString());
	}
	
	public String dialing() {
		String retStr;
		
		retStr = super.dialing();
		retStr += "    (" + toString() + ")\n";
		
		return retStr;
	}
	
	public String redialing() {
		String retStr;
		
		retStr = "calling extension " + toString() + " only once...\n";
		retStr += redialing(1);
		return retStr;
	}
	
	private static boolean validExt(String s) {
		if(isNumber(s) && (s.length() == VALID_EXT_LEN))
			return true;
		return false;
	}

}
