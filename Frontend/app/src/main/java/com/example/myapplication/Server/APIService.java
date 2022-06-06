package com.example.myapplication.Server;

public class APIService {

    private static String base_url = "http://localhost:8000/api/";

    public static Dataservice getService(){
        return APIRetrfitClient.getClient(base_url).create(Dataservice.class);
    }
}
