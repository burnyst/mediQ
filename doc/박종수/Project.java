package project.model;

//이 클래스는  Recognize 테이블과 관련된
//data를 다루는데 필요한 기능을 제공

public class Project {

	//변수
	private	int		id;			//고유번호 auto-increment 예정
	private String  ITEM_SEQ;
	private	String	ITEM_NAME;	//품목명
	private	String	ENTP_NAME;	//업체명	
	private	String	ITEM_PERMIT_DATE;   //허가일자 	
	private	String	NB_DOC_DATA; //주의사항
	private String  CANCEL_DATE;
	private String  EE_DOC_DATA;
	private String  ETC_OTC_CODE;
	private String  UD_DOC_DATA;
	private String  CHANGE_DATE;
	private String  CLASS_NO;
	private String  CHART;
	private String  PACK_UNIT;
	private String  NOW_DATE;	//등록일자
	
	
	//생성자
	public Project() {}
	
	//메소드
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getITEM_NAME() {
		return ITEM_NAME;
	}
	public void setITEM_NAME(String ITEM_NAME) {
		this.ITEM_NAME = ITEM_NAME;
	}
	public String getENTP_NAME() {
		return ENTP_NAME;
	}
	public void setENTP_NAME(String ENTP_NAME) {
		this.ENTP_NAME = ENTP_NAME;
	}
	public String getITEM_PERMIT_DATE() {
		return ITEM_PERMIT_DATE;
	}
	public void setITEM_PERMIT_DATE(String ITEM_PERMIT_DATE) {
		this.ITEM_PERMIT_DATE = ITEM_PERMIT_DATE;
	}
	public String getNB_DOC_DATA() {
		return NB_DOC_DATA;
	}

	public void setNB_DOC_DATA(String nB_DOC_DATA) {
		NB_DOC_DATA = nB_DOC_DATA;
	}

	public String getITEM_SEQ() {
		return ITEM_SEQ;
	}

	public void setITEM_SEQ(String iTEM_SEQ) {
		ITEM_SEQ = iTEM_SEQ;
	}

	public String getCANCEL_DATE() {
		return CANCEL_DATE;
	}

	public void setCANCEL_DATE(String cANCEL_DATE) {
		CANCEL_DATE = cANCEL_DATE;
	}

	public String getEE_DOC_DATA() {
		return EE_DOC_DATA;
	}

	public void setEE_DOC_DATA(String eE_DOC_DATA) {
		EE_DOC_DATA = eE_DOC_DATA;
	}

	public String getETC_OTC_CODE() {
		return ETC_OTC_CODE;
	}

	public void setETC_OTC_CODE(String eTC_OTC_CODE) {
		ETC_OTC_CODE = eTC_OTC_CODE;
	}

	public String getUD_DOC_DATA() {
		return UD_DOC_DATA;
	}

	public void setUD_DOC_DATA(String uD_DOC_DATA) {
		UD_DOC_DATA = uD_DOC_DATA;
	}

	public String getCHANGE_DATE() {
		return CHANGE_DATE;
	}

	public void setCHANGE_DATE(String cHANGE_DATE) {
		CHANGE_DATE = cHANGE_DATE;
	}

	public String getCLASS_NO() {
		return CLASS_NO;
	}

	public void setCLASS_NO(String cLASS_NO) {
		CLASS_NO = cLASS_NO;
	}

	public String getCHART() {
		return CHART;
	}

	public void setCHART(String cHART) {
		CHART = cHART;
	}

	public String getPACK_UNIT() {
		return PACK_UNIT;
	}

	public void setPACK_UNIT(String pACK_UNIT) {
		PACK_UNIT = pACK_UNIT;
	}
	
	public String getNOW_DATE() {
		return NOW_DATE;
	}

	public void setNOW_DATE(String nOW_DATE) {
		NOW_DATE = nOW_DATE;
	}

	@Override
	public String toString() {
		return super.toString();
	}

	

	
}











