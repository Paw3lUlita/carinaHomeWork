package org.example.carina.demo.api;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;

public class retrievePhotosForCollectionGetMethodTest implements IAbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private static final String API_KEY = "NmrYpUAIdhsOs8C3KCRK7emmcNzud_ZwkrUK9QAU-KI";

    @Test()
    @MethodOwner(owner = "pawelUlita")
    public void whenIdParamIsWrongEndpointShouldReturnErrorCodeAndErrorResponse() {
        RetrievePhotosForCollectionGetMethod retrievePhotosForCollectionGetMethod = new RetrievePhotosForCollectionGetMethod("er");
        retrievePhotosForCollectionGetMethod.addUrlParameter("client_id", API_KEY);
        retrievePhotosForCollectionGetMethod.expectResponseStatus(HttpResponseStatusType.NOT_FOUND_404);
        retrievePhotosForCollectionGetMethod.callAPI();
        retrievePhotosForCollectionGetMethod.validateResponseAgainstSchema("api/retrievePhotosForCollection/_get/errorRs.schema");

    }

    @Test()
    @MethodOwner(owner = "pawelUlita")
    public void whenProperIdParamIsPassedEndpointShouldReturnProperResponseAndStatus() {
        RetrievePhotosForCollectionGetMethod retrievePhotosForCollectionGetMethod = new RetrievePhotosForCollectionGetMethod("1");;
        retrievePhotosForCollectionGetMethod.addUrlParameter("client_id", API_KEY);
        retrievePhotosForCollectionGetMethod.callAPIExpectSuccess();
        retrievePhotosForCollectionGetMethod.validateResponseAgainstSchema("api/retrievePhotosForCollection/_get/rs.schema");
    }
}