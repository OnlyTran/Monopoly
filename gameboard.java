public class gameboard {
    private String display;
    private int rowPosition;
    private int columnPosition;


    public gameboard() {
        display = " ";
        rowPosition = 0;
        columnPosition = 0;
    }


    public gameboard(String name, int rp, int cp) {
        display = name;
        rowPosition = rp;
        columnPosition = cp;
    }


    public void setDisplay(String name) {
        display = name;
    }


    public void setPosition(int rp, int cp) {
        rowPosition = rp;
        columnPosition = cp;
    }


    public int getRow(){
        return rowPosition;
    }


    public int getColumn(){
        return columnPosition;
    }




    public String getDisplay() {
        return display;
    }


}
