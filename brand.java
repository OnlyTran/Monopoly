public class brand extends gameboard {

    private int cost;
    private String name;
    private boolean bought;
    private int lessons;
    private String owner;

    public brand() {
        // default constructor, sets all variables to their default values
        name = "";
        cost = 0;
        bought = false;
        lessons = 0;
        owner = "";
    }

    public brand(String n, int c, int l) {
        // overloaded constructor, sets variables to the input values
        name = n;
        cost = c;
        bought = false;
        lessons = l;
        owner = "";
    }
    
    public void setBought(boolean b){
        // Sets the bought variable from save file
        bought = b;
    }

    public String getOwner(){
        // Returns the owner
        return owner;
    }

    public void setOwner(String n){
         // Sets the name of the owner 
        owner = n;
    }
    
    public void setName(String n){
        // Sets the name
        name = n;
    }

    public String getName(){
        // Returns the name
        return name;
    }

    public int getLessons() {
        // returns the money earned from learning the brand
        return lessons;
    }

    public int getMoney() {
        // returns the cost of buying the brand
        return cost;
    }

    public void buy() {
        // sets bought variable to true, indicating that the brand has been bought
        bought = true;
    }

    public boolean isBought() {
        // returns whether or not the brand has been bought
        return bought;
    }

    public String toString() {
        // returns a string containing information about the brand
        return "Name: " + name + " \nCost: " + cost + " \nMoney for Your Lessons once Learned: " + lessons;
    }
}