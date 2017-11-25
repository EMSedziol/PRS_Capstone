import java.text.NumberFormat;

public class Product {
	private int id;
	private String code;
	private String description;
	private double price;
	
	public Product() {
		id = 0;
		code = "";
		description = "";
		price = 0.0;
	}
	
	public Product(int id, String code, String description, double price) {
		setId(id);
		setCode(code);
		setDescription(description);
		setPrice(price);
	}
		
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public String getPriceFormatted() {
		NumberFormat c = NumberFormat.getCurrencyInstance();
		return c.format(price);
	}
	
	@Override
	public String toString() {
		return "Product [id= " + id 
				+ ", code" + code
				+ ", description=" + description
				+ ", price=" + price
				+ "]";
	}
}
