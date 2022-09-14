package net.samuelcmace.utk.util.object;

public class Coordinate
{
    private double x;
    private double y;

    public Coordinate()
    {
        this.x = 0.0d;
        this.y = 0.0d;
    }

    public Coordinate(double m_x, double m_y)
    {
        this.x = m_x;
        this.y = m_y;
    }

    public double GetX() { return this.x; }
    public void SetX(double m_x) { this.x = m_x; }

    public double GetY() { return this.y; }
    public void SetY(double m_y) { this.y = m_y; }

    public double[] SetCoordinate()
    {
        double[] coordinate = { 0.0d, 0.0d };
        coordinate[0] = this.GetX();
        coordinate[1] = this.GetY();
        return coordinate;
    }

    public void SetCoordinate(double m_x, double m_y)
    {
        this.SetX(m_x);
        this.SetY(m_y);
    }

    public void SetCoordinate(Coordinate coordinate)
    {
        this.SetX(coordinate.GetX());
        this.SetY(coordinate.GetY());
    }

    public static Coordinate CalculateCoordinateOffset(Coordinate a, Coordinate b)
    {
        Coordinate offset = new Coordinate();
        offset.SetX((a.GetX() - b.GetX()) * -1);
        offset.SetY((a.GetY() - b.GetY()) * -1);
        return offset;
    }
}
