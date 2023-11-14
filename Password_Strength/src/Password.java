import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;
class Password{ //CLASS PASSWORD
	static int count1, count2, count3, count4; // VARIABLES TO CHECK THE SECURITY LEVEL OF THE PASSWORD
	static String p, z, url;
	public static void main(String[]args)throws IOException, SQLException{
		String url;//LOCAL SQL SERVER ADDRESS HAS TO BE ADDED
		BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("\t\t\t\t User Registration");
		System.out.println("Enter User Name");
		z = b.readLine(); // Z IS A VARIABLE FOR USERNAME
		do {
			System.out.println("Enter your password");
			p = b.readLine(); // P IS A VARIABLE FOR PASSWORD
			if(p.length()<8) {
				System.out.println("Enter atleast 8 characters");
			}
		}while(p.length()<8);
		// CONNECTION TO THE SQL DATABASE NEEDS TO BE ESTABLISHED ON THE LOCAL SERVER
		Random r = new Random();
		try {
			if(p.length()>=8) {
				for(int i=0; i<p.length(); i++) { // CHECKING IF PASSWORD IS STRONG OR NOT
					char a = p.charAt(i);
					boolean u = Character.isUpperCase(p.charAt(i));
					if(u=true) {
						count1++;
					}
					boolean l = Character.isLowerCase(p.charAt(i));
					if(l=true) {
						count2++;
					}
					boolean n = Character.isDigit(p.charAt(i));
					if(n=true) {
						count3++;
					}
					String spl = "!@#$%^&*()_+";
					char s = (p.charAt(i));
					for(int j=0; j<spl.length(); j++) {
						char sp = spl.charAt(j);
						if(s==sp) {
						count4++;
						}
					}
				}
				if(count1>=2 &&  count2>=2 && count3>=2 && count4>=2) {
					System.out.println("Your Password is strong");
					System.exit(0);
				}
				else { // SUGGESTING A STRONG PASSWORD IF IT IS NOT STRONG
					String a1 = "ABCDEFGHIJKLMNOPQRSTUVXYZ";
					String a2 = "qwertyuiopasdfghjklzxcvbnm";
					String a3 = "1234567890";
					String a4 = "!@#$%^&*_+";
					System.out.print("Password is not strong\nSuggested Password \t");
					for(int i=0; i<3; i++) {
						int b1 = r.nextInt(27);
						System.out.print("");
						System.out.print(a1.charAt(b1));
						int b2 = r.nextInt(27);
						System.out.print(a2.charAt(b2));
						int b3 = r.nextInt(10);
						System.out.print(a3.charAt(b3));
						int b4 = r.nextInt(10);
						System.out.print(a4.charAt(b4));
					}
				}
			}
		}
		catch(Exception e) { //THROWING IOExceptions
			
		}
		
	}
	
}