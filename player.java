
public class player {
    private String name;
    private int money;
    private LinkedList property;
    int rowPosition;
    int columnPosition;
    boolean arrested;
    int arrestedcount;


    public player(){
        name = "";
        money = 200;
        property = new LinkedList();
        rowPosition = 0;
        columnPosition = 0;
        arrested = false;
        arrestedcount = 0;
    }
   
    public player(String n){
        name = n;
        money = 200;
        property = new LinkedList();
        rowPosition = 0;
        columnPosition = 0;
        arrested = false;
        arrestedcount = 0;
    }
    
    public void resetArrestedCount(){
    	arrestedcount = 0;
    }
    
    public void addArrestedCount(){
    	arrestedcount+=1;
    }
    
    public int getArrestedCount(){
    	return arrestedcount;
    }
    
    public void resetArrest(){
    	arrested = false;
    }
    
    public boolean isArrested(){
    	return arrested;
    }
    
    public void setArrest(){
    	arrested = true;
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

    public void subtractMoney(int r){
    	money = money-r;
    }
    
    public void addMoney(int m){
        money += m; 
    }
   
    public void addProperty(brand n){
        property.addToFront(n);
    }
   
   public String toString(){
	   return name + "'s Stats: \nMoney:"  + money + "\nBrands: \n" + property.toString();
   }
}
