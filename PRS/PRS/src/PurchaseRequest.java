import java.time.LocalDate;
import java.util.ArrayList;

public class PurchaseRequest {
	private int id;
	private String userId = "";
	private String description = "";
	private String justification = "";
	private String dateNeeded;
	private String deliveryMode = "";
	private String statusId = "";
	private double total = 0.0;
	private String submittedDate;
	private String reasonForRejection;
	private boolean active;
	
	
	ArrayList<PurchaseRequest> pRequest = null;
	static int countPOLineItems = 0;
	
	public PurchaseRequest(int id, String userId, String description, 
			String justification, String dateNeeded,
			String deliveryMode, String statusId, double total, 
			String submittedDate, String reasonForRejection,
			boolean active) {
		super();
		setId(id);
		setUserId(userId);
		setDescription(description);
		setJustification(justification);
		setDateNeeded(dateNeeded);
		setDeliveryMode(deliveryMode);
		setStatusId(statusId);
		setTotal(total);
		setSubmittedDate(submittedDate);
		setReasonForRejection(reasonForRejection);
		setActive(active);
	}
	
	/*public PurchaseRequest(int id, String userId, String description, String justification, LocalDate dateNeeded,
			String deliveryMode, String statusId, double total, LocalDate submittedDate, String reasonForRejection,
			boolean active) {
		super();
		this.id = id;
		this.userId = userId;
		this.description = description;
		this.justification = justification;
		this.dateNeeded = dateNeeded;
		this.deliveryMode = deliveryMode;
		this.statusId = statusId;
		this.total = total;
		this.submittedDate = submittedDate;
		this.reasonForRejection = reasonForRejection;
		this.active = active;
	}*/
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getJustification() {
		return justification;
	}
	public void setJustification(String justification) {
		this.justification = justification;
	}
	public String getDateNeeded() {
		return dateNeeded;
	}
	public void setDateNeeded(String dateNeeded) {
		this.dateNeeded = dateNeeded;
	}
	public String getDeliveryMode() {
		return deliveryMode;
	}
	public void setDeliveryMode(String deliveryMode) {
		this.deliveryMode = deliveryMode;
	}
	public String getStatusId() {
		return statusId;
	}
	public void setStatusId(String statusId) {
		this.statusId = statusId;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public String getSubmittedDate() {
		return submittedDate;
	}
	public void setSubmittedDate(String submittedDate) {
		this.submittedDate = submittedDate;
	}
	public String getReasonForRejection() {
		return reasonForRejection;
	}
	public void setReasonForRejection(String reasonForRejection) {
		this.reasonForRejection = reasonForRejection;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
		
	@Override
	public String toString() {
		return "[id="+id
				+ ", userId=" + userId
				+ ", description=" + description
				+ ", justification=" + justification
				+ ", dateNeeded=" + dateNeeded
				+ ", deliveryMode=" + deliveryMode
				+ ", statusId=" + statusId
				+ ", total=" + total
				+ ", submittedDate=" + submittedDate
				+ ", reasonForRejection=" + reasonForRejection
				+ ", active=" + active + "]";
	}

}
