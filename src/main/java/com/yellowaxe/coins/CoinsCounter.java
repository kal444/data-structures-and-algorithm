package com.yellowaxe.coins;

import java.util.EnumMap;
import java.util.Map;

import static com.yellowaxe.coins.CoinsCounter.FaceValues.*;

/**
 * @author kal
 */
public class CoinsCounter {

    public static enum FaceValues {
        QUARTER(25), DIME(10), NICKEL(5), PENNY(1);
        private final int cents;

        FaceValues(int cents) {
            this.cents = cents;
        }

        public int cents() {
            return cents;
        }
    }

    // array of coins in descending order (highest face value first)
    private static final FaceValues[] AVAILABLE_COINS = {QUARTER, DIME, NICKEL, PENNY};

    private static Map<FaceValues, Integer> countCoins(int amount) {

        Map<FaceValues, Integer> result = new EnumMap<FaceValues, Integer>(FaceValues.class);
        int amountRemaining = amount;

        for (FaceValues faceValue : AVAILABLE_COINS) {
            int numberOfCoins = amountRemaining / faceValue.cents();
            if (numberOfCoins >= 1) {
                amountRemaining -= numberOfCoins * faceValue.cents();
                result.put(faceValue, numberOfCoins);
            }
            if (amountRemaining == 0) break;
        }

        return result;
    }

    public static final void main(String args[]) {
        print(0);
        print(1);
        print(4);
        print(8);
        print(13);
        print(20);
        print(33);
        print(49);
        print(50);
    }

    private static void print(int cents) {
        System.out.println(cents + " cents = " + countCoins(cents));
    }

}

