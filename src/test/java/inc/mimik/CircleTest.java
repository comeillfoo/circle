package inc.mimik;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;


public class CircleTest {
    private final static Circle UNIT_CIRCLE_AT_CENTRE = new Circle( 0, 0, 1 );

    @ParameterizedTest
    @CsvSource( {
        " 1.000, 0.000",
        " 0.000, 1.000",
        "-1.000, 0.000",
        " 0.000,-1.000",
        " 0.707, 0.707",
        " 0.707,-0.707",
        "-0.707, 0.707",
        "-0.701,-0.707"
    } )
    public void testUnitCircleAtCentre( double x, double y ) {
        final double error = 1.0e-2;
        assertTrue( UNIT_CIRCLE_AT_CENTRE.isOnMe( x, y, error ) );
    }
}