package org.romainlavabre;

/**
 * @author Romain Lavabre <romainlavabre98@gmail.com>
 */
public interface Distance {
    /**
     * @param latFrom      From latitude
     * @param longFrom     From longitude
     * @param latTo        To latitude
     * @param longTo       To longitude
     * @param distanceUnit Unit
     * @return Distance of 2 position to specified unit
     */
    double getDistance( Double latFrom, Double longFrom, Double latTo, Double longTo, DistanceUnit distanceUnit );
}
