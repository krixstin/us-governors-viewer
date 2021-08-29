import jdbc.dto.*;
import java.util.Scanner;
import jdbc.dao.*;

public class test {

	public static void main(String[] args) {
		UsGovDao test = new UsGovDao();
		
		test.getStates();
		
		//getInfo by State Code
		while(true) {
			try{
				System.out.println("\n<<< Enter State Code (ex: NY) >>>");
				Scanner scanner = new Scanner (System.in);
				String state = scanner.next();
				System.out.println(test.getInfo(state.toUpperCase()));
			}catch(Exception e) {
				e.getStackTrace();
				System.out.println("Please use a valid state code");
			}
		}
	}
}