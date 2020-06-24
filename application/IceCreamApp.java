package be.intecbrussel.application;

import be.intecbrussel.eatables.Cone;
import be.intecbrussel.eatables.Eatable;
import be.intecbrussel.eatables.Magnum;
import be.intecbrussel.sellers.IceCreamSalon;
import be.intecbrussel.sellers.PriceList;

public class IceCreamApp {

    public static void main(String[] args) {

        PriceList priceList = new PriceList(2, 2, 3);
        IceCreamSalon brainFreeze = new IceCreamSalon(priceList);

        Eatable order [] = new Eatable[5];

        order[0] = brainFreeze.orderCone(new Cone.Flavor[]{Cone.Flavor.STRAWBERRY, Cone.Flavor.BANANA, Cone.Flavor.STRACIATELLA});
        order[1] = brainFreeze.orderIceRocket();
        order[2] = brainFreeze.orderMagnum(Magnum.MagnumType.BLACKCHOCOLATE);
        order[3] = brainFreeze.orderIceRocket();
        order[4] = brainFreeze.orderCone(new Cone.Flavor[]{Cone.Flavor.STRACIATELLA});


        for (Eatable ice : order){
            ice.eat();
        }

        System.out.println("The total price of your order is: " + brainFreeze.getProfit());

    }
}
