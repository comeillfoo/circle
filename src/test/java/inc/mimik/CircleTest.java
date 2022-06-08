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
        "-0.707,-0.707"
    } )
    public void testUnitCircleAtCentre( double x, double y ) {
        final double error = 1.0e-2;
        assertTrue( UNIT_CIRCLE_AT_CENTRE.isOnMe( x, y, error ) );
    }

    @ParameterizedTest
    @CsvSource( {
        " 1.000, 1.000",
        "-1.000, 1.000",
        "-1.000,-1.000",
        " 1.000,-1.000"
    } )
    public void testSquareVertexesUnitCircleAtCentre( double x, double y ) {
        final double error = 1.0e-24;
        assertFalse( UNIT_CIRCLE_AT_CENTRE.isOnMe( x, y, error ) );
    }

    @ParameterizedTest
    @CsvSource( {
        " 3.000, 3.000",
        " 2.000, 4.000",
        " 1.000, 3.000",
        " 2.000, 2.000",
        " 2.707, 3.707",
        " 2.707, 2.293",
        " 1.293, 3.707",
        " 1.293, 2.293"
    } )
    public void testShiftedUnitCircle( double x, double y ) {
        final Circle shiftedUnitCircle = new Circle( 2, 3, 1 );
        final double error = 1.0e-3;
        assertTrue( shiftedUnitCircle.isOnMe( x, y, error ) );
    }
}