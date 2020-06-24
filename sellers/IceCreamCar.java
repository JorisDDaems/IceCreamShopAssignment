package be.intecbrussel.sellers;

import be.intecbrussel.application.IceCreamApp;
import be.intecbrussel.application.IceCreamAppV2;
import be.intecbrussel.eatables.*;

public class IceCreamCar implements IceCreamSeller {

    Stock stock;
    PriceList priceList;
    private int ballAmount;
    private int rocketAmount;
    private int magnumAmount;
    private int specialMagnumAmount;
    private int totalBallsForPrice;
    private int totalIceRocketsForPrice;
    private int totalMagnumForPrice;
    private int totalSpecialMagnumForPrice;

    private double totalProfit;
    private Object noMoreIceCreamException;

    public IceCreamCar(PriceList priceList, Stock stock) {
        this.priceList = priceList;
        this.stock = stock;
    }

    @Override
    public double getProfit() {

        double totalCone = priceList.getBallPrice()*totalBallsForPrice;
        double totalIceRocket = priceList.getRocketPrice()*totalIceRocketsForPrice;
        double totalMagnum = priceList.getMagnumPrice()* totalMagnumForPrice +priceList.getMagnumPrice()*1.5*totalSpecialMagnumForPrice;
        totalProfit = totalCone + totalIceRocket + totalMagnum;

        return totalProfit;
    }

    @Override
    public Cone orderCone(Cone.Flavor[] flavor) {
        Cone horn = new Cone(flavor);

        if (stock.getBalls() > 0) {
            ballAmount = ballAmount + flavor.length;
            totalBallsForPrice = totalBallsForPrice + ballAmount;
            prepareCone(stock.getBalls());
            return horn;
        } else {
            throw new RuntimeException("We ran out of balls");
        }
    }

    public void prepareCone(int balls){
        stock.setBalls(balls-ballAmount);
        ballAmount = 0;
    }


    @Override
    public IceRocket orderIceRocket() {
        IceRocket ijsracket = new IceRocket();

        if (stock.getIceRockets() > 0) {
            rocketAmount++;
            totalIceRocketsForPrice = totalIceRocketsForPrice + rocketAmount;
            prepareIceRocket(stock.getIceRockets());
            return ijsracket;
        } else {
            throw new NullPointerException("We ran out of ice rockets");
        }
    }

    public void prepareIceRocket(int iceRockets){
        stock.setIceRockets(iceRockets - rocketAmount);
        rocketAmount = 0;
    }


    @Override
    public Magnum orderMagnum(Magnum.MagnumType magnum) {
        Magnum magnum1 = new Magnum(magnum);
        if (stock.getMagni() > 0) {
            if (magnum == Magnum.MagnumType.ALPINENUTS) {
                specialMagnumAmount++;
                totalSpecialMagnumForPrice = totalSpecialMagnumForPrice + specialMagnumAmount;

            } else {
                magnumAmount++;
                totalMagnumForPrice = totalMagnumForPrice + magnumAmount;

            }
            prepareMagnum(stock.getMagni());
            return magnum1;
        } else {
            throw new RuntimeException("We ran out of magnums");
        }
    }

    public void prepareMagnum(int magni){
        stock.setMagni(magni-magnumAmount-specialMagnumAmount);
        magnumAmount = 0;
        specialMagnumAmount = 0;
    }


    @Override
    public String toString() {
        return "IceCreamCar{" +
                "stock=" + stock +
                ", priceList=" + priceList +
                ", totalBallsForPrice=" + totalBallsForPrice +
                ", totalIceRocketsForPrice=" + totalIceRocketsForPrice +
                ", totalMagnumForPrice=" + totalMagnumForPrice +
                ", totalSpecialMagnumForPrice=" + totalSpecialMagnumForPrice +
                ", totalProfit=" + totalProfit +
                '}';
    }
}
