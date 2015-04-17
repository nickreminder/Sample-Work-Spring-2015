// Nick Reminder
// nicholas.reminder@pomona.edu
// cs62 ps2 sun
// 2/2/15
import java.util.Random;
import java.util.Arrays;

public class Minimum {
	
	public static void main(String[] args) {
		int[] array = new int[20];
		assignRandom(array);
		System.out.println(Arrays.toString(array));
		System.out.println(findMinimumRec(array, 0, (array.length-1)));
	}
	
	public static int findMinimumRec(int[] array, int first, int last) {
		int middle = (first+last)/2;
		if ((first+1) == last||first == last) return Math.min(array[first], array[last]);
		else return Math.min((findMinimumRec(array, first, middle)), (findMinimumRec(array, (middle+1), last)));
	}
	
	public static void assignRandom(int[] array) {
		Random rand = new Random();
		for (int i=0; i<array.length; i++) {
			array[i] = rand.nextInt(50);
		}
	}
}
