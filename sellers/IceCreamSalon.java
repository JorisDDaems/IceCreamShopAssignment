package be.intecbrussel.sellers;

import be.intecbrussel.eatables.Cone;
import be.intecbrussel.eatables.IceRocket;
import be.intecbrussel.eatables.Magnum;

public class IceCreamSalon implements IceCreamSeller {

    PriceList priceList;
    private int ballAmount;
    private int rocketAmount;
    private int magnumAmount;
    private int specialMagnumAmount;
    private double totalProfit;

    public IceCreamSalon(PriceList priceList) {
        this.priceList = priceList;
    }


    @Override
    public double getProfit() {

        double totalCone = priceList.getBallPrice()*ballAmount;
        double totalIceRocket = priceList.getRocketPrice()*rocketAmount;
        double totalMagnum = priceList.getMagnumPrice()* magnumAmount +priceList.getMagnumPrice()*1.5*specialMagnumAmount;
        totalProfit = totalCone + totalIceRocket + totalMagnum;

        return totalProfit;
    }

    @Override
    public Cone orderCone(Cone.Flavor[] flavor) {
        Cone horn = new Cone(flavor);
        ballAmount = ballAmount+ flavor.length;
        return horn;
    }

    @Override
    public IceRocket orderIceRocket() {
        IceRocket ijsracket = new IceRocket();
        rocketAmount++;
        return ijsracket;
    }

    @Override
    public Magnum orderMagnum(Magnum.MagnumType magnum) {
        Magnum magnum1 = new Magnum(magnum);
        if (magnum == Magnum.MagnumType.ALPINENUTS){
            specialMagnumAmount++;
        } else {
            magnumAmount++;
        }
        return magnum1;
    }

    @Override
    public String toString() {
        return "IceCreamSalon{" +
                "priceList=" + priceList +
                ", totalProfit=" + totalProfit +
                '}';
    }
}

