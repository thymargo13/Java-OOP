import Portfolio.*;

public class StockFactory extends AbstractFactory{
    public Security createSecurity(){
        String [] stock = new String[3];
        System.out.println("Enter code, name and stock exchange:");
        try{
            String line = br.readLine();
            stock = line.split(",");
        }catch(Exception e){}
        return new Stock(stock[0].trim(), stock[1].trim(), stock[2].trim());
    }
}