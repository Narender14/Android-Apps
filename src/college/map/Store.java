package college.map;

public class Store {
	
	String longit;
	String latit;
	String name;
	
	
	public Store(){
		
	}
	
	
	public Store(String a , String b , String c ){
		
		latit=a;
		longit=b;
		name=c;
	}
	
	public String lon(){
		
		return longit;
	}
	
	public String lat(){
		
		return latit;
	}
	
	
	public String name(){
		
		return name;
	}
	
	public void setLon(String a){
		
		longit=a;
	}
	
	
	public void setLat(String b){
		
		latit=b;
		
	}
	
	
	
	public void setName(String d){
		
		name=d;
	}
	
	
	
 }
