package org.romainlavabre.distance;

import org.springframework.stereotype.Service;

/**
 * @author Romain Lavabre <romainlavabre98@gmail.com>
 */
@Service
public class DistanceImpl implements Distance {

    @Override
    public double getDistance( Double latFrom, Double longFrom, Double latTo, Double longTo, DistanceUnit distanceUnit ) {
        if ( isContainsNull( latFrom, longFrom, latTo, longTo ) ) {
            return 0;
        }

        final int R = 6371; // Radius of the earth

        double latDistance = Math.toRadians( latTo - latFrom );
        double lonDistance = Math.toRadians( longTo - longFrom );
        double a = Math.sin( latDistance / 2 ) * Math.sin( latDistance / 2 )
                + Math.cos( Math.toRadians( latFrom ) ) * Math.cos( Math.toRadians( latTo ) )
                * Math.sin( lonDistance / 2 ) * Math.sin( lonDistance / 2 );
        double c        = 2 * Math.atan2( Math.sqrt( a ), Math.sqrt( 1 - a ) );
        double distance = R * c * 1000; // convert to meters

        double height = 0;

        distance = Math.pow( distance, 2 ) + Math.pow( height, 2 );

        double dist = Math.sqrt( distance );

        switch ( distanceUnit ) {
            case MILES:
                return dist / 1609;
            case KILOMETER:
                return dist / 1000;
            case NAUTICAL_MILES:
                return dist / 1852;
        }

        return 0;
    }


    private boolean isContainsNull( Double... positions ) {
        for ( Double position : positions ) {
            if ( position == null ) {
                return true;
            }
        }

        return false;
    }
}
