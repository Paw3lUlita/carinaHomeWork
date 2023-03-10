package org.example.carina.demo.api;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;

public class SearchPhotoMethodTest implements IAbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test()
    @MethodOwner(owner = "pawelUlita")
    public void whenQueryIsMissingEndpointShouldReturnErrorCodeAndErrorResponse() {
        SearchPhotoMethod searchPhotoMethod = new SearchPhotoMethod();
        searchPhotoMethod.expectResponseStatus(HttpResponseStatusType.BAD_REQUEST_400);
        searchPhotoMethod.callAPI();
        searchPhotoMethod.validateResponseAgainstSchema("api/searchPhoto/_get/rs_error.schema");

    }

    @Test()
    @MethodOwner(owner = "pawelUlita")
    public void whenQueryParameterIsPassedEndpointShouldReturnProperResponseAndStatus() {
        SearchPhotoMethod searchPhotoMethod = new SearchPhotoMethod();
        searchPhotoMethod.addUrlParameter("query", "cat");
        searchPhotoMethod.callAPIExpectSuccess();
        searchPhotoMethod.validateResponseAgainstSchema("api/searchPhoto/_get/rs.schema");
    }
}
