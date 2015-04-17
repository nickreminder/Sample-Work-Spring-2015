// Nicholas Reminder
// PS3 cs62
// 2-14-15

import java.util.*;

public class QuickSortGeneric {

	public static <T extends Comparable<T>> void qsort(T[] elems) {
		quickSort(elems, 0, elems.length-1, 0);
	}
	
	private static <T extends Comparable<T>> void quickSort(T[] a, int from, int to, int lev) {
        if (from >= to) {
            return;
        }

        // In the generic version, I simply use the
        // first element as the pivot.
        
        T p = a[from];

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
    
    private static <T extends Comparable<T>> void partition(T p, int from, int to,
                                 							T[] a, int[] three) {
    	int holder=from;
		for (int i=from; i<=to; i++) {
			if (a[i].compareTo(p) < 0) {
				swap(a, holder, i);
				holder++;
				three[0]++;
			}
		}
		for (int i=holder; i<=to; i++) {
			if (a[i].compareTo(p) == 0) {
				swap(a, holder, i);
				holder++;
				three[1]++;
			}
		}
		three[2] = to-from-three[0]-three[1];
    }
    
    private static <T> void swap(T[] a, int i, int j) {
        T temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    
    public static <T> void qsort(T[] data, Comparator<T> cmp) {
    	quickSort(data, 0, data.length-1, cmp);
    }
    
    public static <T> void quickSort(T[] data, int from, int to, Comparator<T> cmp) {
    	
    	if (from >= to) {
            return;
        }   
        T p = data[from];

        int[] three = {0, 0, 0};  

        partition(p, from, to, data, cmp, three);

        int nsp = three[0];  // # of elements smaller than p (see partition)
        int nep = three[1];  // # of elements equal to p
        int ngp = three[2];  // # of elements greater than p

        
        quickSort(data, from, from+nsp, cmp);
        quickSort(data, to-ngp, to, cmp);

    }
    
    private static <T> void partition(T p, int from, int to,
									  T[] a, Comparator<T> cmp, int[] three) {
    	int holder=from;
    	for (int i=from; i<=to; i++) {
    		if (cmp.compare(a[i], p) < 0) {
    			swap(a, holder, i);
    			holder++;
    			three[0]++;
    		}
    	}
    	for (int i=holder; i<=to; i++) {
    		if (cmp.compare(a[i], p) == 0) {
    			swap(a, holder, i);
    			holder++;
    			three[1]++;
    		}
    	}
    	three[2] = to-from-three[0]-three[1];
    }
    
}
