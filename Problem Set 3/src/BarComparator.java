// Nicholas Reminder
// PS3 cs62
// 2-14-15

import java.util.*;

public class BarComparator implements Comparator<Bar> {
	
	public int compare(Bar a, Bar b) {
		if (a.getHeight() < b.getHeight()) return -1;
		else if (a.getHeight() == b.getHeight()) return 0;
		return 1;
	}
}
