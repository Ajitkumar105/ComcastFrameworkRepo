package practice;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

public class DemoTest {
	
public static void main(String[] args) {
	
	String s="Madam";
	
	String rev="";
	char a[]=     s.toCharArray();
	
	for(int i=a.length-1;i>=0;i--)
	{
		rev=rev+s.charAt(i);
	}
	
	if (s.toLowerCase().equals(rev.toLowerCase())) {
		
		System.out.println("String is Palindrome="+rev);
		
	}
	else {
		
		System.out.println("String is not Palindrome"+rev);
		}
	}

	
	
	
}


