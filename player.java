public class player {
    // Declare private variables for the player's name, money, property,
    // current row and column position on the gameboard, arrested status,
    // and arrested count.
    private String name;
    private int money;
    private LinkedList property;
    int rowPosition;
    int columnPosition;
    boolean arrested;
    int arrestedcount;

    // Default constructor for player class, sets initial values for all variables.
    public player() {
        name = "";
        money = 200;
        property = new LinkedList();
        rowPosition = 0;
        columnPosition = 0;
        arrested = false;
        arrestedcount = 0;
    }

    // Overloaded constructor for player class, sets name and initial values for all
    // other variables.
    public player(String n) {
        name = n;
        money = 200;
        property = new LinkedList();
        rowPosition = 0;
        columnPosition = 0;
        arrested = false;
        arrestedcount = 0;
    }

    // Method to set the name
    public void setName(String n){
        name = n;
    }

    // Method to set the money
    public void setMoney(int m){
        money = m;
    }

    // Method to set the arrest
    public void setArrest(boolean a){
        arrested = a;
    }

    // Method to set the arresting turn count
    public void setArrestedCount(int a){
        arrestedcount = a;
    }

    // Method to return the property
    public LinkedList getProperty() {
        return property;
    }

    // Method to reset the arrested count to 0
    public void resetArrestedCount() {
        arrestedcount = 0;
    }

    // Method to add 1 to the arrested count
    public void addArrestedCount() {
        arrestedcount += 1;
    }

    // Method to get the arrested count
    public int getArrestedCount() {
        return arrestedcount;
    }

    // Method to reset the arrested status to false
    public void resetArrest() {
        arrested = false;
    }

    // Method to get the arrested status
    public boolean isArrested() {
        return arrested;
    }

    // Method to set the arrested status to true
    public void Arrest() {
        arrested = true;
    }

    // Method to set the row position of the player
    public void setRow(int rp) {
        rowPosition = rp;
    }

    // Method to set the column position of the player
    public void setColumn(int cp) {
        columnPosition = cp;
    }

    // Method to get the row position of the player
    public int getRow() {
        return rowPosition;
    }

    // Method to get the column position of the player
    public int getColumn() {
        return columnPosition;
    }

    // Method to get the name of the player
    public String getName() {
        return name;
    }

    // Method to get the money of the player
    public int getMoney() {
        return money;
    }

    // Method to subtract money from the player
    public void subtractMoney(int r) {
        money = money - r;
    }

    // Method to add money to the player
    public void addMoney(int m) {
        money += m;
    }

    // Adds a brand to the player's brand list
    public void addProperty(brand n) {
        property.addToFront(n);
    }

    // returns a string of the player's name, money and brand
    public String toString() {
        return name + "'s Stats: \nMoney:" + money + "\nBrands: \n" + property.toString();
    }
}