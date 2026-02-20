package quantitymeasurementapp;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		FeetEquality feet = new FeetEquality(1);
		FeetEquality feet2 = new FeetEquality(5);
		
		System.out.println(feet.equals(feet2));
	}
}
