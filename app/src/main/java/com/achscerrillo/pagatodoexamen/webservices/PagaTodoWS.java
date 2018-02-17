package com.achscerrillo.pagatodoexamen.webservices;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by alejandrocerrillo on 17/02/18.
 */

public class PagaTodoWS {
    private static final PagaTodoWS ourInstance = new PagaTodoWS();
    private static final String PAGATODO_ENTPOINT = "https://agentemovil.pagatodo.com/AgenteMovil.svc/agMov/";
    private PagaTodo pagaTodo;

    public static PagaTodoWS getInstance() {
        return ourInstance;
    }

    private PagaTodoWS() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(PAGATODO_ENTPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        pagaTodo = retrofit.create(PagaTodo.class);
    }

    public PagaTodo getPagaTodo() {
        return pagaTodo;
    }
}
