package javaCode;

public abstract class Pen {

    private String name;
    private String company;
    private PenType type;
    private Integer price;
    public abstract void write();

    public Pen(PenType type) {
        this.type = type;
    }

    public abstract Colour getColour();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public PenType getType() {
        return type;
    }

    public void setType(PenType type) {
        this.type = type;
    }





}
