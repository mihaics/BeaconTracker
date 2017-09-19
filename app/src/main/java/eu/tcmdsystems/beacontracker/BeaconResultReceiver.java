package eu.tcmdsystems.beacontracker;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;

/**
 * Created by mihai on 9/9/17.
 */

class BeaconResultReceiver extends ResultReceiver {
    private Receiver mReceiver;


    public BeaconResultReceiver(Handler handler) {
        super(handler);
    }

    public void setReceiver(Receiver receiver) {
        mReceiver = receiver;
    }


    public interface Receiver {
        public void onReceiveResult(int resultCode, Bundle resultData);
    }


    @Override
    protected void onReceiveResult(int resultCode, Bundle resultData) {
        if (mReceiver != null) {
            mReceiver.onReceiveResult(resultCode, resultData);
        }
    }

}
