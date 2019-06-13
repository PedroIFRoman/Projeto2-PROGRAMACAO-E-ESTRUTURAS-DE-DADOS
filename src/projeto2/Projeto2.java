package projeto2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.TreeMap;

public class Projeto2 {

    public static void main(String[] args) {
        TreeMap<String, Platform> map = new TreeMap<String, Platform>();
        int i = 0;
        
        try {
            BufferedReader br = new BufferedReader(new FileReader("game-reviews.csv"));
            String linha = null;
            String[] SplitL = null;
            Platform p = null;
            br.readLine();
            while ((linha = br.readLine()) != null) {
                SplitL = linha.split(";");
                i++;

                if (!map.containsKey(SplitL[1])) {
                    p = new Platform();
                    p.setPlatform(SplitL[1]);
                    map.put(p.getPlatform(), p);
                } else {
                    p = map.get(SplitL[1]);
                }

                p.getScores().add(Double.valueOf(SplitL[3]));

                if (SplitL[2].equals("Great") || SplitL[2].equals("great")) {
                    p.setGreatPercentage(p.getGreatPercentage() + 1);
                }
                
                if (SplitL[4].equals("Racing") || SplitL[4].equals("racing")){
                    p.setRacing(p.getRacing() + 1);
                    p.getScoresRacing().add(Double.valueOf(SplitL[3]));
                }

                if (p.getMehorJogo() == null || p.getMelhorJogoScore() < Double.valueOf(SplitL[3])) {
                    p.setMelhorJogo(SplitL[0]);
                    p.setMelhorJogoScore(Double.valueOf(SplitL[3]));
                }

                if (p.getPiorJogo() == null || p.getPiorJogoScore() > Double.valueOf(SplitL[3])) {
                    p.setPiorJogo(SplitL[0]);
                    p.setPiorJogoScore(Double.valueOf(SplitL[3]));
                }
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String platform = null;
        double console = 0;

        for (String s : map.keySet()) {
            System.out.println("--------------- " + s + " ---------------");
            System.out.println("Reviews: " + map.get(s).getReviews());
            System.out.println("Percentual de 'Great' reviews: " + String.format("%.2f", map.get(s).getGreat()));
            System.out.println("Média dos scores: " + String.format("%.2f", map.get(s).getMedia()));
            System.out.println("Desvio padrão: " + String.format("%.2f", map.get(s).getDesvio()));
            System.out.println("Melhor jogo: " + map.get(s).getMehorJogo());
            System.out.println("Pior Jogo: " + map.get(s).getPiorJogo());
            System.out.println("");

            if (platform == "null" || console < map.get(s).getRacing()) {
                if (map.get(s).getMediaRacing() > console) {
                    platform = s;
                    console = map.get(s).getMediaRacing();
                }
            }

        }
        System.out.println("------------------------------------------------------------");
        System.out.println("Plataforma com gênero Racing mais bem avaliado: " + platform);
        System.out.println("------------------------------------------------------------");
    }
}
