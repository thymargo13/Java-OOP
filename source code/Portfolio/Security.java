package Portfolio;

public class Security{
    private String code, name;
    private int quantity;
	
    //constructor of Security
    public Security(String code, String name){
        this.code= code;
        this.name=name;
    }
	//getter of code
    public String getCode(){
		return code;
	}
	//getter of name
    public String getName(){
		 return name;
	}
	//getter of quantity
    public int getQuantity(){
		return quantity;
	}
	//setter of quantity
    public void setQuantity(int quantity ){
		this.quantity= quantity;
	}
	//setter of code
    public void setCode(String code){
		this.code = code;
	}
	//setter of name
    public void setName(String name){
		this.name = name;
	}

    public String toString(){
		return "Code: "+ getCode()+"\nName: "+getName()+"\nQuantity:" +getQuantity();
	}
}


