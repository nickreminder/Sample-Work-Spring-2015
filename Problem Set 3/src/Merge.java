// Nicholas Reminder
// PS3 cs62
// 2-14-15

/* Merge sort is used in java.util.Arrays.sort to sort an array of
 * objects.  In this implementation, I chose to show the algorithm
 * that sorts an int array.  To sort an object array you would
 * have to incorporate the Comparable interface.  I will leave it
 * as an exercise.
 */
public class Merge {

    public static void msort(int[] a) {
        int aux[] = (int[])a.clone();
        mergeSort(aux, a, 0, a.length);
    }

    private static void mergeSort(int src[], int dest[],
                                  int low, int high) {

	if ((high - low) < 2) {
	    return;
	}

        // Note that we are chopping the array into 2 halves before
        // we do anything.  On our way back up from the recursive calls,
        // we will start merging them.  See below.
        int mid = (low + high) / 2;
        mergeSort(dest, src, low, mid);
        mergeSort(dest, src, mid, high);

        // Some optimization can be done.  If both halves are already
        // in the sorted order, merge can be done by simply coping the
        // array from src to dest.
        if (src[mid - 1] <= src[mid]) {
            System.arraycopy(src, low, dest, low, high - low);
            return;
        }

        // This is really where the merge is happening.
        //
        // low = 0, mid = 5; high = 10
        // src:  32 46 46 59 80 43 44 55 81 87
        //       p              q
        // dest: 32
        //       i
        for (int i = low,
                 p = low,
                 q = mid; i < high; i++) {
            if ((q >= high) || (p < mid && src[p] <= src[q])) {
                dest[i] = src[p++];
            }
            else {
                dest[i] = src[q++];
            }
        }
    }

    private static void printArray(int[] a, String msg) {
        System.out.println("\n\n" + msg);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    // Returns an array of n random integers.  The integers are
    // chosen from the interval [0..n)
    public static int[] randomArray(int n) {
        int[] A;
        A = new int[n];
        java.util.Random r = new java.util.Random();
        for (int i = 0; i < n; i++) {
            A[i] = r.nextInt(n);
        }
        return A;
    }

    public static void main(String[] args) {
        // int[] numbers = {20, 19, 18, 17, 16, 15, 14, 13, 12, 11,
        //                  10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        // int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
        //                  11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        // int[] numbers = {1, 2, 3, 4};
	// int[] numbers = randomArray(20);
        int[] numbers = {6, 5, 7, 4, 2, 1, 3, 9, 10, 8};

        printArray(numbers, "Before sorted:");
        msort(numbers);
        printArray(numbers, "After sorted:");

        /*
        int[] numbers2 = randomArray(100000);
        System.out.println("merge sort began . . . . . . . . . . . . .");
        msort(numbers2);
        System.out.println("merge sort finished . . . . . . . . . . . . .");
        */
    }
}
