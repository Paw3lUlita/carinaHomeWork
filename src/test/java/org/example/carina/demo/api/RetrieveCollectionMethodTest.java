package org.example.carina.demo.api;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;

public class RetrieveCollectionMethodTest implements IAbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test()
    @MethodOwner(owner = "pawelUlita")
    public void retrieveCollectionWrongIdParamTest() {
        RetrieveCollectionMethod retrieveCollectionMethod = new RetrieveCollectionMethod("er");
        retrieveCollectionMethod.expectResponseStatus(HttpResponseStatusType.NOT_FOUND_404);
        retrieveCollectionMethod.callAPI();
        retrieveCollectionMethod.validateResponseAgainstSchema("api/retrieveCollection/_get/rs_error.schema");

    }

    @Test()
    @MethodOwner(owner = "pawelUlita")
    public void retirieveCollectionSuccesTest() {
        RetrieveCollectionMethod retrieveCollectionMethod = new RetrieveCollectionMethod("1");
        retrieveCollectionMethod.callAPIExpectSuccess();
        retrieveCollectionMethod.validateResponseAgainstSchema("api/retrieveCollection/_get/rs.schema");
    }
}
