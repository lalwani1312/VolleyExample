package com.example.hitesh_pc.volleyexample.volley;

/**
 * Created by Hitesh-PC on 27-08-2016.
 */
public class VolleySingleton {
    private static VolleySingleton sInstance = new VolleySingleton();

    public static VolleySingleton getInstance() {
        return sInstance;
    }

    private VolleySingleton() {
    }

    

}
