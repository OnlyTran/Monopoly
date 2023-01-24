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
   
    public brand(String n, int c, int l){
        name = n;
        cost =  c;
        bought = false;
        lessons = l;	
    }
   
    public int getLessons(){
    	return lessons;
    }
    
    public int getMoney(){
    	return cost;
    }
    
    public void buy(){
        bought = true;
    }
   
    public boolean isBought(){
        return bought;
    }
    
    public String toString(){
    	return "Name: " + name + " \nCost: " + cost + " \nMoney for Your Lessons once Learned: " + lessons ;
    }
}


