package src.com.ipl_project;

import java.io.*;
import java.util.*;

public class Main {

  public static final int MATCH_ID = 0;
  public static final int MATCH_SEASON = 1;
  public static final int MATCH_TEAM1 = 5;
  public static final int MATCH_TEAM2 = 6;
  public static final int MATCH_CITY = 3;
  public static final int MATCH_WINNER = 10;
  public static final int DELIVERY_Id = 0;
  public static final int DELIVERY_BOWLER = 8;
  public static final int DELIVERY_BOWLING_TEAM = 3;
  public static final int DELIVERY_WIDE_RUN = 10;
  public static final int DELIVERY_BYE_RUN = 11;
  public static final int DELIVERY_LEG_BUY_RUN = 12;
  public static final int DELIVERY_NO_BALL = 13;
  public static final int DELIVERY_EXTRA_RUN = 16;
  public static final int DELIVERY_TOTAL_RUN = 17;
  public static final String YEAR_2015 = "2015";
  public static final String YEAR_2016 = "2016";

  public static void main(String[] args) {
    List<Match> matches = getMatchData();
    List<Delivery> deliveries = getDeliveryData();

    numberOfMatchesPlayedPerYearOfAllTheYearsInIpl(matches);
    numberOfMatchesWonOfAllTeamsOverAllTheYearsOfIpl(matches);
    extraRunsConcededPerTeamInYear2016(matches, deliveries);
    getTopEconomicalBowlersOfYear2015(matches, deliveries);

  }

  public static List<Match> getMatchData() {
    List<Match> getListOfMatchData = new ArrayList<>();

    try {
      String fileMatches = "src/data/matches.csv";
      BufferedReader br = new BufferedReader(new FileReader(fileMatches));
      String line;
      while ((line = br.readLine()) != null) {
        Match match = new Match();
        String[] rowFileData = line.split(",");
        match.setId(rowFileData[Main.MATCH_ID]);
        match.setSeason(rowFileData[Main.MATCH_SEASON]);
        match.setTeam1(rowFileData[Main.MATCH_TEAM1]);
        match.setTeam2(rowFileData[Main.MATCH_TEAM2]);
        match.setCity(rowFileData[Main.MATCH_CITY]);
        match.setWinner(rowFileData[Main.MATCH_WINNER]);
        getListOfMatchData.add(match);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

    return getListOfMatchData;
  }

   public static List<Delivery> getDeliveryData() {
    List<Delivery> getListOfDeliveryData = new ArrayList<>();

    try {
      String fileDelivery = "src/data/deliveries.csv";
      BufferedReader br = new BufferedReader(new FileReader(fileDelivery));
      String line;
      while ((line = br.readLine()) != null) {
        Delivery delivery = new Delivery();
        String[] rowFileData = line.split(",");
        delivery.setDeliveryId((rowFileData[Main.DELIVERY_Id]));
        delivery.setBowler(rowFileData[Main.DELIVERY_BOWLER]);
        delivery.setBowlingTeam(rowFileData[Main.DELIVERY_BOWLING_TEAM]);
        delivery.setWideBall(rowFileData[Main.DELIVERY_WIDE_RUN]);
        delivery.setByeRun(rowFileData[Main.DELIVERY_BYE_RUN]);
        delivery.setLegByeRun(rowFileData[Main.DELIVERY_LEG_BUY_RUN]);
        delivery.setNoBall(rowFileData[Main.DELIVERY_NO_BALL]);
        delivery.setExtraRun(rowFileData[Main.DELIVERY_EXTRA_RUN]);
        delivery.setTotalRun(rowFileData[Main.DELIVERY_TOTAL_RUN]);

        getListOfDeliveryData.add(delivery);

      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return getListOfDeliveryData;
  }

   private static void numberOfMatchesPlayedPerYearOfAllTheYearsInIpl(List<Match> matchData) {
    Map<String, Integer> yearWiseMatches = new HashMap<>();
    for (Match match : matchData) {
      String season = match.getSeason();
      yearWiseMatches.put(season, yearWiseMatches.getOrDefault(season, 0) + 1);
    }
    System.out.println("Number of matches played per year of all the years in IPL:");
  for(Map.Entry<String,Integer> entry : yearWiseMatches.entrySet()){
    System.out.println("Year= "+ entry.getKey()+" Number of matches= "+entry.getValue());
  }
  }

   private static void numberOfMatchesWonOfAllTeamsOverAllTheYearsOfIpl(List<Match> matchData) {
    Map<String, Integer> teamWins = new HashMap<>();
    for (Match match : matchData) {
      String winner = match.getWinner();
      if (!winner.isEmpty()) {
        teamWins.put(winner, teamWins.getOrDefault(winner, 0) + 1);
      }
    }

    System.out.println("\nNumber of matches won of all teams over all the years of IPL:");
    for(Map.Entry<String, Integer> entry : teamWins.entrySet()){
      System.out.println("Team name= "+ entry.getKey()+" wins= "+entry.getValue());
    }
     }

  private static void extraRunsConcededPerTeamInYear2016(List<Match> matches, List<Delivery> deliveries) {
    Map<String, Integer> extraRunsConceded = new HashMap<>();
    List<String> matchIds2016 = new ArrayList<>();
    for (Match match : matches) {
      if (match.getSeason().equals(YEAR_2016)) {
        matchIds2016.add(match.getId());
      }
    }
    for (Delivery delivery : deliveries) {
      if (matchIds2016.contains(delivery.getDeliveryId())) {
        extraRunsConceded.put(delivery.getBowlingTeam(), extraRunsConceded.getOrDefault(delivery.getBowlingTeam(), 0) + Integer.parseInt(delivery.getExtraRuns()));
      }
    }
    System.out.println("\nExtra runs conceded per team in 2016:");
    for(Map.Entry<String, Integer> entry: extraRunsConceded.entrySet()){
      System.out.println("TeamName= "+entry.getKey()+" ExtraRuns= "+entry.getValue());
    }
      }

  private static void getTopEconomicalBowlersOfYear2015(List<Match> matches, List<Delivery> deliveries) {
    Map<String, int[]> bowlerStats = new HashMap<>(); // array [balls, runs]
    Set<String> matchIds2015 = new HashSet<>();
    for (Match match : matches) {
      if (match.getSeason().equals(YEAR_2015)) {
        matchIds2015.add(match.getId());
      }
    }
    for (Delivery delivery : deliveries) {
      if (matchIds2015.contains(delivery.getDeliveryId())) {
        String bowler = delivery.getBowler();
        int runs = Integer.parseInt(delivery.getTotalRuns());
        if (!bowlerStats.containsKey(bowler)) {
          bowlerStats.put(bowler, new int[2]);
        }
        bowlerStats.get(bowler)[0]++;   // balls
        bowlerStats.get(bowler)[1] += runs;   // runs
      }
    }
    List<Map.Entry<String, Double>> economyRates = new ArrayList<>();
    for (Map.Entry<String, int[]> entry : bowlerStats.entrySet()) {
      double economy = (double) entry.getValue()[1] / (entry.getValue()[0] / 6.0);
      economyRates.add(new AbstractMap.SimpleEntry<>(entry.getKey(), economy));
    }
    economyRates.sort(Map.Entry.comparingByValue());
    System.out.println("\nTop economical bowlers in 2015:");
    for (int i = 0; i < 10 && i < economyRates.size(); i++) {
      System.out.println(economyRates.get(i).getKey() + ": " + economyRates.get(i).getValue());
    }
  }
}

