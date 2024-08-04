package src.com.ipl_project;

public class Delivery {

  private String deliveryId;

  private String extraRun;

  private String totalRun;

  private String bowler;

  private String wideBall;

  private String noBall;

  private String legByeRun;

  private String byeRun;

  private String bowlingTeam;

  public void setDeliveryId(String deliveryId){
    this.deliveryId = deliveryId;
  }

  public void setExtraRun(String extraRun){
    this.extraRun =  extraRun;
  }
  public void setTotalRun(String totalRun){
    this.totalRun = totalRun;
  }
  public void setBowler(String bowler) {
    this.bowler = bowler;
  }
  public void setWideBall(String wideBall) {
    this.wideBall = wideBall;
  }
  public void setNoBall(String noBall) {
    this.noBall = noBall;
  }
  public void setLegByeRun(String legByeRun) {
    this.legByeRun = legByeRun;
  }
  public void setByeRun(String byeRun) {
    this.byeRun = byeRun;

  }public void setBowlingTeam(String byeRun) {
    this.bowlingTeam = byeRun;
  }
  public String getTotalRun(){
    return totalRun;
  }
  public String getExtraRun(String extraRun){
    return extraRun;
  }
  public String getBowler(){
    return bowler;
  }
  public String getWideBall(){
    return wideBall;
  }
  public String getNoBall(){
    return noBall;
  }
  public String getLegByeRun(){
    return legByeRun;
  }
  public String getByeRun(){
    return byeRun;
  }

  public String getDeliveryId() {
    return deliveryId;
  }

  public String getTotalRuns() {
    return totalRun;
  }

  public String getExtraRuns() {
    return extraRun;
  }
  public String getBowlingTeam() {
    return bowlingTeam;
  }
}

