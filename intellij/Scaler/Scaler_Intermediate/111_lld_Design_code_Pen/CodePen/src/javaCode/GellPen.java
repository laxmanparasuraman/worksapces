package javaCode;

public class GellPen extends Pen  implements Refilpen{

    private  Refil refil;
    private boolean canChangeRefil=false;

    private GellPen() {
        super(PenType.GELL);
    }

    public static class Builder{
        private  Refil refil;
        private boolean canChangeRefil=false;
        public Builder setRefil(Refil refil){
            this.refil=refil;
            return this;

        }
        public Builder setCanChangeRefil(boolean value){
            this.canChangeRefil=value;
            return this;
        }
        public GellPen build(){
            GellPen gelpen=new GellPen();
            gelpen.refil=this.refil;
            gelpen.canChangeRefil=this.canChangeRefil;
            return  gelpen;
        }

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

        return this.canChangeRefil;
    }

    @Override
    public Refil getRefil() {

        return this.refil;
    }

    @Override
    public void changeRefil(Refil refil) {

    }
}
