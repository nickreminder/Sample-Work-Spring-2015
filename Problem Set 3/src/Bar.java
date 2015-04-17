// Nicholas Reminder
// PS3 cs62
// 2-14-15

/*
 * a class to represent bars in a bar graph
 * (TODO: incomplete for sorting and printing)
 */

public class Bar implements Comparable<Bar>{

    private int width;
    private int height;
    
    Bar(int w, int h) {
        this.width = w;
        this.height = h;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
    
    public int compareTo(Bar other) {
    	if (this.height < other.height) return -1;
    	else if (this.height == other.height) return 0;
    	else return 1;
    }
    
    public String toString() {
    	return Integer.toString(this.height);
    }

}
