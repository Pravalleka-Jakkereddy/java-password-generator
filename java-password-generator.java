import java.util.*;

class PasswordGenerator 
{

	static String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    	static String lower = "abcdefghijklmnopqrstuvwxyz";
    	static String digits = "0123456789";
    	static String special = "!@#$%^&*";

    	public static String generatePassword(int length, boolean useUpper, boolean useLower,
                                          boolean useDigits, boolean useSpecial) 
	{

        	String allChars = "";

        	if (useUpper) allChars += upper;
        	if (useLower) allChars += lower;
        	if (useDigits) allChars += digits;
        	if (useSpecial) allChars += special;

        	if (allChars.length() == 0) 
		{
            		return "Invalid selection!";
        	}

        	Random rand = new Random();
        	char[] password = new char[length];

        	for (int i = 0; i < length; i++) 
		{
            		int index = rand.nextInt(allChars.length());
            		password[i] = allChars.charAt(index);
        	}


        	for (int i = 0; i < length; i++) 
		{
            		int j = rand.nextInt(length);
            		char temp = password[i];
            		password[i] = password[j];
            		password[j] = temp;
        	}

        	return new String(password);
    	}

    	public static String checkStrength(String password) 
	{

    		boolean hasUpper = false;
    		boolean hasLower = false;
    		boolean hasDigit = false;
    		boolean hasSpecial = false;

    		for (int i = 0; i < password.length(); i++) 
		{
        		char ch = password.charAt(i);

        		if (ch >= 'A' && ch <= 'Z') 
				hasUpper = true;
        		else if (ch >= 'a' && ch <= 'z') 
				hasLower = true;
        		else if (ch >= '0' && ch <= '9') 
				hasDigit = true;
        		else 
				hasSpecial = true;
    		}		

    		if (password.length() >= 8 && hasUpper && hasLower && hasDigit && hasSpecial)
        		return "Strong 💪";

    		else if (password.length() >= 6 && (hasUpper || hasLower) && hasDigit)
        		return "Medium 👍";

    		else
        		return "Weak ⚠";
	}

    	public static void main(String[] args) 
	{

        	Scanner sc = new Scanner(System.in);

        	System.out.print("Enter password length: ");
        	int length = sc.nextInt();

        	System.out.print("Include Uppercase? (true/false): ");
        	boolean u = sc.nextBoolean();

        	System.out.print("Include Lowercase? (true/false): ");
        	boolean l = sc.nextBoolean();

        	System.out.print("Include Digits? (true/false): ");
        	boolean d = sc.nextBoolean();

        	System.out.print("Include Special Characters? (true/false): ");
        	boolean s = sc.nextBoolean();

        	String password = generatePassword(length, u, l, d, s);

        	System.out.println("\nGenerated Password: " + password);
        	System.out.println("Strength: " + checkStrength(password));
    	}
}