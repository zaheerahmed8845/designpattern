package org.example.stats;

public class TeamStat extends Stat {
    public double winPercentage;
    public String topBatsman;
    public String topBowler;
    public int totalMatches;

    @Override
    public boolean updateStats() {
        return true;
    }
}
