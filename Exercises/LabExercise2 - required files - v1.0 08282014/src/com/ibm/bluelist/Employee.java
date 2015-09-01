package com.ibm.bluelist;

import com.ibm.mobile.services.data.IBMDataObject;
import com.ibm.mobile.services.data.IBMDataObjectSpecialization;


@IBMDataObjectSpecialization("Employee")
public class Employee extends IBMDataObject {
	
	public static final String CLASS_NAME = "Employee";
	
	private String NAME = "NAME";
	private String AGE = "AGE";
	private String ADDRESS = "ADDRESS";
	
	public String getNAME() {
		//return NAME;
		System.out.println("getter of getNAME is called");
		return (String) getObject(NAME);
	}
	public String getAGE() {
		System.out.println("getter of getAGE is called");
		return (String) getObject(AGE);
		//return AGE;
	}
	public String getADDRESS() {
		System.out.println("getter of getADDRESS is called");
		return (String) getObject(ADDRESS);
		//return ADDRESS;
	}
	public void setNAME(String nAME) {
		System.out.println("setter of setNAME is called");
		setObject(NAME, (nAME != null) ? nAME : "");
		//NAME = nAME;
	}
	public void setAGE(String aGE) {
		System.out.println("setter of setNAME is called");
		setObject(AGE, (aGE != null) ? aGE : "");
		//AGE = aGE;
	}
	public void setADDRESS(String aDDRESS) {
		System.out.println("setter of setNAME is called");
		setObject(ADDRESS, (aDDRESS != null) ? aDDRESS : "");
		ADDRESS = aDDRESS;
	}
	
	public String toString() {
		System.out.println("toString start----------------");
		String theItemName = "";
		theItemName = getNAME()+"   "+getAGE()+"   "+getADDRESS();
		System.out.println("toString end----------------");
		
		return theItemName;
	}
	
	


}
