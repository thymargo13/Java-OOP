package Portfolio;

public  class Memento{
	protected Security _sec;
	protected String code,name;
	protected int quantity;
	
	public Memento(){}//default constructor of Memento
	
	public Memento(Security _sec){
		this._sec =_sec;
		this.code =_sec.getCode();
		this.name= _sec.getName();
		this.quantity =_sec.getQuantity();
	}
		
	public  Security restore(){
		this._sec.setCode(code);
		this._sec.setName(name);
		this._sec.setQuantity(quantity);
		return _sec;
	}
	public Security getSecurity(){
		return _sec;
	}
}