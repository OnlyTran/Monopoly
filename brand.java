public class brand extends gameboard{


    private int cost;
    private String name;
    private boolean bought;
    private int lessons;
    
    public brand(){
        name = "";
        cost = 0;
        bought = false;
        lessons = 0;
    }
   
    public brand(String n, int c){
        name = n;
        cost =  c;
        bought = false;
        lessons = 0;	
    }
   
    public void buy(){
        bought = true;
    }
   
    public boolean isBought(){
        return bought;
    }
    
    public String toString(){
    	return "Name: " + name + "\nCost: " + cost + "Money for Your Lessons once Learned: " + lessons ;
    }
}


