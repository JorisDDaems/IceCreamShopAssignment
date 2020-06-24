package be.intecbrussel.application;

import be.intecbrussel.eatables.*;
import be.intecbrussel.sellers.IceCreamCar;
import be.intecbrussel.sellers.PriceList;

import java.util.Arrays;

public class IceCreamAppV2 {

    public static void main(String[] args) {

        PriceList prices = new PriceList(1, 1, 2);
        Stock stock = new Stock(10, 10, 10, 10);
        IceCreamCar foubert = new IceCreamCar(prices, stock);

        Eatable order[] = new Eatable[6];

        try {
            order[0] = foubert.orderCone(new Cone.Flavor[]{Cone.Flavor.STRAWBERRY, Cone.Flavor.BANANA, Cone.Flavor.STRACIATELLA});
            order[1] = foubert.orderIceRocket();
            order[2] = foubert.orderMagnum(Magnum.MagnumType.BLACKCHOCOLATE);
            order[3] = foubert.orderIceRocket();
            order[4] = foubert.orderCone(new Cone.Flavor[]{Cone.Flavor.STRACIATELLA});
            order[5] = foubert.orderMagnum(Magnum.MagnumType.ALPINENUTS);
        } catch (NullPointerException Npe){
            System.out.println(Npe);
        } catch (RuntimeException Re) {
            System.out.println(Re);

        }

        for (int i = 0; i < order.length; i++) {
            try {
                order[i].eat();

            } catch (NullPointerException Npe) {
                System.out.println("this ice cream is finished");
            }
        }


        System.out.println("the total price of your order is: " + foubert.getProfit());

        System.out.println("there are still " + stock.getBalls() + " balls in stock");
        System.out.println("there are still " + stock.getIceRockets() + " icerockets in stock");
        System.out.println("there are still " + stock.getMagni() + " magnums in stock");

    }
}