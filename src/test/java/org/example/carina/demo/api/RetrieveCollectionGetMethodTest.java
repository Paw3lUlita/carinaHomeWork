package org.example.carina.demo.api;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.api.annotation.QueryParam;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;

import static org.testng.Assert.*;

public class RetrieveCollectionGetMethodTest implements IAbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private static final String API_KEY = "NmrYpUAIdhsOs8C3KCRK7emmcNzud_ZwkrUK9QAU-KI";

    @Test()
    @MethodOwner(owner = "pawelUlita")
    public void whenIdParamIsWrongEndpointShouldReturnErrorCodeAndErrorResponse() {
        RetrieveCollectionGetMethod retrieveCollectionGetMethod = new RetrieveCollectionGetMethod("er");
        retrieveCollectionGetMethod.addUrlParameter("client_id", API_KEY);
        retrieveCollectionGetMethod.expectResponseStatus(HttpResponseStatusType.NOT_FOUND_404);
        retrieveCollectionGetMethod.callAPI();
        retrieveCollectionGetMethod.validateResponseAgainstSchema("api/retrieveCollection/_get/errorRs.schema");

    }

    @Test()
    @MethodOwner(owner = "pawelUlita")
    public void whenProperIdParamIsPassedEndpointShouldReturnProperResponseAndStatus() {
        RetrieveCollectionGetMethod retrieveCollectionGetMethod = new RetrieveCollectionGetMethod("1");
        retrieveCollectionGetMethod.addUrlParameter("client_id", API_KEY);
        retrieveCollectionGetMethod.callAPIExpectSuccess();
        retrieveCollectionGetMethod.validateResponseAgainstSchema("api/retrieveCollection/_get/rs.schema");
    }
}