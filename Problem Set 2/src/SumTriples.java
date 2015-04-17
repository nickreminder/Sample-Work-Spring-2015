// Nick Reminder
// nicholas.reminder@pomona.edu
// cs62 ps2 sun
// 2/3/15
/**
 * find triples that sum to specified value in an array of random integers
 */
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Random;

public class SumTriples {

    // brute force approach
	
	// This brute force approach is Theta(n^3) for large values of n. More accurately, I suppose, it's
	// Theta(n*(n-1)*(n-2)) but I should think the difference becomes negligible for large values of n.
	// The reason is pretty evident if you look at my loop structure- the first two elements are evaluated
	// with each of every other element, then the second element iterates and it repeats, then once the
	// second element has hit the second-to-last element in the array, the first element iterates and it
	// starts all over. 
    public static int countTriples(int[] a, int val, ArrayList<Integer> resultsList) {
        int cnt = 0;
        for (int i=0; i<(a.length-2); i++) {
        	for (int j=(i+1); j<(a.length-1); j++) {
        		for (int k=(j+1); k<a.length; k++) {
        			if ((a[i]+a[j]+a[k])==val) {
        				cnt++;
        				resultsList.add(a[i]);
        				resultsList.add(a[j]);
        				resultsList.add(a[k]);
        			}
        		}
        	}
        }
        return cnt;
    } 

    // a faster approach
    
    // This faster approach is Theta(n^2) - quadtratic time - which is a complexity class
    // better than my brute force approach. The difference here is that I've added a second
    // pointer and taken advantage of being able to sort the array using the built in 
    // sort function in n*log(n) time. The integer moves through a loop of the first index 
    // just like the brute force method, but at each iteration creates pointers to the next
    // and last elements, moving them towards each other based on the size of the sum generated
    // at the current indices relative to the goal sum. The result is that for each of the
    // n-2 'first' indices that are searched, there are only n evaluations, leading to n^2
    // running time.
    public static int countTriplesV2(int[] a, int val, ArrayList<Integer> resultsList) {
        int cnt = 0;
        Arrays.sort(a);
        for (int i=0; i<a.length-2; i++) {
        	int j = i+1;
        	int k = a.length-1;
        	while (j<k) {
        		int sum = a[i]+a[j]+a[k];
        		if (sum < val) j++;
        		else if (sum > val) k--;
        		else { 
        			resultsList.add(a[i]);
        			resultsList.add(a[j]);
        			resultsList.add(a[k]);
        			j++;
        			k--;
        			cnt++;
        		}   		
        	}
        }
        return cnt;
    } 

    // helper method to confirm that a list's tuples add to a targetSum
    private static boolean confirmTupleSum(ArrayList<Integer> list, int tupleSize, int targetSum) {
        for (int i = 0; i < list.size(); i+=tupleSize) {
            int sum = 0;
            for (int j = 0; j < tupleSize; j++)
                sum = sum + list.get(i+j);
            if (sum != targetSum)
                return false;
        }
        return true;
    }

    // Helper method that returns an array of n random unique integers.  The integers are
    // in the range -rangePlusMinus to +rangePlusMinus
    private static int[] randomArray (int n, int rangePlusMinus) {
    	int[] a = new int[n];
    	Random rand = new Random();
    	int randomRange = (2*rangePlusMinus)+1;
    	for (int i=0; i<n; i++) {
    		int nextRandom = rand.nextInt(randomRange)-rangePlusMinus;
    		if (randomIsUnique(a, nextRandom)) a[i] = nextRandom;
    		else i--;
    	}
    	return a;
    }
    
    private static boolean randomIsUnique (int[] array, int random) {
    	for (int i=0; i<array.length; i++) {
    		if (array[i] == random) return false;
    	}
    	return true;
    }


    // test both the slow brute force approach and the faster approach
    public static void main(String[] args)  { 
        int N = 16;
        int range = 2*N;
        int targetVal = 1;
        ArrayList<Integer> results1 = new ArrayList<>();
        ArrayList<Integer> results2 = new ArrayList<>();
        
        // create an array of random integers with no duplicates
        int[] a = randomArray(N, range);
        if (a.length <= 16)
            System.out.println("src Array: " + Arrays.toString(a));

        System.out.println("Testing brute force:");

        long startTime = System.nanoTime();
        int cnt = countTriples(a, targetVal, results1);
        long stopTime = System.nanoTime();
        long elapsedTime = stopTime - startTime;
        System.out.println("count = " + cnt + ", elapsed time = " + elapsedTime);
        
        System.out.println("Testing faster approach:");

        startTime = System.nanoTime();
        cnt = countTriplesV2(a, targetVal, results2);
        stopTime = System.nanoTime();
        elapsedTime = stopTime - startTime;
        System.out.println("count = " + cnt + ", elapsed time = " + elapsedTime);

        // confirm results lists
        System.out.println("results1 list valid: " + confirmTupleSum(results1, 3, targetVal));
        System.out.println("results2 list valid: " + confirmTupleSum(results2, 3, targetVal));

        // debug visually
        if ( N <= 16) {
            System.out.println("results1: " + results1);
            System.out.println("results2: " + results2);
        }
    } 

} 
