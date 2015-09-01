package com.ibm.bluelist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;


/* Activity name : SplashScreen
 * Author: Manendra Rawat
 * This activity have button which will perform action on long
 * press and open the desired screen using on click listener.
 */
public class SplashScreen extends Activity 
{
	
	//String [] names = {"1","1A7", "Manendra","May"};
	
	//On create method for activity.
	@Override
	public void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);	
		setContentView(R.layout.splashpage);
		//Creating a thread for show the splash image for 2 seconds.
		Thread splashThread = new Thread()
		{
			@Override
			public void run()
			{
				int waited=0;
				try 
				{
					while(waited<2000)
					{			
						sleep(1000);
						waited+=1000;
					}
				} catch (InterruptedException e) 
				{
					e.printStackTrace(); 
				}
				finally
				{
					finish();				
					//Start home activity after 2 seconds
						Intent intent = new Intent(SplashScreen.this,CreateEmp.class);
						//intent.putExtra("myDataArray", names);
						startActivity(intent);
				
					//stop();
				}
			}
		};
		//Start the  thread
		splashThread.start();
	}

}
