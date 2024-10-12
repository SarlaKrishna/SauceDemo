package pageObjects; 

import java.io.IOException;  
import java.net.HttpURLConnection;  
import java.net.URL;  
import java.net.URI;
import java.net.URISyntaxException; 

public class ApiPage {  
    private String url; 
    public ApiPage(String url) {  
        this.url = url;  
    }  

    public int makeGetRequest() throws URISyntaxException {  
        try {  
			URI obj = new URI(url);  
            URL url = obj.toURL();  
            HttpURLConnection connection = (HttpURLConnection) url.openConnection(); 
            connection.setRequestMethod("GET");  
            return connection.getResponseCode();  
        } catch (IOException e) {  
            e.getMessage();
            return -1; // Return -1 in case of an error  
        }  
    }  	
}