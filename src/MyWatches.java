
import java.io.*;
import java.util.*;

public class MyWatches {

	public static void main(String[] args) {
		Watches casio = new Watches();
		Console console = System.console();
		
		System.out.println("Congratulation, you bought a new watches");
		
		String year = console.readLine("please, enter year: ");
		String month = console.readLine("please, enter month: ");
		String day = console.readLine("please, enter day: ");
		
		String hours = console.readLine("please, enter hours: ");
		String minutes = console.readLine("please, enter minutess: ");
		String seconds = console.readLine("please, enter seconds: ");
		
		casio.setDate(Integer.parseInt(year),
				Integer.parseInt(month),
				Integer.parseInt(day));
		
		casio.setTime(Integer.parseInt(hours),
				Integer.parseInt(minutes),
				Integer.parseInt(seconds));
		
		System.out.println("Your date/time at your watches is:");
		System.out.println(casio.getDate() + " " + casio.getTime());
		
		String advanceSeconds = console.readLine("please, enter seconds to advance: ");
		casio.tickTock(Integer.parseInt(advanceSeconds));
		System.out.println("Your date/time at your watches is:");
		System.out.println(casio.getDate() + " " + casio.getTime());
	}
}
