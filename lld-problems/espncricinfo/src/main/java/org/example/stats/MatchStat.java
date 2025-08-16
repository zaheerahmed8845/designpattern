package org.example.stats;

public class MatchStat extends Stat {
    public int totalRuns;
    public int totalFours;
    public int totalSixes;

    @Override
    public boolean updateStats() {
        return true;
    }
}
