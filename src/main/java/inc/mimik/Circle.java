package inc.mimik;

public class Circle {
    public final double X_CENTRE;
    public final double Y_CENTRE;
    public final double RADIUS;
    private final double SQUARED_RADIUS;

    public Circle( double x, double y, double r ) {
        X_CENTRE = x;
        Y_CENTRE = y;
        RADIUS = r;
        SQUARED_RADIUS = r * r; // just for caching
    }

    public boolean isOnMe( double x, double y, double error ) {
        final double dx = ( x - X_CENTRE );
        final double dy = ( y - Y_CENTRE );
        final double diff = Math.abs( dx * dx + dy * dy - SQUARED_RADIUS );
        System.out.println( diff );
        return diff < error;
    }
}
