import java.util.*;

public class billGenerator{
    public static void main(String args[]){

   int choice=menu();
    boolean bag=false;

 switch(choice){
    case 1: Pizza basePizza=new Pizza();
   
    System.out.println("wanna custom it ?");
    System.out.println("1) for add extra cheese \n 2) for extra toppings \n 3) for both");
    int n=new Scanner(System.in).nextInt();

    switch(n){
            case 1: basePizza.addExtraCheese();
                     break;
            case 2: basePizza.addExtraToppings();
                break;
             case 3:   basePizza.addExtraCheese();basePizza.addExtraToppings();
                        break;

              default:System.out.println("oops ! invalid press");          
    }

     bag=needCarryBag();
    if(bag){
        basePizza.takeAway();
    }

          basePizza.getBill();          //final bill here

                break;

    case 2:DeluxPizza dp=new DeluxPizza();  
         bag=needCarryBag();
    if(bag){
        dp.takeAway();
    } 

             dp.getBill();   //final bill here
             break;

    default : System.out.println("not available!!");            
 }
       
    }

    public static int menu(){
        System.out.println("which pizza u wanna have !");
        System.out.println("1) for custom pizza ");
        System.out.println("2) for delux pizza ");
        int n=new Scanner(System.in).nextInt();
        return n;
    }

    public static boolean needCarryBag(){
        System.out.println("need any carry bags ?");
        boolean carryBag=new Scanner(System.in).nextBoolean();
        return carryBag;
    }

}



class Pizza{
    private int price;
    private char veg;
    private int basePizzaPrice;

private boolean isExtraCheeseAdded=false;
private boolean isExtraToppingsAdded=false;
private boolean isOptedForTakeAway=false;

    private int extraCheesePrice=100;
    private int extraToppingPrice=100;
    private int backPackPrice=20;

 public Pizza(){
        this.veg=vegOrNonVeg();
        // this.veg=veg;
        if((this.veg=='a')){
            this.price=300;
        }
        else if((this.veg=='b')){
            this.price=400;
        }
        else{
            System.out.println("auto select non veg for ur press");
            this.price=400;
            return;
        }
       basePizzaPrice=this.price;
    }

   public void addExtraCheese(){
        isExtraCheeseAdded=true;
            // System.out.println("Extra cheese is added ");
            this.price+=extraCheesePrice;
     }
     
   public void addExtraToppings(){
        isExtraToppingsAdded=true;    
            // System.out.println("Extra toppings are added ");
            this.price+=extraToppingPrice;
     }

   public void takeAway(){
    isOptedForTakeAway=true;
        // System.out.println("u have to pay 20 rs extra for the carry bag !");
        this.price+=backPackPrice;
     }

    public void getBill(){
        String bill="";
        System.out.println("Pizza : "+basePizzaPrice);

       if(isExtraCheeseAdded){
       bill+="extra cheese charges are added :"+extraCheesePrice+"\n";
       }

     if(isExtraToppingsAdded){
        bill+="extra toppings are also added :"+extraToppingPrice+"\n";
      }

     if(isOptedForTakeAway){
        bill+="price including carry bags: "+backPackPrice+"\n";
     } 

     bill+="total bill : "+this.price+"\n";
     System.out.println(bill);

    }

public static char vegOrNonVeg(){
         System.out.println("which type :a) for veg \n b) press any other key for non veg ");
            char ch=new Scanner(System.in).next().charAt(0);
            return ch;
}

}


class DeluxPizza extends Pizza{
        public DeluxPizza(){
            super();
            super.addExtraCheese();
            super.addExtraToppings();
        }

   public void addExtraCheese(){}    //concept of function overriding so that 
    public void addExtraToppings(){}      // upr parent class k funct. dobara call na ho

}