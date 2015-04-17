// Nick Reminder
// nicholas.reminder@pomona.edu
// cs62 ps2 sun
// 2/3/15

// My implementation of partition is Theta(2n) in the worst case. The first
// for loop swaps all values less than p to the left side of the list, incrementing
// the index at which to swap to ("holder") each time. The worst thing for time
// would be for the first loop to make no swaps (every element in the array >= p) 
// as the second loop starts at the index that the holder leaves off at. 
// This first loop checks each element in the array once, and if the second loop starts
// with holder==0, the second loop will check each element in the array once. This
// leads to a worst-case of runnning in Theta(2n) [=Theta(n)] time. The swap method
// runs in constant time, so it does not impact the Theta running time.

import java.util.Arrays;

public class Partition {
	
	public static void main(String[] args) {
		int[] M1 = {5,6,3,5,8,7,6,5,9,2};
		int[] M2 = {7,6,8,9,2,3,1,5,5,5};
		int[] M3 = {2,3,1,7,9,8};
		System.out.println("Here are the arrays before partitioning:");
		System.out.println(Arrays.toString(M1) + "\n" + Arrays.toString(M2) + "\n" + Arrays.toString(M3));
		partition(5, M1); partition(5, M2); partition(5, M3);
		System.out.println("Here they are after partitioning:");
		System.out.println(Arrays.toString(M1) + "\n" + Arrays.toString(M2) + "\n" + Arrays.toString(M3));
	}
	
	public static void partition(int p, int[] M) {
		int holder=0;
		for (int i=0; i<M.length; i++) {
			if (M[i] < p) {
				swap(M, holder, i);
				holder++;
			}
		}
		for (int i=holder; i<M.length; i++) {
			if (M[i] == p) {
				swap(M, holder, i);
				holder++;
			}
		}
	}
	
	public static void swap(int[] M, int lIndex, int rIndex) {
		int holder = M[lIndex];
		M[lIndex] = M[rIndex];
		M[rIndex] = holder;
	}
		
}
