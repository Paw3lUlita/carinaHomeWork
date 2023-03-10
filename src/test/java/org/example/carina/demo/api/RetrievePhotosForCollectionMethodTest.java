package org.example.carina.demo.api;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;

public class RetrievePhotosForCollectionMethodTest implements IAbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test()
    @MethodOwner(owner = "pawelUlita")
    public void whenIdParamIsWrongEndpointShouldReturnErrorCodeAndErrorResponse() {
        RetrievePhotosForCollectionMethod retrievePhotosForCollectionMethod = new RetrievePhotosForCollectionMethod("er");
        retrievePhotosForCollectionMethod.expectResponseStatus(HttpResponseStatusType.NOT_FOUND_404);
        retrievePhotosForCollectionMethod.callAPI();
        retrievePhotosForCollectionMethod.validateResponseAgainstSchema("api/retrievePhotosForCollection/_get/rs_error.schema");

    }

    @Test()
    @MethodOwner(owner = "pawelUlita")
    public void whenProperIdParamIsPassedEndpointShouldReturnProperResponseAndStatus() {
        RetrievePhotosForCollectionMethod retrievePhotosForCollectionMethod = new RetrievePhotosForCollectionMethod("1");;
        retrievePhotosForCollectionMethod.callAPIExpectSuccess();
        retrievePhotosForCollectionMethod.validateResponseAgainstSchema("api/retrievePhotosForCollection/_get/rs.schema");
    }
}