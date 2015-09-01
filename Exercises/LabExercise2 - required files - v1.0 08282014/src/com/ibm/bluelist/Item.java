/*
 * Copyright 2014 IBM Corp. All Rights Reserved
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0 
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ibm.bluelist;

import com.ibm.mobile.services.data.IBMDataObject;
import com.ibm.mobile.services.data.IBMDataObjectSpecialization;

@IBMDataObjectSpecialization("Monthly_Sales")
public class Item extends IBMDataObject {
	public static final String CLASS_NAME = "Monthly_Sales";
	//private static final String NAME = "name";
	
	//USER_ID, LOGON_ID, SAP_NUMBER, SALES_REP_NAME, BUSINESS
	
	private String USER_ID = "USER_ID";
	private String Territory_ID = "Territory_ID";
	private String USER_NAME = "USER_NAME";
	private String CURRENT_MONTH_SALES = "CURRENT_MONTH_SALES";
	private String PREV_MONTH_SALES = "PREV_MONTH_SALES";
	private String Sales_Difference = "Sales_Difference";
	
	
	public String getUSER_ID() {
		System.out.println("getter of getUSER_ID is called");
		return (String) getObject(USER_ID);
	}
	
	public void setUSER_ID(String uSER_ID) {
		System.out.println("setter of getUSER_ID is called");
		setObject(USER_ID, (uSER_ID != null) ? uSER_ID : "");
	}
	
	public String getTerritory_ID() {
		//return Territory_ID;
		return (String) getObject(Territory_ID);
	}

	public void setTerritory_ID(String territory_ID) {
		Territory_ID = territory_ID;
		setObject(Territory_ID, (territory_ID != null) ? territory_ID : "");
	}

	public String getUSER_NAME() {
		//return USER_NAME;
		return (String) getObject(USER_NAME);
	}
	
	public void setUSER_NAME(String uSER_NAME) {
		//USER_NAME = uSER_NAME;
		setObject(USER_NAME, (uSER_NAME != null) ? uSER_NAME : "");
	}


	public String getCURRENT_MONTH_SALES() {
		//return CURRENT_MONTH_SALES;
		return (String) getObject(CURRENT_MONTH_SALES);
	}
	
	public void setCURRENT_MONTH_SALES(String cURRENT_MONTH_SALES) {
		//CURRENT_MONTH_SALES = cURRENT_MONTH_SALES;
		setObject(CURRENT_MONTH_SALES, (cURRENT_MONTH_SALES != null) ? cURRENT_MONTH_SALES : "");
	}

	public String getPREV_MONTH_SALES() {
		return (String) getObject(PREV_MONTH_SALES);
		//return PREV_MONTH_SALES;
	}

	public void setPREV_MONTH_SALES(String pREV_MONTH_SALES) {
		PREV_MONTH_SALES = pREV_MONTH_SALES;
		setObject(PREV_MONTH_SALES, (pREV_MONTH_SALES != null) ? pREV_MONTH_SALES : "");
	}
	
	public String getSales_Difference() {
		//return Sales_Difference;
		return (String) getObject(Sales_Difference);
	}

	public void setSales_Difference(String sales_Difference) {
		//Sales_Difference = sales_Difference;
		setObject(Sales_Difference, (sales_Difference != null) ? sales_Difference : "");
	}


	public String toString() {
		System.out.println("toString start----------------");
		String theItemName = "";
		theItemName = getUSER_ID()+"   "+getUSER_NAME()+"   "+getCURRENT_MONTH_SALES()+"   "+getPREV_MONTH_SALES()+"   "+getSales_Difference();
		System.out.println("toString end----------------");
		
		return theItemName;
	}

}
