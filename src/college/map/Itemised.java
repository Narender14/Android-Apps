package college.map;



import android.util.Log;
import android.view.MotionEvent;
import android.widget.Toast;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.MapView;
import com.google.android.maps.OverlayItem;
import java.util.ArrayList;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.Drawable;


public class Itemised extends  ItemizedOverlay<OverlayItem> {
	
	
	private ArrayList<OverlayItem> mapOverlays = new ArrayList<OverlayItem>();
	 
    private Context Context;

    public Itemised(Drawable defaultMarker) {
         super(boundCenterBottom(defaultMarker));
    }

    public Itemised(Drawable defaultMarker, Context context) {
         this(defaultMarker);
        Context = context;
    }

    @Override
    protected OverlayItem createItem(int i) {
       return mapOverlays.get(i);
    }

    @Override
    public int size() {
       return mapOverlays.size();
    }

    @Override
    protected boolean onTap(int index) {
       Log.e("Tap", "Tap Performed");
       
     OverlayItem item = mapOverlays.get(index);
       AlertDialog.Builder dialog = new AlertDialog.Builder(Context);
       dialog.setTitle(item.getTitle());
       dialog.setMessage(item.getSnippet());
       dialog.show();
       
       return true;
    }

    public void addOverlay(OverlayItem overlay) {
       mapOverlays.add(overlay);
        this.populate();
    }
    
    
    /*................. Add this method ........
    @Override
    public boolean onTouchEvent(MotionEvent event, MapView mapView)
    {   

        if (event.getAction() == 1) {
            GeoPoint geopoint = mapView.getProjection().fromPixels(
                (int) event.getX(),
                (int) event.getY());
            // latitude
            double lat = geopoint.getLatitudeE6() / 1E6;
            // longitude
            double lon = geopoint.getLongitudeE6() / 1E6;
            Toast.makeText(context, "Lat: " + lat + ", Lon: "+lon, Toast.LENGTH_SHORT).show();
        }
        return false;
    } 
    
    
    */
    
  }
	

