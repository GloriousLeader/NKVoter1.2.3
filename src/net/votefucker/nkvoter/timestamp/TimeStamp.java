/*
 * Fuck your wall of text
 */
package net.votefucker.nkvoter.timestamp;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

/**
 *
 * @author bla
 */
public final class TimeStamp {
    public static String getTimeStampString()
    {
        GregorianCalendar greg = new GregorianCalendar();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        
        return sdf.format(greg.getTime());
    }
}
