package src.com.ipl_project;

public class Match {

  private String id;

  private String season;

  private String team1;

  private String team2;

  private String city;

  private String winner;

  public void setId(String id){
    this.id= id;
  }
  public void setSeason(String season){
    this.season = season;
  }
  public void setTeam1(String team1){
    this.team1 = team1;
  }
  public void setTeam2(String team2){
    this.team2 = team2;
  }
  public void setCity(String city){
    this.city = city;
  }
  public void setWinner(String winner){
    this.winner = winner;
  }

  public String getId(){
    return id;
  }
  public String getSeason(){
    return season;
  }
  public String getTeam1(){
    return team1;
  }
  public String getTeam2(){
    return team2;
  }
  public String getCity(){
    return city;
  }
  public String getWinner(){
    return winner;
  }



}
