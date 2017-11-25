import java.util.ArrayList;

public class PRLineItem {
	private int id;
	private int purchaseRequestId;
	private String productId;
	private int quantity;
	private boolean active;
	
	static int countPOLineItems = 0;
	
	public static int updateCount() {
		countPOLineItems++;
		return countPOLineItems;
	}
	
	public PRLineItem(int id, int purchaseRequestId, String productId, 
			int quantity, boolean active) {

		setPurchaseRequestId(purchaseRequestId);
		setProductId(productId);
		setQuantity(quantity);
		setActive(active);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPurchaseRequestId() {
		return purchaseRequestId;
	}

	public void setPurchaseRequestId(int purchaseRequestId) {
		this.purchaseRequestId = purchaseRequestId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public static int getCountPOLineItems() {
		return countPOLineItems;
	}

	public static void setCountPOLineItems(int countPOLineItems) {
		PRLineItem.countPOLineItems = countPOLineItems;
	}

	@Override
	public String toString() {
		return "PurchaseRequestLineItem[ i=" + id
				+ ", purchaseRequestId=" + purchaseRequestId
				+ ", productI=" + productId
				+ ", quantity= " + quantity
				+ ", active=" + active + "]";
	}
}
