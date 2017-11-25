import java.util.ArrayList;

public class ProductDB {
	static // hard code data for testing
	
	ArrayList<Product> products = null;
	static int countPOLine = 0;
	
	public ProductDB() {
		products = new ArrayList<>();
		products.add(new Product(1, "Paper1", "Paper 100 sheets", 12.46));
		products.add(new Product(2, "Paper2", "Paper 200 sheets", 23.99));
		products.add(new Product(3, "Paper3", "Paper 300 sheets", 32.12));
	}
	
	public ArrayList<Product> getProducts() {
		return products;
	}
	
	public static int updatePOCount() {
		countPOLine++;
		return countPOLine;
	}
	
	public Product getProductName(String productId) {
		Product prod = null;
		for (Product pd:products) {
			if (pd.getCode() == (productId)) {
				prod = pd;
			}
		}
		return prod;
	}
	
	public static double getCost(int productId) {
		double cost = 0.0;
		System.out.println("productId " + productId);
		for (Product pd:products) {
			if (pd.getId() == (productId)) {
				cost = pd.getPrice();
			}
		}
		return cost;
	}
}
