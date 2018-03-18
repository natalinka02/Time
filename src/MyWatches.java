
public class MyWatches {

	public static void main(String[] args) {
		Watches casio = new Watches();
		
		casio.setDate(2018, 3, 16);
		
		casio.tickTock(345600);
		
		System.out.println(casio.getDate());
	}
}
