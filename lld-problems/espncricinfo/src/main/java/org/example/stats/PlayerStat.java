package org.example.stats;

public class PlayerStat extends Stat {
    public int ranking;
    public int bestScore;
    public int bestWicketCount;
    public int totalMatchesPlayed;
    public int total100s;
    public int total50s;

    @Override
    public boolean updateStats() {
        return true;
    }
}