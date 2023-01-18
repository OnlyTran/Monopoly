public class brand extends gameboard{


    private int cost;
    private String name;
    private boolean bought;
   
    public brand(){
        name = "";
        cost = 0;
        bought = false;
    }
   
    public brand(String n, int c){
        name = n;
        cost=  c;
        bought = false;
    }
   
    public void buy(){
        bought = true;
    }
   
    public boolean isBought(){
        return bought;
    }
}


