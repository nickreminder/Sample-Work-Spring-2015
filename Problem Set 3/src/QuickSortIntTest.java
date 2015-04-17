// Nicholas Reminder
// PS3 cs62
// 2-14-15

import java.awt.Color;
import java.awt.Graphics;
import java.util.Arrays;
import java.util.Random;

public class QuickSortIntTest {

    // drawing stuff for debug
    private static int NBARS;
    private static final int XWINSIZE = 400;
    private static final int YWINSIZE = 300;
    private static DrawingPanel panel = new DrawingPanel(XWINSIZE,YWINSIZE);
    private static Graphics g = panel.getGraphics();

    public static void main(String[] args) {

        //int[] numbers1 = {14, 3, 2, 11, 10, 4, 8, 7, 6, 5, 9, 13, 12, 1};
        int[] numbers1 = randomArray(128);
        NBARS = numbers1.length;

        System.out.println("Before sorted: ");
        System.out.println(Arrays.toString(numbers1));
        drawArray(numbers1, YWINSIZE/2, Color.RED);

        QuickSortInt.qsort(numbers1);

        System.out.println("After sorted: ");
        System.out.println(Arrays.toString(numbers1));
        drawArray(numbers1, YWINSIZE-1, Color.GREEN);

    }
    
    // utility method to draw an array of Bar objects at a given y offset with a given color
    private static void drawArray(int[] b, int yoffset, Color c) {
        int xpos = 0;
        int ypos = yoffset;
        int width = XWINSIZE/NBARS;

        g.setColor(c);
        for (int i = 0; i < b.length; i++) {
            ypos = yoffset - b[i];
            g.fillRect(xpos, ypos, width, b[i]);
            xpos = xpos + width;
        }
            
    }

    // utility method to create an array of n bars with random height and fixed width.  
    // The heights are // chosen from the interval [0..n)
    private static int[] randomArray(int n) {
        int[] A = new int[n];
        Random rgen = new Random();
        for (int i = 0; i < n; i++) {
            A[i] = rgen.nextInt(n);
        }
        return A;
    }

}
