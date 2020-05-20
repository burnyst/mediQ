package model;

public class Recognize {
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
	public Recognize(String itemSeq, String itemName, String entpName, String itemPermitDate, String nbDocData,
			String cancelDate, String eeDocData, String etcOtcCode, String udDocData, String changeDate, String classNo,
			String chart, String packUnit) {
		this.itemSeq = itemSeq;
		this.itemName = itemName;
		this.entpName = entpName;
		this.itemPermitDate = itemPermitDate;
		this.nbDocData = nbDocData;
		this.cancelDate = cancelDate;
		this.eeDocData = eeDocData;
		this.etcOtcCode = etcOtcCode;
		this.udDocData = udDocData;
		this.changeDate = changeDate;
		this.classNo = classNo;
		this.chart = chart;
		this.packUnit = packUnit;
	}
	
	public String getItemSeq() {
		return itemSeq;
	}
	public String getItemName() {
		return itemName;
	}
	public String getEntpName() {
		return entpName;
	}
	public String getItemPermitDate() {
		return itemPermitDate;
	}
	public String getNbDocData() {
		return nbDocData;
	}
	public String getCancelDate() {
		return cancelDate;
	}
	public String getEeDocData() {
		return eeDocData;
	}
	public String getEtcOtcCode() {
		return etcOtcCode;
	}
	public String getUdDocData() {
		return udDocData;
	}
	public String getChangeDate() {
		return changeDate;
	}
	public String getClassNo() {
		return classNo;
	}
	public String getChart() {
		return chart;
	}
	public String getPackUnit() {
		return packUnit;
	}
}