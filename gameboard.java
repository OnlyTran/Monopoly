public class gameboard {
    private String display; // variable to hold the display of the gameboard
    private int rowPosition; // variable to hold the row position of the gameboard
    private int columnPosition; // variable to hold the column position of the gameboard

    // constructor to initialize the gameboard with empty display and position at (0,0)
    public gameboard() {
        display = " ";
        rowPosition = 0;
        columnPosition = 0;
    }

    // constructor to initialize the gameboard with a given name, row position, and column position
    public gameboard(String name, int rp, int cp) {
        display = name;
        rowPosition = rp;
        columnPosition = cp;
    }

    //  set the display of the gameboard
    public void setDisplay(String name) {
        display = name;
    }

    //  set the position of the gameboard
    public void setPosition(int rp, int cp) {
        rowPosition = rp;
        columnPosition = cp;
    }

    // get the row position of the gameboard
    public int getRow(){
        return rowPosition;
    }

    // get the column position of the gameboard
    public int getColumn(){
        return columnPosition;
    }

    //  display of the gameboard
    public String getDisplay() {
        return display;
    }
}