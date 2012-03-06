package com.mike.Make2;


import java.text.SimpleDateFormat;
import java.util.Calendar;

import android.app.Activity;
import android.content.Intent;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class Make2Activity extends Activity {


	private Button schedule,contacts,event,request;
	TextView display,displayTime;

    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
		
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.button_click); 
        schedule = (Button) findViewById (R.id.bSchedule);
        contacts = (Button) findViewById (R.id.bContacts);
        event = (Button) findViewById (R.id.bEvent);
        request = (Button) findViewById (R.id.bRequest);             
        display = (TextView) findViewById (R.id.tvDisplay);
        displayTime = (TextView) findViewById (R.id.tvDisplayTime);

        
        Calendar c = Calendar.getInstance(); 
        System.out.println("Current time => "+c.getTime()); 
        SimpleDateFormat df = new SimpleDateFormat("MM-dd-yyyy"); 
        String formattedDate = df.format(c.getTime()); 
        SimpleDateFormat df2 = new SimpleDateFormat("hh:mm"); 
        String formattedDate2 = df2.format(c.getTime()); 
        displayTime.setText("Todays Date: "+formattedDate + "     Time: "+formattedDate2);   
        
        display.setBackgroundColor(0xfff00000);      	   
        display.setText("Daily Schedule!");       

        ListView listView = (ListView) findViewById(R.id.list);
        String[] values = new String[] { "12 PM", "1 PM  (Lunch @ 1:20PM)\n"+"           Pending Invites: Lashaundra ", "2 PM",
        	"3 PM", "4 PM", "5 PM", "6 PM", "7 PM",
        	"8 PM", "9 PM","10 PM","11 PM","12 AM",
        	"1 AM","2 AM","3 AM","4 AM","5 AM","6 AM", 
        	"7 AM","8 AM","9 AM","10 AM","11 AM"};
        
  
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
        android.R.layout.two_line_list_item, android.R.id.text1, values);
        listView.setAdapter(adapter);
	
        listView.setOnItemClickListener(new OnItemClickListener() {
        	
        	public void onItemClick(AdapterView<?> parent, View view,
        		int position, long id) {
        		Toast.makeText(getApplicationContext(),
        			"You pressed " + position, Toast.LENGTH_SHORT)
        			.show();
        	}
        });
        		      
       schedule.setOnClickListener(new OnClickListener() 
       {
    	  
           public void onClick(View v) 
           {	
 	           display.setBackgroundColor(0xfff00000);      	   
 	           display.setText("Daily Schedule!");  	     
        	   mp.start();  

           }
          
           
       });    		
        		
        
        
        contacts.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
		    display.setBackgroundColor(0xfff00000); 	
	        display.setText("Contacts!");
	        mp.start(); 
      	    final Intent i = new Intent(Make2Activity.this, contacts.class);
      	    startActivity(i); 
				
			}
		});
        
        
        event.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
			display.setBackgroundColor(0xfff00000); 	
	        display.setText("Events!");
	        mp.start(); 
      	    final Intent i = new Intent(Make2Activity.this, event.class);
      	    startActivity(i); 
				
			}
		});
        
        
        request.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
			display.setBackgroundColor(0xfff00000); 	
	        display.setText("Request!");
	        mp.start(); 
      	    final Intent i = new Intent(Make2Activity.this, request.class);
      	    startActivity(i); 
				
				
			}
		});     


    }
}