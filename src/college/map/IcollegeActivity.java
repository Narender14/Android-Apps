package college.map;


import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.maps.GeoPoint; //lat and lon of a point
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;  //to move map around screen
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay; //drawable over map like a pinpoint
import com.google.android.maps.OverlayItem;




import java.util.List;



public class IcollegeActivity extends MapActivity {
	
	MapView mapView;
    MapController mc;
    private LocationManager lm;
    private LocationListener locationListener;
    Drawable draw;
    
    List<Overlay> mapOverlays;

    double lat1;
    double lon2;
    double lat3;
    double lon4;
    double lat5;
    double lon6;
    double lat7;
    double lon8;
    double lat9;
    double lon10;
    
    String name1;
    String name2;
    String name3;
    String name4;
    String name5;
    
    
    // Called when the activity is first created. 
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
   Log.d("hll","I an going");
        // Displaying Zooming controls
        mapView = (MapView) findViewById(R.id.mapView);
        
        
        
        mc= mapView.getController(); 
        
        
        
        
        
 /*     
    Log.d("hll","I reached here");
        
        double lat = Double.parseDouble("28.55256"); // latitude
        double lon = Double.parseDouble("77.207537"); // longitude
        
       // double lati = Double.parseDouble("48.856537"); // latitude
       // double loni = Double.parseDouble("2.291604"); // longitude
        
        GeoPoint geoPoint = new GeoPoint((int)(lat * 1E6), (int)(lon * 1E6));  // Returns the latitude of this GeoPoint in microdegrees (degrees * 1E6).
        
      //  GeoPoint geo = new GeoPoint((int)(lati * 1E6), (int)(loni * 1E6));
        
        Log.d("hll","I got u");
        mc.animateTo(geoPoint);
        //mc.animateTo(geo);
        mc.setZoom(8);
       mapView.invalidate();
        // To call onDraw() in future 
        
        Log.d("hll","I failed here");
     */  
        
        Intent ny=getIntent();
    	String s=ny.getExtras().getString("key");
        
        
        
        DataBS db=new DataBS(this);
        
        List<Store> contact = db.Display(s); 
        
		Integer k=1;
	    for (Store cn : contact) {
            
	    	//Toast.makeText(getApplicationContext(),cn.lon()+" "+cn.lat()+" " +cn.name(), Toast.LENGTH_SHORT).show();
	    	
	    	//String log = "Id: "+cn.ID()+" ,Name: " + cn.NAME() + " ,Phone: " + cn.AUTHOR();
	    	  
	    	//Toast.makeText(getApplicationContext(), "hiiii",Toast.LENGTH_SHORT).show();
            
	    	double lat=Double.parseDouble(cn.lat());
	    	double lon=Double.parseDouble(cn.lon());
	    	
	    	Put(lat,lon,cn.name(),k);
	    	//Toast.makeText(getApplicationContext(), lat + " " +lon, Toast.LENGTH_SHORT).show();
	    	//break;
	    	k++;
	    	
	    } 
	    
	    
        
      //  double lat1 = Double.parseDouble("48.85827758964043"); // latitude
        //double lon2 = Double.parseDouble("2.294543981552124"); // longitude
        
	   GeoPoint geo1 = new GeoPoint((int)(lat1 * 1E6), (int)(lon2 * 1E6));
        
	   mapOverlays= mapView.getOverlays();
        Drawable draw1 = this.getResources().getDrawable(R.drawable.yellow);
        Itemised itemized1 =
        new Itemised(draw1, this);
        OverlayItem overlayitem1 = new OverlayItem(geo1, "Mobile", name1);
        itemized1.addOverlay(overlayitem1);
        mapOverlays.add(itemized1);
	    
        
     GeoPoint geo2 = new GeoPoint((int)(lat3 * 1E6), (int)(lon4 * 1E6));
        
	   
        Drawable draw2 = this.getResources().getDrawable(R.drawable.red);
        Itemised itemized2 =
        new Itemised(draw2, this);
        OverlayItem overlayitem2 = new OverlayItem(geo2, "Hotel",name2);
        itemized2.addOverlay(overlayitem2);
        mapOverlays.add(itemized2);
        
        GeoPoint geo3 = new GeoPoint((int)(lat5 * 1E6), (int)(lon6 * 1E6));
        
 	   
        Drawable draw3 = this.getResources().getDrawable(R.drawable.green);
        Itemised itemized3 =
        new Itemised(draw3, this);
        OverlayItem overlayitem3 = new OverlayItem(geo3, "Multiplex",name3);
        itemized3.addOverlay(overlayitem3);
        mapOverlays.add(itemized3);
        
        
	    
        GeoPoint geo4 = new GeoPoint((int)(lat7 * 1E6), (int)(lon8 * 1E6));
        
 	   
        Drawable draw4 = this.getResources().getDrawable(R.drawable.blue);
        Itemised itemized4 =
        new Itemised(draw4, this);
        OverlayItem overlayitem4 = new OverlayItem(geo4, "Book Shop",name4);
        itemized4.addOverlay(overlayitem4);
        mapOverlays.add(itemized4);
        
	    
        GeoPoint geo5 = new GeoPoint((int)(lat9 * 1E6), (int)(lon10 * 1E6));
        
  	   
        Drawable draw5 = this.getResources().getDrawable(R.drawable.black);
        Itemised itemized5 =
        new Itemised(draw5,this);
        OverlayItem overlayitem5 = new OverlayItem(geo5, "Pizza Hut",name5);
        itemized5.addOverlay(overlayitem5);
        mapOverlays.add(itemized5);
       
  
        mc.animateTo(geo1);
        mc.animateTo(geo2);
        mc.animateTo(geo3);
        mc.animateTo(geo4);
        mc.animateTo(geo5);
        
        mc.setZoom(13);
        mapView.invalidate(); // To call onDraw() in future 

      //---use the LocationManager class to obtain GPS locations---
		lm = (LocationManager)
			getSystemService(Context.LOCATION_SERVICE);
			locationListener = new MyLocationListener();
				lm.requestLocationUpdates(
						LocationManager.GPS_PROVIDER,
						0,
						0,
						locationListener);

				draw = this.getResources().getDrawable(R.drawable.mark_red);
        
		}
    
    public void onPlus(View v){
    		
    		switch(v.getId()){
    		
    		case R.id.button1:
    			mc.zoomIn(); // Satellite View
    		
    		}
    		
    }
    
    
  	public void onMinus(View v){
		
		switch(v.getId()){
		case R.id.button2:
			mc.zoomOut(); 
			
		}
		
	}
  	
  	
  	
  	public void onStreet(View v){
		
		switch(v.getId()){
		
		
		case R.id.button3:
			 mapView.setStreetView(true);
			 mapView.setSatellite(false);
			 mapView.invalidate();
	
		}
		
	}
  	
  	
  	public void onSatellite(View v){
		
		switch(v.getId()){
		
		case R.id.button4:
			 mapView.setStreetView(false);
			 mapView.setSatellite(true);
			 mapView.invalidate();
	
		}
		
	}
  	
  	
  	public void Put(double a , double b , String n , int i){
  		
  		
  		if(i==1){
  			
  			lat1=a;
  			lon2=b;
  			name1=n;
  			
  		}
  		else if(i==2){
  			
  			lat3=a;
  			lon4=b;
  			name2=n;
  			
  		}
  		
  		else if(i==3){
  			
  			lat5=a;
  			lon6=b;
  			name3=n;
  			
  		}
  		
  		
  		else if(i==4){
		
		lat7=a;
		lon8=b;
		name4=n;
		
	}
  		
  		else if(i==5){
		
		lat9=a;
		lon10=b;
		name5=n;
		
	}
  		
 }
  	
  	
  	
  	
  	
  @Override
    protected boolean isRouteDisplayed() {
        return false;
    }
  
  
  private class MyLocationListener implements LocationListener
	{

		@Override
		public void onLocationChanged(Location loc) {
			if (loc != null) {
	//Toast.makeText(getBaseContext(),"Location changed : Lat: " + loc.getLatitude() + " Lng: " + loc.getLongitude(),
						//Toast.LENGTH_SHORT).show();
				
				//double latt=28.546001;
				//double loot=77.196894;
				
				
				
				GeoPoint p = new GeoPoint(
						(int) (loc.getLatitude() * 1E6),
						(int) (loc.getLongitude() * 1E6));
				
				
				/*	GeoPoint p = new GeoPoint(
				(int) (latt * 1E6),
				(int) (loot * 1E6));
		*/
				
				List<Overlay> map=mapView.getOverlays();
							Itemised itemized6 =
				        new Itemised(draw);
				        OverlayItem overlayitem5 = new OverlayItem(p, "Pizza Hut",name5);
				        itemized6.addOverlay(overlayitem5);
				        map.add(itemized6);
				
				
				        
				
				
				mc.animateTo(p);
				mc.setZoom(13);
				mapView.invalidate();
			}
		}
		@Override
		public void onProviderDisabled(String provider) {
			// TODO Auto-generated method stub
		}
		@Override
		public void onProviderEnabled(String provider) {
			// TODO Auto-generated method stub
		}
			@Override
			public void onStatusChanged(String provider, int status,
					Bundle extras) {
				// TODO Auto-generated method stub
			}
	}
  }
