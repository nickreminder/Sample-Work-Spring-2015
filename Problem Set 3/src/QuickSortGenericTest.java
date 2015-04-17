// Nicholas Reminder
// PS3 cs62
// 2-14-15

import java.awt.Color;
import java.awt.Graphics;
import java.util.Arrays;
import java.util.Random;

public class QuickSortGenericTest {

    // drawing stuff for debug
    private static final int NBARS = 128;
    private static final int XWINSIZE = 400;
    private static final int YWINSIZE = 300;
    private static DrawingPanel panel = new DrawingPanel(XWINSIZE,YWINSIZE);
    private static Graphics g = panel.getGraphics();

    public static void main(String[] args) {

        // create a random array of Bar objects
        Bar[] bars = randomBarArray(NBARS, XWINSIZE/NBARS);
        
        printArray(bars, "Before sort:");
        drawBarArray(bars, YWINSIZE/2, Color.RED);

        QuickSortGeneric.qsort(bars);

        printArray(bars, "After sort:");
        drawBarArray(bars, YWINSIZE-1, Color.GREEN);

    }
    
    // utility method to draw an array of Bar objects at a given y offset with a given color
    private static void drawBarArray(Bar[] b, int yoffset, Color c) {
        int xpos = 0;
        int ypos = yoffset;

        g.setColor(c);
        for (int i = 0; i < b.length; i++) {
            ypos = yoffset - b[i].getHeight();
            g.fillRect(xpos, ypos, b[i].getWidth(), b[i].getHeight());
            xpos = xpos + b[i].getWidth();
        }
            
    }

    // utility method to print an array of object (relys on object's toString method)
    private static void printArray(Object[] a, String msg) {
        System.out.println("\n\n" + msg);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    // utility method to create an array of n bars with random height and fixed width.  
    // The heights are // chosen from the interval [0..n)
    private static Bar[] randomBarArray(int n, int width) {
        Bar[] A = new Bar[n];
        Random rgen = new Random();
        for (int i = 0; i < n; i++) {
            A[i] = new Bar(width, rgen.nextInt(n));
        }
        return A;
    }

}
