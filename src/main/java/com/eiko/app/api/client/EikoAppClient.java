package com.eiko.app.api.client;

import com.eiko.app.api.model.Credentials;
import com.eiko.app.api.model.Result;
import com.eiko.app.api.model.Store;
import com.eiko.app.api.model.StoreID;
import com.eiko.app.api.model.Token;
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
    Result addStore(Store store, @Param("token") String token);

    @RequestLine("POST /store/get")
    @Headers({"Content-Type: application/json",
            "Cookie: token={token}"})
    Store getStore(Store store, @Param("token") String token);

    @RequestLine("POST /store/delete")
    @Headers({"Content-Type: application/json",
            "Cookie: token={token}"})
    Result deleteStore(StoreID storeId, @Param("token") String token);
}
