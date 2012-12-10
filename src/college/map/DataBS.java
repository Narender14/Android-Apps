package college.map;

import java.util.ArrayList;
import java.util.List;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;
import android.widget.TextView;

public class DataBS extends SQLiteOpenHelper {
	

	// All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;
 
    // Database Name
    private static final String DATABASE_NAME = "GPS";
    private static final String TABLE_ROPAR="ropar";
    private static final String TABLE_BOMBAY="bombay";
    private static final String TABLE_DELHI="delhi";
    private static final String TABLE_MIT="mit";

    
    
    // BOOK table name
    private static final String KEY_BID = "id";
    private static final String KEY_LONGI = "longi";
    private static final String KEY_LATI = "lati";
    private static final String KEY_NAME = "name";

    public DataBS(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        
        Log.d("INFO1","creating db"+DATABASE_NAME);
    }
    
    @Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
    	
    	
    	String TABLE_ONE = "CREATE TABLE " + TABLE_ROPAR + "("
        + KEY_BID + " INTEGER PRIMARY KEY," + KEY_LONGI + " TEXT,"
        + KEY_LATI + " TEXT," + KEY_NAME + " TEXT" + ")";
        
    db.execSQL(TABLE_ONE);
    
    
    
    String TABLE_TWO = "CREATE TABLE " + TABLE_BOMBAY + "("
    + KEY_BID + " INTEGER PRIMARY KEY," + KEY_LONGI + " TEXT,"
    + KEY_LATI + " TEXT," + KEY_NAME + " TEXT" + ")";
    
    db.execSQL(TABLE_TWO);
    
    
    
    
    
    String TABLE_THREE = "CREATE TABLE " + TABLE_DELHI + "("
    + KEY_BID + " INTEGER PRIMARY KEY," + KEY_LONGI + " TEXT,"
    + KEY_LATI + " TEXT," + KEY_NAME + " TEXT" + ")";
    
    db.execSQL(TABLE_THREE);
    									
    	 									
    	 		    	 									

    String TABLE_FOUR = "CREATE TABLE " + TABLE_MIT + "("
    + KEY_BID + " INTEGER PRIMARY KEY," + KEY_LONGI + " TEXT,"
    + KEY_LATI + " TEXT," + KEY_NAME + " TEXT" + ")";
	db.execSQL(TABLE_FOUR);
    	 		    	 		    	 					

				
    	 									
    	
 }

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
		 // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ROPAR);
     // Create tables again
        onCreate(db);
        
  // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_DELHI);
        // Create tables again
           onCreate(db);
   
           
           // Drop older table if existed
           db.execSQL("DROP TABLE IF EXISTS " + TABLE_BOMBAY);
        // Create tables again
           onCreate(db);
           
        // Drop older table if existed
           db.execSQL("DROP TABLE IF EXISTS " + TABLE_MIT);
           // Create tables again
              onCreate(db);
              
            
		
   }
	
	
		public long add(Store con,String which){
    	
			SQLiteDatabase db = this.getWritableDatabase();
			
			String table=TABLE_ROPAR;
			if(which.equals("ROPAR"))
				table=TABLE_ROPAR;
			else if(which.equals("BOMBAY"))
				table=TABLE_BOMBAY;
			else if(which.equals("DELHI"))
				table=TABLE_DELHI;
			else if(which.equals("MIT"))
				table=TABLE_MIT;
				
			 Log.d("INFO3","COMES INTO ADD");
			
		ContentValues value=new ContentValues();
    	value.put(KEY_LONGI,con.lon());
    	value.put(KEY_LATI,con.lat());
    	value.put(KEY_NAME,con.name());
    	long r=db.insert(table, null, value);
    	db.close();
    	 
    	return r;
    }
		
		public List<Store> Display(String which){
			
			
			String table=null;
			if(which.equals("IIT MADRAS"))
				table=TABLE_ROPAR;
			else if(which.equals("IIT BOMBAY"))
				table=TABLE_BOMBAY;
			else if(which.equals("IIT DELHI"))
				table=TABLE_DELHI;
			else if(which.equals("MIT"))
				table=TABLE_MIT;
			
			List<Store> P=new ArrayList<Store>();
	    	
	    	String qr="SELECT * FROM "+table;
	    	 SQLiteDatabase db = this.getWritableDatabase();
	    	Cursor cr=db.rawQuery(qr, null);
	    	
	    	if (cr.moveToFirst()) {
	            do {
	                Store contact = new Store();
	                contact.setLon(cr.getString(1));
	                contact.setLat(cr.getString(2));
	                contact.setName(cr.getString(3));
	                
	                    // Adding contact to list
	                P.add(contact);
	            } while (cr.moveToNext());
	        }
	 	   	return P;
			
	}
		
		
		 public int getContactsCount(String which) {
			 
			 String table=null;
				if(which.equals("ROPAR"))
					table=TABLE_ROPAR;
				else if(which.equals("BOMBAY"))
					table=TABLE_BOMBAY;
				else if(which.equals("DELHI"))
					table=TABLE_DELHI;
				else if(which.equals("MIT"))
					table=TABLE_MIT;
			 
				
			 
		        String countQuery = "SELECT  * FROM " +TABLE_DELHI;
		        SQLiteDatabase db = this.getReadableDatabase();
		        Cursor cursor = db.rawQuery(countQuery, null);
		        int z= cursor.getCount();
		        cursor.close();
		  return z;
		        
		        //return cursor.getCount();
		    }
		
		
		 
		// Deleting single contact
		    public void deleteContact() {
		        SQLiteDatabase db = this.getWritableDatabase();
		        db.delete(TABLE_DELHI, null,
		                null);
		        db.close();
		        
		        Log.d("INFO2","Deleting");
		    }
		
}////class ENDS 