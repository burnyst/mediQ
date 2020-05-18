package model;

import java.util.Date;

public class History extends Product {
	private String mid;
	private Date rdate;
	public History(String mid, String itemSeq, String itemName, String entpName, String itemPermitDate, String nbDocData,
			String cancelDate, String eeDocData, String etcOtcCode, String udDocData, String changeDate, String classNo,
			String chart, String packUnit, Date rdate) {
		super(itemSeq, itemName, entpName, itemPermitDate, nbDocData, cancelDate, eeDocData, etcOtcCode, udDocData, changeDate,
				classNo, chart, packUnit);
		this.mid = mid;
		this.rdate = rdate;
	}
	public String getMid() {
		return mid;
	}
	public Date getRdate() {
		return rdate;
	}
}
