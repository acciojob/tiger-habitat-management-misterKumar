package com.driver;

import java.util.ArrayList;
import java.util.List;

public class TigerHabitat {
    private List<Tiger> tigers = new ArrayList<>();

    public void addTiger(Tiger tiger) {
        tigers.add(tiger);
    }

    public List<Tiger> getAllTigers() {
        return new ArrayList<>(tigers);
    }

    public Tiger getTigerByType(String type) {
        for (Tiger tiger : tigers) {
            if (tiger.getType().equalsIgnoreCase(type)) {
                return tiger;
            }
        }
        return null;
    }
}
