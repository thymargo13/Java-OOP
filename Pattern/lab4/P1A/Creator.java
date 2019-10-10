public abstract class Creator{
    
    public abstract Product factoryMethod();
    public void anOperation(){
        Product p = factoryMethod();
        System.out.println("Product Created:"+p.getName());
    };
}