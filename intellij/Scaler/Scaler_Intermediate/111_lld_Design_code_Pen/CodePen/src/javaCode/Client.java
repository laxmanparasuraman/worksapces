package javaCode;

public class Client {

    public static void main(String args[]){


        GellPen gellPen= PenFactory.createGelPen().setCanChangeRefil(true)
                .setRefil(new Refil())
                .build();
        System.out.println("loki  "  +gellPen);
    }
}
// naman bhalla