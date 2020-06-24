package be.intecbrussel.eatables;

public class Magnum implements Eatable {

    public enum MagnumType {

        MILKCHOCOLATE(), WHITECHOCOLATE(),
        BLACKCHOCOLATE(), ALPINENUTS(),
        ROMANTICSTRAWBERRIES();
    }

    private MagnumType type;

    public Magnum() {
    }

    public Magnum(MagnumType type) {
        this.type = type;
    }

    @Override
    public void eat() {
        System.out.println("I'm eating a Magnum, this one: " + getType());
    }

    public MagnumType getType() {
        return type;
    }

}


