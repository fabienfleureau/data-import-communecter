package com.eiko.app.api.client;

import com.eiko.app.api.model.Credentials;
import com.eiko.app.api.model.Store;
import com.eiko.app.api.model.StoreID;
import com.eiko.app.api.model.Token;
import com.eiko.app.importers.communecter.api.core.Paginated;
import com.eiko.app.importers.communecter.model.Organization;
import feign.Body;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

public interface EikoAppClient {


    @RequestLine("POST /register")
    @Headers("Content-Type: application/json")
    Token register(Credentials credentials);

    @RequestLine("POST /login")
    @Headers("Content-Type: application/json")
    Token login(Credentials credentials);

    @RequestLine("POST /store/add")
    @Headers({"Content-Type: application/json",
            "Cookie: token={token}"})
    String addStore(Store store, @Param("token") Token token);

    @RequestLine("POST /store/get")
    @Headers({"Content-Type: application/json",
            "Cookie: token={token}"})
    String getStore(Store store, @Param("token") Token token);

    @RequestLine("POST /store/delete")
    @Headers({"Content-Type: application/json",
            "Cookie: token={token}"})
    String deleteStore(StoreID storeId, @Param("token") Token token);
}
