package model;

public class ModiRequest {
	private String itemSeq;
	private String itemName;
	private String entpName;
	private String itemPermitDate;
	private String nbDocData;
	private String cancelDate;
	private String eeDocData;
	private String etcOtcCode;
	private String udDocData;
	private String changeDate;
	private String classNo;
	private String chart;
	private String packUnit;
	public ModiRequest(String itemSeq, String itemName, String entpName, String itemPermitDate, String nbDocData,
			String cancelDate, String eeDocData, String etcOtcCode, String udDocData, String changeDate,
			String classNo, String chart, String packUnit) {
	}
	public String getItemSeq() {
		return itemSeq;
	}
	public void setItemSeq(String itemSeq) {
		this.itemSeq = itemSeq;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getEntpName() {
		return entpName;
	}
	public void setEntpName(String entpName) {
		this.entpName = entpName;
	}
	public String getItemPermitDate() {
		return itemPermitDate;
	}
	public void setItemPermitDate(String itemPermitDate) {
		this.itemPermitDate = itemPermitDate;
	}
	public String getNbDocData() {
		return nbDocData;
	}
	public void setNbDocData(String nbDocData) {
		this.nbDocData = nbDocData;
	}
	public String getCancelDate() {
		return cancelDate;
	}
	public void setCancelDate(String cancelDate) {
		this.cancelDate = cancelDate;
	}
	public String getEeDocData() {
		return eeDocData;
	}
	public void setEeDocData(String eeDocData) {
		this.eeDocData = eeDocData;
	}
	public String getEtcOtcCode() {
		return etcOtcCode;
	}
	public void setEtcOtcCode(String etcOtcCode) {
		this.etcOtcCode = etcOtcCode;
	}
	public String getUdDocData() {
		return udDocData;
	}
	public void setUdDocData(String udDocData) {
		this.udDocData = udDocData;
	}
	public String getChangeDate() {
		return changeDate;
	}
	public void setChangeDate(String changeDate) {
		this.changeDate = changeDate;
	}
	public String getClassNo() {
		return classNo;
	}
	public void setClassNo(String classNo) {
		this.classNo = classNo;
	}
	public String getChart() {
		return chart;
	}
	public void setChart(String chart) {
		this.chart = chart;
	}
	public String getPackUnit() {
		return packUnit;
	}
	public void setPackUnit(String packUnit) {
		this.packUnit = packUnit;
	}
	@Override
	public String toString() {
		return "ModiRequest [itemSeq=" + itemSeq + ", itemName=" + itemName + ", entpName=" + entpName
				+ ", itemPermitDate=" + itemPermitDate + ", nbDocData=" + nbDocData + ", cancelDate=" + cancelDate
				+ ", eeDocData=" + eeDocData + ", etcOtcCode=" + etcOtcCode + ", udDocData=" + udDocData
				+ ", changeDate=" + changeDate + ", classNo=" + classNo + ", chart=" + chart + ", packUnit=" + packUnit
				+ "]";
	}

	
}
