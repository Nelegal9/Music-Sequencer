package com.samsung.myproject;

import android.app.Application;

public class App extends Application {
    private static Application application;

    public App() {
        application = this;
    }

    public static Application getApplication() {
        return application;
    }
}
