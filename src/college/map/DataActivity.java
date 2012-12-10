package college.map;


import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class DataActivity extends Activity{
	 /** Called when the activity is first created. */
	 Spinner   sp;
	 String text_c;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.maint);
	
        
        String credit[]=new String[]{"Insti.","IIT MADRAS","IIT DELHI","IIT BOMBAY","MIT"};
	
	
        
        ArrayAdapter<String> credits = 
            new ArrayAdapter<String> (this, 
            android.R.layout.simple_spinner_item,credit);
         sp = (Spinner)findViewById(R.id.Spinner1); 
       sp.setAdapter(credits);
	
       
       
    
       DataBS db=new DataBS(this);
    /*   
       db.add(new Store("28.55256","77.207537","AirWave Mobile Store"),"DELHI");
       db.add(new Store("28.546227","77.199769","Hotel Star Rock"),"DELHI");
       db.add(new Store("28.55158","77.164149","Dt. Cinemas"),"DELHI");
       db.add(new Store("28.552297","77.203932","MidLand Books"),"DELHI");
       long v=db.add(new Store("28.553465","77.23526","Pizza Hut"),"DELHI");
       
       
     Toast.makeText(getApplicationContext(), v + "hello", Toast.LENGTH_SHORT).show();
     
     */  
       
       
          
      /* db.add(new Store("42.366059","-71.104224","T-mobiles" ),"MIT");
       db.add(new Store("42.362508","-71.100125","Hotel@ MIT"),"MIT");
       db.add(new Store("42.367882","-71.090298","Kendall Square Cinema"),"MIT");
       db.add(new Store("42.36254","-71.085974","MIT Press Bookstore"),"MIT");
       long v=db.add(new Store("42.367232","-71.0921","Emma's Pizza"),"MIT");
       
       
     Toast.makeText(getApplicationContext(), v + "hello", Toast.LENGTH_SHORT).show();
     
      */
       
       
       
     
     //db.deleteContact();
       //Toast.makeText(getApplicationContext(),"Deleted", Toast.LENGTH_SHORT).show();
       
       
       Integer sd=db.getContactsCount("DELHI");
		 
		String z=new Integer(sd).toString();
		 
	Toast.makeText(getApplicationContext(),z,Toast.LENGTH_SHORT).show();
    
      
       
  /*  List<Store> contact = db.Display("DELHI");       
		
		    for (Store cn : contact) {
	            
		    	Toast.makeText(getApplicationContext(),cn.lon()+" "+cn.lat()+" " +cn.name(), Toast.LENGTH_SHORT).show();
		    	
		    	//String log = "Id: "+cn.ID()+" ,Name: " + cn.NAME() + " ,Phone: " + cn.AUTHOR();
		    	  
		    	//Toast.makeText(getApplicationContext(), "hiiii",Toast.LENGTH_SHORT).show();
	            
		    } 
	        
      */
		    
      
     }
    
  
    
    public void onClick(View v){
    switch(v.getId()){
    
   case R.id.button:
    text_c= sp.getSelectedItem().toString();
    Intent i=new Intent(getApplicationContext(),IcollegeActivity.class);
    	 i.putExtra("key",text_c);
  startActivity(i);
    
   }
    
    }
    
    
    
}