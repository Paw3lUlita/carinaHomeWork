package org.example.carina.demo.api;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.Endpoint;
import com.qaprosoft.carina.core.foundation.api.annotation.ResponseTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.SuccessfulHttpStatus;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.Configuration;

@Endpoint(url = "${base_url}/search/photos/", methodType = HttpMethodType.GET)
@ResponseTemplatePath(path = "api/searchPhoto/_get/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class SearchPhotoMethod extends AbstractApiMethodV2 {

    public SearchPhotoMethod() {

        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
        addUrlParameter("client_id", Configuration.getEnvArg("api_key") );
    }
}

