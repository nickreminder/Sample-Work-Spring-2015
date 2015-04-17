// Nicholas Reminder 2-23-15
// cs62 ps4
// nicholas.reminder@pomona.edu

// This class keeps track of a list of Tile objects.

import java.util.*;

public class TileList {
    private List<Tile> tiles;
    
    // post: constructs an empty tile list
    public TileList()  {
        tiles = new DLinkedList<Tile>();
        //tiles = new ArrayList<Tile>();    // uncomment this to see how the demo behaves with an ArrayList
    }
        
    // post: returns the index of the last rectangle that contains (x, y),
    //       -1 if not found
    private int locate(int x, int y) {
        Debug.print("TileList.locate: " + x + ", " + y);
        int lastMatch = -1;
        Iterator<Tile> itr = tiles.iterator();
        int i = 0;
        while (itr.hasNext()) {
            Tile t = itr.next();
            if (t.inside(x, y)) {
                lastMatch = i;
            }
            i = i + 1;
        }
        return lastMatch;
    }
    /*
    private int locate(int x, int y) {
        Debug.print("TileList.locate: " + x + ", " + y);
        int lastMatch = -1;
        for (int i = 0; i < tiles.size(); i++) {
            if (tiles.get(i).inside(x, y)) {
                lastMatch = i;
            }
        }
        return lastMatch;
    }
    */

    // post: searches through the list of tiles and returns a
    //       reference to the last tile for which (x, y) is
    //       inside the tile; returns null if (x, y) is not
    //       inside any tile of the list; moves the found tile
    //       to the back of the list
    public Tile moveToBack(int x, int y) {
        Debug.print("TileList.moveToBack: " + x + ", " + y);
        int pos = locate(x, y);
        if (pos == -1) {
            return null;
        } else {
            Tile t = tiles.get(pos);
            if (pos != tiles.size() - 1) {
                tiles.remove(pos);
                tiles.add(t);
            }
            return t;
        }
    }
        
    // post: inserts t at the back of the list of tiles
    public void insertBack(Tile t) {
        Debug.print("TileList.insertBack: " + t.getX() + ", " + t.getY());
        tiles.add(t);
        // make sure tile is in list (just for debug purposes)
        if (!tiles.contains(t)) {
            System.out.println("Uh oh... internal error with LinkedList.java");
        }
        else {
            Debug.print("TileList.insertBack: contains succeeded");
        }
    }
        
    // post: returns the number of tiles in this list
    public int size() {
        return tiles.size();
    }

    // post: returns the Tile at the given index
    public Tile get(int index) {
        return tiles.get(index);
    }
    
    // static nested class for debugging (change on to true to enable debug printing)
    private static class Debug {
        public static final boolean on = false;
    
        public static void print( String s ) {
            if (on) System.out.println(s);
        }
    }
        
}