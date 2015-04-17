// Nicholas Reminder
// PS3 cs62
// 2-14-15

public class MergeSortGeneric {

	public static <T extends Comparable<T>> void msort(T[] elems) {
		T aux[] = (T[])elems.clone();
		mergeSort(aux, elems, 0, elems.length);
	}
	
	private static <T extends Comparable<T>> void mergeSort(T src[], T dest[], int low, int high) {
		if ((high - low) < 2) {
			return;
		}
		
		int mid = (low + high) / 2;
		mergeSort(dest, src, low, mid);
		mergeSort(dest, src, mid, high);
		
		if (src[mid - 1].compareTo(src[mid]) <= 0) {
			System.arraycopy(src, low, dest, low, high-low);
			return;
		}
		
		for (int i = low, p = low, q = mid; i < high; i++) {
			if ((q >= high) || (p < mid && src[p].compareTo(src[q]) <= 0)) {
				dest[i] = src[p++];
			}
			else {
				dest[i] = src[q++];
			}
		}
	}
}
