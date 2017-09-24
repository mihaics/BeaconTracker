package eu.tcmdsystems.beacontracker;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.test.ServiceTestCase;
import android.util.Log;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by mihai on 19.09.2017.
 */
@RunWith(AndroidJUnit4.class)
public class ScannerIntentServiceTest extends ServiceTestCase<ScannerIntentService> {


    private static final String TAG = "IntentServiceTest";
    private static final String EXTRA_RECEIVER = "eu.tcmdsystems.beacontracker.extra.RECEIVER";

    public ScannerIntentServiceTest() {
        super(ScannerIntentService.class);

    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();

    }


    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();
        assertEquals("eu.tcmdsystems.beacontracker", appContext.getPackageName());
    }


    @Test
    public void testWithStartedService() {
        Context appContext = InstrumentationRegistry.getTargetContext();
        Looper.prepare();
        final CountDownLatch latch = new CountDownLatch(1);


        BeaconResultReceiver receiver = new BeaconResultReceiver(new Handler()) {
            @Override
            protected void onReceiveResult(int resultCode, Bundle resultData) {
                latch.countDown();
                Log.d(TAG, "onReceiveResult: resultcode "+resultCode);
                assertEquals(resultCode, 0);
                Log.d(TAG, "onReceiveResult: resultdata");
                assertNull(resultData);
               // fail();
                Looper.myLooper().quit();

            }
        };


            Intent intent = new Intent("eu.tcmdsystems.beacontracker.action.SCAN", null, appContext, ScannerIntentService.class);

            intent.putExtra(EXTRA_RECEIVER, receiver);
            appContext.startService(intent);

            Looper.loop();



        assertThat(latch.getCount(), is(0L));
        //do something
    }

}
