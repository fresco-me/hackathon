package io.openliberty.guides.hello.it;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;

public class EndpointIT {
    private static String webURL;

    @BeforeAll
    public static void init() {
        String port = System.getProperty("http.port");
        String context = System.getProperty("context.root");
        webURL = "http://localhost:" + port + "/" + context + "/" + "servlet";
        System.out.println("URL: " + webURL);
    }

    @Test
    public void testServlet() throws Exception {
        HttpClient httpClient = new HttpClient();
        GetMethod httpGetMethod = new GetMethod(webURL);
        try {
            int actualStatusCode = httpClient.executeMethod(httpGetMethod);
            int expectedStatusCode = HttpStatus.SC_OK;
            assertEquals(expectedStatusCode, actualStatusCode, "HTTP GET failed");
            String response = httpGetMethod.getResponseBodyAsString(1000);
            assertTrue(response.contains("Hello! Is Gradle working for you?"),
                    "Unexpected response body");
        } finally {
            httpGetMethod.releaseConnection();
        }
    }
}
