package projeto2;

import java.util.ArrayList;
import java.util.List;

public class Platform {

    private String platform;
    private double greatPercentage;
    private double MelhorJogoScore;
    private String MelhorJogo;
    private double PiorJogoScore;
    private String PiorJogo;
    private int racing;
    private List<Double> scores;
    private List<Double> scoresRacing;

    public Platform() {
        scores = new ArrayList<Double>();
        scoresRacing = new ArrayList<>();
    }

    public int getReviews() {
        return getScores().size();
    }

    public double getGreat() {
        return ((double) greatPercentage / getReviews()) * 100;
    }

    public double getMedia() {
        double totalScore = 0.0;
        for (Double score : getScores()) {
            totalScore = totalScore + score;
        }
        return totalScore / getReviews();
    }
    
    public double getMediaRacing() {
        double totalScore = 0.0;
        for (Double score : scoresRacing) {
            totalScore = totalScore + score;
        }
        return totalScore / racing;
    }
        
    public double getDesvio() {
        double media = getMedia();
        double var = 0.0;
        for (Double score : getScores()) {
            var = var + Math.pow(score - media, 2.0);
        }
        var = var / getReviews();
        return Math.sqrt(var);
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public double getGreatPercentage() {
        return greatPercentage;
    }

    public void setGreatPercentage(double greatPercentage) {
        this.greatPercentage = greatPercentage;
    }

    public double getMelhorJogoScore() {
        return MelhorJogoScore;
    }

    public void setMelhorJogoScore(double MelhorJogoScore) {
        this.MelhorJogoScore = MelhorJogoScore;
    }

    public String getMehorJogo() {
        return MelhorJogo;
    }

    public void setMelhorJogo(String MelhorJogo) {
        this.MelhorJogo = MelhorJogo;
    }

    public double getPiorJogoScore() {
        return PiorJogoScore;
    }

    public void setPiorJogoScore(double PiorJogoScore) {
        this.PiorJogoScore = PiorJogoScore;
    }

    public String getPiorJogo() {
        return PiorJogo;
    }

    public void setPiorJogo(String PiorJogo) {
        this.PiorJogo = PiorJogo;
    }

    public int getRacing() {
        return racing;
    }

    public void setRacing(int racing) {
        this.racing = racing;
    }

    public List<Double> getScores() {
        return scores;
    }

    public void setScores(List<Double> scores) {
        this.scores = scores;
    }

    public List<Double> getScoresRacing() {
        return scoresRacing;
    }
}
