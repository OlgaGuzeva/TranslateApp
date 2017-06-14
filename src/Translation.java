
public class Translation {
	public String code;
	public String lang;
	public String[] text;
	    
	public void say(){
	   	for(String row : text){
	   		System.out.println(row);
	  	}
	}
	
}

