import java.text.NumberFormat;
import java.util.ArrayList;

public class PurchaseRequestDB {
	static // hard code data for testing
	
	ArrayList<PurchaseRequest> pRequests = null;
	static int countPRDB = 0;
	
	public PurchaseRequestDB() {
		pRequests = new ArrayList<>();	
	}
	
	public static int updateCount() {
		countPRDB++;
		return countPRDB;
	}
	
	public static ArrayList<PurchaseRequest> getPurchaseRequests() {
		return pRequests;
	}
	
	public  void setPurchaseRequests(ArrayList<PurchaseRequest> pRequests) {
		PurchaseRequestDB.pRequests = pRequests;
	}
	
	public static void addPurchaseRequest(PurchaseRequest pRequest) {
		pRequests.add(pRequest);  // why isn't this working
	}
	
	public void deletePurchaseRequest(PurchaseRequest pRequest) {
		pRequests.remove(pRequests);
	}
	
	 public static  String getPriceFormatted(double totalPO) {
	        NumberFormat currency = NumberFormat.getCurrencyInstance();
	        return currency.format(totalPO);
	    }
}
