public class Client{
    
    
    public AbstractProductA createA(AbstractFactory af){
        AbstractProductA a =af.createProductA();
        return a;
    }
    
    
    
    public AbstractProductB createB(AbstractFactory af){
        AbstractProductB b =af.createProductB();
        return b;
    }
}