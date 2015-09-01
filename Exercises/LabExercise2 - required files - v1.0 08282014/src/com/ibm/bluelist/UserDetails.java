package com.ibm.bluelist;

import com.ibm.mobile.services.data.IBMDataObject;
import com.ibm.mobile.services.data.IBMDataObjectSpecialization;

@IBMDataObjectSpecialization("User_Details")
public class UserDetails extends IBMDataObject { 
	
	public static final String CLASS_NAME = "User_Details";
	//private static final String NAME = "name";
	
	private String TERRITORY = "TERRITORY";
	private String TERRITORY_DESC = "TERRITORY_DESC";
	private String SALES_FORCE_CD = "SALES_FORCE_CD";
	private String Business = "Business";
	private String DISTRICT = "DISTRICT";
	
	public String getTERRITORY() {
		//return TERRITORY;
		System.out.println("------------"+(String) getObject(TERRITORY));
		return (String) getObject(TERRITORY);
	}
	public String getTERRITORY_DESC() {
		//return TERRITORY_DESC;
		return (String) getObject(TERRITORY_DESC);
		
	}
	public String getSALES_FORCE_CD() {
		//return SALES_FORCE_CD;
		return (String) getObject(SALES_FORCE_CD);
	}
	public String getBusiness() {
		//return Business;
		return (String) getObject(Business);
	}
	public String getDISTRICT() {
		//return DISTRICT;
		return (String) getObject(DISTRICT);
	}
	public void setTERRITORY(String tERRITORY) {
		System.out.println("set TERRITORY");
		//TERRITORY = tERRITORY;
		setObject(TERRITORY, (tERRITORY != null) ? tERRITORY : "");
	}
	public void setTERRITORY_DESC(String tERRITORY_DESC) {
		TERRITORY_DESC = tERRITORY_DESC;
		setObject(TERRITORY_DESC, (tERRITORY_DESC != null) ? tERRITORY_DESC : "");
	}
	public void setSALES_FORCE_CD(String sALES_FORCE_CD) {
		SALES_FORCE_CD = sALES_FORCE_CD;
		setObject(SALES_FORCE_CD, (sALES_FORCE_CD != null) ? sALES_FORCE_CD : "");
	}
	public void setBusiness(String business) {
		Business = business;
		setObject(Business, (business != null) ? business : "");
	}
	public void setDISTRICT(String dISTRICT) {
		DISTRICT = dISTRICT;
		setObject(DISTRICT, (dISTRICT != null) ? dISTRICT : "");
	}
	
	
	public String toString() {
		System.out.println("toString start----------------");
		String theItemName = "";
		theItemName = getTERRITORY()+"   "+getTERRITORY_DESC()+" "+getSALES_FORCE_CD()+"   "+getBusiness();
		System.out.println("toString end----------------");
		
		return theItemName;
	}
	
	

}
