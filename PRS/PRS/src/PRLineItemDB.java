import java.util.ArrayList;

public class PRLineItemDB {
	static
	ArrayList<PRLineItem> prLineItems = null;
	static int countPRLI = 0;
	
	public PRLineItemDB() {
		prLineItems = new ArrayList<>();
	}
	
	public static int updateCount() {
		countPRLI++;
		return countPRLI;
	}
	
	public static ArrayList<PRLineItem> getPRLineItems() {
		return prLineItems;
	}
	
	public  void setPRLineItems(ArrayList<PRLineItem> prLineItems) {
		PRLineItemDB.prLineItems = prLineItems;
	}
	
	public static void addPRLineItem(PRLineItem prLineItem) {
		prLineItems.add(prLineItem);  // why isn't this working
	}
	
	public void deletePRLineItem(PRLineItem prLineItem) {
		prLineItems.remove(prLineItems);
	}
	
	public PRLineItem getPOLineItems(int poId) {
		PRLineItem prli = null;
		for (PRLineItem poli:prLineItems) {
			if (poli.getId()==(poId)) {
				prli = poli;
			}
		}
		return prli;
	}
}
