// Nicholas Reminder
// PS3 cs62
// 2-14-15

import java.util.Arrays;

public class QuickSortInt {

    public static void qsort(int[] a) {
        quickSort(a, 0, a.length - 1, 0);
    }

    private static void quickSort(int a[], int from, int to, int lev) {
        if (from >= to) {
            return;
        }

        // I decided on choosing the median of the first, middle, and last
        // element as the pivot. Wikipedia said this was a reasonable method,
        // as it's convenient for sorted/reverse-sorted inputs, and is a better
        // estimate of the middle than picking an element at random.
        
        int first = a[from]; int last = a[to]; int middle = a[(from+to)/2];
        int[] choices = {first, middle, last};
        Arrays.sort(choices);
        int p = choices[1];

        int[] three = {0, 0, 0};  // to hold values from partition method

        partition(p, from, to, a, three);

        int nsp = three[0];  // # of elements smaller than p (see partition)
        int nep = three[1];  // # of elements equal to p
        int ngp = three[2];  // # of elements greater than p

        
        // Recursive steps are self-explanatory, especially from the pictures
        // depicting the Quicksort method. Leave the elements equal to p alone,
        // and recursively call Quicksort on the elements less than and greater
        // than p.
        
        quickSort(a, from, from+nsp, lev+1);
        quickSort(a, to-ngp, to, lev+1);

    }
    
    private static void partition(int p, int from, int to,
                                 int[] a, int[] three) {
    	
    	int holder=from;
		for (int i=from; i<=to; i++) {
			if (a[i] < p) {
				swap(a, holder, i);
				holder++;
				three[0]++;
			}
		}
		for (int i=holder; i<=to; i++) {
			if (a[i] == p) {
				swap(a, holder, i);
				holder++;
				three[1]++;
			}
		}
		three[2] = to-from-three[0]-three[1];
    }
    
    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    
}
