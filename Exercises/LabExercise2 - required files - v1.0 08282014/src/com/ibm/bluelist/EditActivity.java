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


import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

import com.ibm.mobile.services.data.IBMDataException;
import com.ibm.mobile.services.data.IBMDataObject;
import com.ibm.mobile.services.data.IBMObjectResult;
import com.ibm.mobile.services.data.IBMQuery;
import com.ibm.mobile.services.data.IBMQueryResult;

public class EditActivity extends Activity {

	String originalItem;
	int location;
	BlueListApplication blApplication;
	List<Employee> itemList;
	public static final String CLASS_NAME="EditActivity";
	
	Button memberUpdateButton;
	
	@Override
	/**
	 * onCreate called when edit activity is created.
	 * 
	 * Sets up the application, sets listeners, and gets intent info from calling activity
	 *
	 * @param savedInstanceState
	 */
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		/*get application context, item list*/
		blApplication = (BlueListApplication) getApplicationContext();
		itemList = blApplication.getItemList();
		setContentView(R.layout.activity_edit);
		
		/*information required to edit item*/
		Intent intent = getIntent();
	    originalItem = intent.getStringExtra("ItemText");
	    location = intent.getIntExtra("ItemLocation", 0);
	    System.out.println("index position-----------------"+location);
	    Employee selectedEmp = itemList.get(location);
	    System.out.println(selectedEmp.getNAME()+"--------"+selectedEmp.getAGE()+"-------"+selectedEmp.getADDRESS());
	    
		EditText memberName = (EditText) findViewById(R.id.memberName);
		memberName.setText(selectedEmp.getNAME());
		
		EditText memberAge = (EditText) findViewById(R.id.memberAge);
		memberAge.setText(selectedEmp.getAGE());
		
		EditText memberAddress = (EditText) findViewById(R.id.memberAddress);
		memberAddress.setText(selectedEmp.getADDRESS());
		
		
		
		memberUpdateButton = (Button) findViewById(R.id.memberUpdateButton);
		 
		memberUpdateButton.setOnClickListener(new OnClickListener() {
 
			@Override
			public void onClick(View view) {

				System.out.println("setOnClickListener on click called");
				finishedEdit(view);
				
				//System.out.println(memberName.getText().toString()+"---"+memberAge.getText().toString()+"---"+memberAddress.getText().toString());
 
			}
 
		});
		
		
		
		
		/*set key listener for edittext (done key to accept item to list)*/
		memberName.setOnEditorActionListener(new OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId==EditorInfo.IME_ACTION_DONE){
                	System.out.println("finish edit is call");
                	finishedEdit(v);
                    return true;
                }
                return false;
            }
        });
	}

	/**
	 * on completion of edit, edit itemList, return to main activity with edit return code
	 * @param View v
	 */
	public void finishedEdit(View v) {
		System.out.println("method finishedEdit is called");
		
		Employee item = itemList.get(location);
		
	    Employee selectedEmp = itemList.get(location);
	    System.out.println(selectedEmp.getNAME()+"--------"+selectedEmp.getAGE()+"-------"+selectedEmp.getADDRESS());
	    
		EditText memberName = (EditText) findViewById(R.id.memberName);
		String memberNameStr = memberName.getText().toString();
		item.setNAME(memberNameStr);
		//memberName.setText(selectedEmp.getNAME());
		
		EditText memberAge = (EditText) findViewById(R.id.memberAge);
		String memberAgeStr = memberAge.getText().toString();
		item.setAGE(memberAgeStr);
		
		EditText memberAddress = (EditText) findViewById(R.id.memberAddress);
		String memberAddressStr = memberAddress.getText().toString();
		item.setADDRESS(memberAddressStr);
		
		/**
		 * IBMObjectResult is used to handle the response from the server after 
		 * either creating or saving an object.
		 * 
		 * onResult is called if the object was successfully saved
		 * onError is called if an error occurred saving the object 
		 */
		item.save();
//		item.saveInBackground(new IBMObjectResult<Employee>() {
//			public void onResult(Employee object) {
//				if (!isFinishing()) {
//					runOnUiThread(new Runnable() {
//						public void run() {
//							/*
//							Intent returnIntent = new Intent();
//							setResult(BlueListApplication.EDIT_ACTIVITY_RC, returnIntent);
//							finish();
//							*/
//							Intent intent = new Intent(EditActivity.this,MainActivity.class);
//							//intent.putExtra("myDataArray", names);
//							startActivity(intent);
//							
//						}
//					});
//				}
//			}
//			public void onError(IBMDataException error) {
//				Log.e(CLASS_NAME, "Exception : " + error.getMessage());
//			}
//		});
	}
}
