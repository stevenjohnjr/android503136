package com.mike.Make2;



import java.text.SimpleDateFormat;
import java.util.Calendar;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;


public class request extends Activity {
	private Button schedule,contacts,event,request;
	TextView display,displayTime;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		 setContentView(R.layout.request);
		
			
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
	        display.setText("Request");

		schedule.setOnClickListener( new OnClickListener()
		{
			public void onClick( View v )
			{
				display.setBackgroundColor( 0xfff00000 );
				display.setText( "Daily Schedule!" );
				mp.start();
				final Intent i = new Intent( request.this, contacts.class );
				startActivity( i );
			}
		} );
		contacts.setOnClickListener( new View.OnClickListener()
		{
			public void onClick( View v )
			{
				display.setBackgroundColor( 0xfff00000 );
				display.setText( "Contacts!" );
				mp.start();
				final Intent i = new Intent( request.this, contacts.class );
				startActivity( i );
			}
		} );
		event.setOnClickListener( new View.OnClickListener()
		{
			public void onClick( View v )
			{
				display.setBackgroundColor( 0xfff00000 );
				display.setText( "Events!" );
				final Intent i = new Intent( request.this, contacts.class );
				startActivity( i );
				mp.start();
			}
		} );
		request.setOnClickListener( new View.OnClickListener()
		{
			public void onClick( View v )
			{
				display.setBackgroundColor( 0xfff00000 );
				display.setText( "Request!" );
				mp.start();

			}
		} );

	}

}