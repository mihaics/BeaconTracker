package eu.tcmdsystems.beacontracker;

import android.Manifest;
import android.app.AlertDialog;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.bluetooth.BluetoothAdapter;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import eu.tcmdsystems.beacontracker.service.ScannerJobService;

public class MainActivity extends AppCompatActivity  {

    private static final String TAG = MainActivity.class.getName();
    private static final int PERMISSION_REQUEST_LOCATION = 1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //well, let's see if it is usefull
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //beacon list view
        //pass the object or make it global?
        //este initializat, dar cum comunicam cu el?
        ListView beaconlistview = (ListView) findViewById(R.id.beacon_list);


        //fab, we can use it to force a new scan
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               //startBeaconScanner();
            }
        });


        checkPermissions();
        enableBluetooth();
        //schedule the job service
        scheduleBeaconScanner(this);
        
    }


    private void scheduleBeaconScanner(Context context) {

        Log.d(TAG, "scheduleBeaconScanner: ");
        ComponentName component = new ComponentName(context, ScannerJobService.class);
        JobInfo.Builder builder = new JobInfo.Builder(Constants.JOB_ID, component)
                .setPeriodic(Constants.ONE_MIN)
                .setPersisted(true);

        JobScheduler jobScheduler = (JobScheduler) context.getSystemService(Context.JOB_SCHEDULER_SERVICE);
        jobScheduler.schedule(builder.build());

    }

    private void checkPermissions() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            // Android M Permission check
            if (this.checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                //    final AlertDialog.Builder builder = new AlertDialog.Builder(this);
                //    builder.setTitle(R.string.location_access_title);
                //    builder.setMessage(R.string.location_access_message);
                //   builder.setPositiveButton(android.R.string.ok, null);
                //    builder.setOnDismissListener(new DialogInterface.OnDismissListener() {

                //       @RequiresApi(api = Build.VERSION_CODES.M)
                //        public void onDismiss(DialogInterface dialog) {
                requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, PERMISSION_REQUEST_LOCATION);
                //      }
                //   });
                //   builder.show();
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case PERMISSION_REQUEST_LOCATION: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.

                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                    final AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setTitle(R.string.location_access_title);
                    builder.setMessage(R.string.location_access__deny_message);
                    builder.setPositiveButton(android.R.string.ok, null);
                    builder.setOnDismissListener(new DialogInterface.OnDismissListener() {

                        @RequiresApi(api = Build.VERSION_CODES.M)
                        public void onDismiss(DialogInterface dialog) {
                            MainActivity.this.finish();
                        }
                    });
                    builder.show();

                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void enableBluetooth() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if(bluetoothAdapter != null) {
            bluetoothAdapter.enable();
        }
    }
}
