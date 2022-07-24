package shop;

import java.util.Arrays;

public class PurchaseList {

    private Purchase [] purchaseList;
    private final int purchaseListSize = 10;
    private int lastIndex = -1;

    public PurchaseList() {
        this.purchaseList = new Purchase[purchaseListSize];
    }

    public PurchaseList(Purchase[] purchaseList) {
        this.purchaseList = purchaseList;
    }

    public void addPurchase(Purchase purchase) {

        if (lastIndex == -1) {
            this.purchaseList = new Purchase[purchaseListSize];
        } else if (lastIndex == purchaseList.length - 1) {
            purchaseList = Arrays.copyOf(purchaseList, purchaseList.length * 2);
        }

        lastIndex++;
        purchaseList[lastIndex] = purchase;

    }

    public void DeletePurchaseByUserId(int id) {

        for (int i = 0; i < purchaseList.length; i++) {
            if (id == purchaseList[i].getIdUser()) {
                purchaseList[i] = null;
            }

        }

    }

    public void DeletePurchaseByProductId(int id) {

        for (int i = 0; i < purchaseList.length; i++) {
            if (id == purchaseList[i].getIdProduct()) {
                purchaseList[i] = null;
            }

        }

    }

    public void DisplayByUserId(int id) {

        for (int i = 0; i < purchaseList.length; i++) {
            if (id == purchaseList[i].getIdUser()) {
                System.out.println(purchaseList[i].toString());
            }

        }

    }

    public void DisplayPurchaseByProductId(int id) {

        for (int i = 0; i < purchaseList.length; i++) {
            if (id == purchaseList[i].getIdProduct()) {
                System.out.println(purchaseList[i].toString());
            }

        }

    }

}
