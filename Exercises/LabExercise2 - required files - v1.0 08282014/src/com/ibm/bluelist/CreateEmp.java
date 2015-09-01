package com.ibm.bluelist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.ibm.mobile.services.data.IBMDataException;
import com.ibm.mobile.services.data.IBMObjectResult;

public class CreateEmp extends Activity 
{
	
	Button memberCreateButton;
	Button memberListButton;
	EditText memberName, memberAge, memberAddress;
	
	//String [] names = {"1","1A7", "Manendra","May"};
	
	//On create method for activity.
	@Override
	public void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);	
		setContentView(R.layout.create_emp);
		
		
		memberListButton = (Button) findViewById(R.id.memberListButton);
		 
		memberListButton.setOnClickListener(new OnClickListener() {
 
			@Override
			public void onClick(View arg0) {
			    Intent intent = new Intent(CreateEmp.this,MainActivity.class);
				//intent.putExtra("myDataArray", names);
				startActivity(intent);
 
			}
 
		});
		
		
		memberCreateButton = (Button) findViewById(R.id.memberCreateButton);
		 
		memberCreateButton.setOnClickListener(new OnClickListener() {
 
			@Override
			public void onClick(View view) {

				System.out.println("setOnClickListener on click called");
				createItem(view);
				
				//System.out.println(memberName.getText().toString()+"---"+memberAge.getText().toString()+"---"+memberAddress.getText().toString());
 
			}
 
		});
		

		
		
		
	}
	
	
	/**
	 * called on done and will add item to list.
	 *
	 * @param  v edittext View to get item from.
	 * @throws IBMDataException 
	 */
	public void createItem(View v) {
		
		System.out.println("create Item is called");
		EditText memberName = (EditText) findViewById(R.id.memberName);
		String memberNameStr = memberName.getText().toString();
		
		EditText memberAge = (EditText) findViewById(R.id.memberAge);
		String memberAgeStr = memberAge.getText().toString();
		
		EditText memberAddress = (EditText) findViewById(R.id.memberAddress);
		String memberAddressStr = memberAddress.getText().toString();
		
		Employee item = new Employee();
		//if (!memberNameStr.equals("")) {
		
		if(!memberNameStr.equals("") && !memberAgeStr.equals("") && !memberAddress.equals(""))
		{
			item.setNAME(memberNameStr);
			item.setAGE(memberAgeStr);
			item.setADDRESS(memberAddressStr);
			
			
			/**
			 * IBMObjectResult is used to handle the response from the server after 
			 * either creating or saving an object.
			 * 
			 * onResult is called if the object was successfully saved
			 * onError is called if an error occurred saving the object 
			 */
			item.save();
//			item.saveInBackground(new IBMObjectResult<Employee>() {
//				/**
//				 * If the result succeeds, onResult gets called with the object that was created.
//				 */
//				public void onResult(Employee object) {
//					if (!isFinishing()) {
//						System.out.println("successsssssssssssss");
//						//listItems();
//					}
//				}
//				/**
//				 * If the result failed, onError is called with an exception that describes the error.
//				 */
//				public void onError(IBMDataException error) {
//					//Log.e(CLASS_NAME, "Exception : " + error.getMessage());
//					System.out.println("Errrrrrrrrrrrrrrrrrrrrr");
//				}
//			});
//			
			
			
			System.out.println("create Item is finished");
			
			 Intent intent = new Intent(CreateEmp.this,MainActivity.class);
				//intent.putExtra("myDataArray", names);
			 startActivity(intent);
			 
			 /// Set All the fields blank
			 memberName.setText("");
			 memberAge.setText("");
			 memberAddress.setText("");
		}
		
			
			
			

			
			
			//set text field back to empty after item added
			//itemToAdd.setText("");
		//}
	}
	
	
	
	
	
	
}