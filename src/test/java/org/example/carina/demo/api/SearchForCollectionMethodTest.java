package org.example.carina.demo.api;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;

public class SearchForCollectionMethodTest implements IAbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test()
    @MethodOwner(owner = "pawelUlita")
    public void searchForCollectionMissingQueryTest() {
        SearchForCollectionMethod searchForCollectionMethod = new SearchForCollectionMethod();
        searchForCollectionMethod.expectResponseStatus(HttpResponseStatusType.BAD_REQUEST_400);
        searchForCollectionMethod.callAPI();
        searchForCollectionMethod.validateResponseAgainstSchema("api/searchCollection/_get/rs_error.schema");

    }

    @Test()
    @MethodOwner(owner = "pawelUlita")
    public void searchForCollectionSuccesTest() {
        SearchForCollectionMethod searchForCollectionMethod = new SearchForCollectionMethod();
        searchForCollectionMethod.addUrlParameter("query", "cat");
        searchForCollectionMethod.callAPIExpectSuccess();
        searchForCollectionMethod.validateResponseAgainstSchema("api/searchCollection/_get/rs.schema");
    }
}
