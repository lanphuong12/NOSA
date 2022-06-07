package com.example.myapplication.Server;

public class APIService {

    private static String base_url = "https://datn-nosa.herokuapp.com/api/";

    public static Dataservice getService(){
        return APIRetrfitClient.getClient(base_url).create(Dataservice.class);
    }
}
