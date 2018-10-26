package com.example.alumno.services;

import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.IBinder;
import android.util.Log;

import java.net.URL;

public class HelloService extends Service {
    private String servicesTag = "SERVICE TAG:";
    private String AsyncTag = "ASYNC TAG:";
    private Boolean isRunning = false;

    public HelloService() {

    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(servicesTag,"Create MSG");
        isRunning = true;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(servicesTag,"Start MSG");
        new Thread(new Runnable() {
            @Override
            public void run() {


                DownLoaderAsync downLoaderAsync = new DownLoaderAsync();
                downLoaderAsync.execute();

                //Stop service once it finishes its task
                stopSelf();
            }
        }).start();

        return Service.START_STICKY;

    }

    @Override
    public void onDestroy() {
        Log.d(servicesTag,"Destroy MSG");
        isRunning = false;
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
    public class DownLoaderAsync extends AsyncTask <URL, Integer, String>{

        public DownLoaderAsync() {
            super();
        }

        @Override
        protected String doInBackground(URL... urls) {
            Log.d(AsyncTag, "doInBackground MSG");
            return null;
        }

        @Override
        protected void onPreExecute() {
            Log.d(AsyncTag, "onPreExecute MSG");
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(String s) {
            Log.d(AsyncTag, "onPostExecute MSG");
            super.onPostExecute(s);
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            Log.d(AsyncTag, "onProgressUpdate MSG");
            super.onProgressUpdate(values);
        }
    }
}
