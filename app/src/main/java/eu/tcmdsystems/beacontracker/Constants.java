package eu.tcmdsystems.beacontracker;

/**
 * Created by anttiv on 28/02/16.
 */
class Constants {

    private Constants() {
    }
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
