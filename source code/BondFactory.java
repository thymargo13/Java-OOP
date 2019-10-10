import Portfolio.*;
//Factory of Bond
public class BondFactory extends AbstractFactory{
    
    public Security createSecurity(){
        System.out.println("Enter code, name and yield:");
        String [] bond = new String[3];
        float yield = 0.0f;
        try{
            String line = br.readLine();
            bond = line.split(","); //read the line and split by ","
            yield = Float.parseFloat(bond[2]);
        }catch(Exception e){}
        return new Bond(bond[0].trim(), bond[1].trim(), yield);//create new Bond
    }
}