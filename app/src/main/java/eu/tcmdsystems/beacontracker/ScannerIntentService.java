package eu.tcmdsystems.beacontracker;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.os.ResultReceiver;
import android.util.Log;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class ScannerIntentService extends IntentService {

    private static final String ACTION_BTLE = Constants.BTLE_SCAN;

    private static final String EXTRA_RECEIVER = "eu.tcmdsystems.beacontracker.extra.RECEIVER";
    private static final String TAG = "ScannerIntentService";


    public ScannerIntentService() {
        super("ScannerIntentService");
    }




    @Override
    protected void onHandleIntent(Intent intent) {
        Log.d(TAG, "onHandleIntent: ");
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_BTLE.equals(action)) {
                final ResultReceiver receiver = (ResultReceiver) intent.getExtras().get(EXTRA_RECEIVER);
                handleActionScan(receiver);

            }
        }
    }

    /**
     * Handle action in the provided background thread with the provided
     * parameters.
     */
    private void handleActionScan(ResultReceiver receiver) {
        // TODO: Handle action Foo
        Log.d(TAG, "handleActionScan: test receiver ");

        if (receiver == null) {
            return;
        }

        Log.d(TAG, "handleActionScan: receiver send 0 ");
            receiver.send(0, null);
            return;

    }



}
