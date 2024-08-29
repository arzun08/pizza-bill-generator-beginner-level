
class DeluxPizza extends Pizza{
        public DeluxPizza(){
            super(veg);
            super.addExtraCheese();
            super.addExtraToppings();
        }

   public void addExtraCheese(){}    //concept of function overriding so that 
    public void addExtraToppings(){}      // upr parent class k funct. dobara call na ho

}