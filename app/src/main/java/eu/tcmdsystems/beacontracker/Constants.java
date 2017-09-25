package eu.tcmdsystems.beacontracker;

/**
 * Created by anttiv on 28/02/16.
 */
class Constants {

    private Constants() {
    }


    //Beacon	Layout
    static final String ALTBEACON_LAYOUT="m:2-3=beac,i:4-19,i:20-21,i:22-23,p:24-24,d:25-25";
    static final String EDDYSTONE_TLM_LAYOUT="x,s:0-1=feaa,m:2-2=20,d:3-3,d:4-5,d:6-7,d:8-11,d:12-15";
    static final String EDDYSTONE_UID_LAYOUT="s:0-1=feaa,m:2-2=00,p:3-3:-41,i:4-13,i:14-19";
    static final String EDDYSTONE_URL_LAYOUT="s:0-1=feaa,m:2-2=10,p:3-3:-41,i:4-20v";
    static final String IBEACON_LAYOUT="m:2-3=0215,i:4-19,i:20-21,i:22-23,p:24-24";

    static final String BTLE_SCAN = "eu.tcmdsystems.beacontracker.action.SCAN";
    /**
     * Eddystone-UID frame type value.
     */
    static final byte UID_FRAME_TYPE = 0x00;

    /**
     * Eddystone-URL frame type value.
     */
    static final byte URL_FRAME_TYPE = 0x10;

    /**
     * Eddystone-TLM frame type value.
     */
    static final byte TLM_FRAME_TYPE = 0x20;

    /**
     * Minimum expected Tx power (in dBm) in UID and URL frames.
     */
    static final int MIN_EXPECTED_TX_POWER = -100;

    /**
     * Maximum expected Tx power (in dBm) in UID and URL frames.
     */
    static final int MAX_EXPECTED_TX_POWER = 20;

}
