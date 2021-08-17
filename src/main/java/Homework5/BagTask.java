package Homework5;

import java.util.*;

public class BagTask {
    private final int bagSize;
    private List<Item> suitedSet = null;
    private int bestPrice;

    public BagTask(int bagSize) {
        this.bagSize = bagSize;
    }


    public String findSuited(Item... arr) {
        List<Item> item = new ArrayList<>();
        Collections.addAll(item, arr);
        findVariants(item);
        StringBuilder sb = new StringBuilder();
        sb.append("Предметы: ");
        for (Item value : suitedSet) {
            sb.append(value.getName()).append(" ");
        }
        sb.append("Цена набора: ").append(bestPrice);
        return sb.toString();
    }

    public void findVariants(List<Item> items) {
        if (items.size() > 0) {
            checkSet(items);
        }
        for (int i = 0; i < items.size(); i++) {
            List<Item> temp = new ArrayList<>(items);
            temp.remove(i);
            findVariants(temp);
        }
    }

    public void checkSet(List<Item> items) {
        if (suitedSet == null) {
            if (variantsWeight(items) <= bagSize) {
                suitedSet = items;
                bestPrice = checkPrice(items);
            }
        } else {
            if (variantsWeight(items) <= bagSize && checkPrice(items) > bestPrice) {
                suitedSet = items;
                bestPrice = checkPrice(items);
            }
        }
    }

    public int variantsWeight(List<Item> items) {
        int weightCheck = 0;
        for (Item item : items) {
            weightCheck += item.getWeight();
        }
        return weightCheck;
    }

    public int checkPrice(List<Item> items) {
        int sumPrice = 0;
        for (Item item : items) {
            sumPrice += item.getPrice();
        }
        return sumPrice;
    }


}
