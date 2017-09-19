package eu.tcmdsystems.beacontracker;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class ScannerIntentService extends IntentService {
    // TODO: Rename actions, choose action names that describe tasks that this
    // IntentService can perform, e.g. ACTION_FETCH_NEW_ITEMS
    private static final String ACTION_SCAN_FOR_BEACONS = "eu.tcmdsystems.beacontracker.action.SCAN";
    //private static final String ACTION_BAZ = "eu.tcmdsystems.beacontracker.action.BAZ";

    // TODO: Rename parameters
    private static final String EXTRA_RECEIVER = "eu.tcmdsystems.beacontracker.extra.RECEIVER";
    //private static final String EXTRA_PARAM2 = "eu.tcmdsystems.beacontracker.extra.PARAM2";

    public ScannerIntentService() {
        super("ScannerIntentService");
    }

    /**
     * Starts this service to perform action Foo with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    // TODO: Customize helper method
    public static void startActionScan(Context context, String mReceiver) {
        Intent intent = new Intent(context, ScannerIntentService.class);
        intent.setAction(ACTION_SCAN_FOR_BEACONS);
        intent.putExtra(EXTRA_RECEIVER, mReceiver);
        context.startService(intent);
    }

    /**
     * Starts this service to perform action Baz with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    // TODO: Customize helper method
 /*   public static void startActionBaz(Context context, String param1, String param2) {
        Intent intent = new Intent(context, ScannerIntentService.class);
        intent.setAction(ACTION_BAZ);
        intent.putExtra(EXTRA_PARAM1, param1);
        intent.putExtra(EXTRA_PARAM2, param2);
        context.startService(intent);
    }
*/
    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_SCAN_FOR_BEACONS.equals(action)) {
                final String param1 = intent.getStringExtra(EXTRA_RECEIVER);
                handleActionScan(param1);

            }
        }
    }

    /**
     * Handle action Foo in the provided background thread with the provided
     * parameters.
     */
    private void handleActionScan(String param1) {
        // TODO: Handle action Foo
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * Handle action Baz in the provided background thread with the provided
     * parameters.
     */
  /*  private void handleActionBaz(String param1, String param2) {
        // TODO: Handle action Baz
        throw new UnsupportedOperationException("Not yet implemented");
    }
    */

}
