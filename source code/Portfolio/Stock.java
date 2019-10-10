package Portfolio;

public class Stock extends Security{
    private String exchange;
    
    public Stock(String code, String name, String exchange){
        super(code, name);
        this.exchange = exchange;
    }
	
    public String getExchange(){
		return exchange;
	}
    public void setExchange(String exchange){
		this.exchange = exchange;
	}
	
    public String toString(){
		 return "Exchange:"+ getExchange();
	}
}