package javaCode;

public class Marker extends Pen {

    @Override
    public Colour getColour() {
        return null;
    }

    public Marker() {
        super(PenType.MARKER);
    }

    @Override
    public void write() {

    }
}
