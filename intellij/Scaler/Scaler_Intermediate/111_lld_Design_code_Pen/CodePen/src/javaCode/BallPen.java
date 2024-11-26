package javaCode;

public class BallPen extends Pen  implements Refilpen{

    public BallPen() {
        super(PenType.BALL);
    }
    @Override
    public Colour getColour() {
        return null;
    }

    @Override
    public void write() {

    }

    @Override
    public boolean canChangeRefil() {
        return false;
    }

    @Override
    public Refil getRefil() {
        return null;
    }

    @Override
    public void changeRefil(Refil refil) {

    }
}
