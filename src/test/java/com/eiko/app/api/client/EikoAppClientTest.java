package com.eiko.app.api.client;

import com.eiko.app.api.model.Credentials;
import com.eiko.app.api.model.Store;
import com.eiko.app.api.model.StoreID;
import com.eiko.app.api.model.Token;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EikoAppClientTest {

    private EikoAppClient client;

    @BeforeEach
    public void setUp() throws Exception {
        client = Feign.builder()
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .target(EikoAppClient.class, "http://localhost:8008/api/");
    }

    @Test
    void getSetAndDelete() {

//       Token tokenR = client.register(new Credentials("titi@toto.com", "password"));
        Token token = client.login(new Credentials("titi@toto.com", "password"));

        Store store = new Store("store_name", "store_address", "store_country", "store_zip", "store_brand", "store_rating");
        String store1 = client.getStore(store, token);

        String s = client.addStore(store, token);
        String store2 = client.getStore(store, token);

        String deleteStore = client.deleteStore(new StoreID("store_name"), token);

        assertNotNull(store1);

    }
}