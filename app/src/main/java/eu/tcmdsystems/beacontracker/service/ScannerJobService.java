package eu.tcmdsystems.beacontracker.service;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.util.Log;

public class ScannerJobService extends JobService {

    private static final String TAG = "ScannerJobService";




    @Override
    public boolean onStartJob(JobParameters params) {
        Log.d(TAG, "onStartJob: ");

        scanForBeacons(params);
        return true;
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        Log.d(TAG, "onStopJob: ");
        // whether or not you would like JobScheduler to automatically retry your failed job.
        return false;
    }

    private void scanForBeacons(JobParameters params) {
        // I am on the main thread, so if you need to do background work,
        // be sure to start up an AsyncTask, Thread, or IntentService!
        Log.d(TAG, "scanForBeacons: finish job ");
        jobFinished(params,false);
    }
}
