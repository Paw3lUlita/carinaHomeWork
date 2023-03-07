package org.example.carina.demo.api;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;

public class SearchPhotoGetMethodTest implements IAbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private static final String API_KEY = "NmrYpUAIdhsOs8C3KCRK7emmcNzud_ZwkrUK9QAU-KI";

    @Test()
    @MethodOwner(owner = "pawelUlita")
    public void whenQueryIsMissingEndpointShouldReturnErrorCodeAndErrorResponse() {
        SearchPhotoGetMethod searchPhotoGetMethod = new SearchPhotoGetMethod();
        searchPhotoGetMethod.addUrlParameter("client_id", API_KEY);
        searchPhotoGetMethod.expectResponseStatus(HttpResponseStatusType.BAD_REQUEST_400);
        searchPhotoGetMethod.callAPI();
        searchPhotoGetMethod.validateResponseAgainstSchema("api/users/_get/errorRs.schema");

    }

    @Test()
    @MethodOwner(owner = "pawelUlita")
    public void whenQueryParameterIsPassedEndpointShouldReturnProperResponseAndStatus() {
        SearchPhotoGetMethod searchPhotoGetMethod = new SearchPhotoGetMethod();
        searchPhotoGetMethod.addUrlParameter("client_id", API_KEY);
        searchPhotoGetMethod.addUrlParameter("query", "cat");
        searchPhotoGetMethod.callAPIExpectSuccess();
        searchPhotoGetMethod.validateResponseAgainstSchema("api/users/_get/rs.schema");
    }
}
