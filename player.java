
public class player {
    private String name;
    private int money;
    private LinkedList property;
    int rowPosition;
    int columnPosition;


    public player(){
        name = "";
        money = 200;
        property = new LinkedList();
        rowPosition = 0;
        columnPosition = 0;
    }
   
    public player(String n){
        name = n;
        money = 200;
        property = new LinkedList();
        rowPosition = 0;
        columnPosition = 0;
    }


    public void setRow(int rp){
        rowPosition = rp;
    }


    public void setColumn(int cp){
        columnPosition = cp;
    }




    public int getRow(){
        return rowPosition;
    }


    public int getColumn(){
        return columnPosition;
    }


    public String getName(){
        return name;
    }
   
    public int getMoney(){
        return money;
    }


    public void addMoney(){
        money +=100; // Test value for now
    }
   
    public void addProperty(String n){
        property.addToFront(n);
    }
   
   
}
