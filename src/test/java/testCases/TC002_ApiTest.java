package testCases; 

import org.testng.annotations.Test;  
import pageObjects.ApiPage;  

import static org.testng.Assert.assertEquals;

import java.net.URISyntaxException;  

public class TC002_ApiTest {  
    @Test (groups={"Master"})
    public void verifyGetRequestStatusCode() throws URISyntaxException {  
        // Define the API endpoint  
        String url = "https://reqres.in/api/users/2";  

        // Create an instance of ApiPage  
        ApiPage apiPage = new ApiPage(url);  

        // Make the GET request and get the response code  
        int responseCode = apiPage.makeGetRequest();  

        // Validate whether the response code is 200 or not  
        assertEquals(responseCode, 200, "Expected response code to be 200");  
    }  
}