package org.example.entity;

import java.util.ArrayList;
import java.util.List;

public class Inning {
    public int number;
    public Playing11 batting;
    public Playing11 bowling;
    public List<Over> overs = new ArrayList<>();

    public int totalScore() {
        return overs.stream().mapToInt(Over::totalRuns).sum();
    }

    public void addOver(Over o) {
        overs.add(o);
    }
}
