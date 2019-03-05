package edu.cnm.deepdive.footballguide.model.entity;


import android.arch.persistence.room.Entity;

@Entity
public class players {

  int Player_ID;
  String PlayerName;
  String PlayerTeam;
  String PlayerPosition;


  public int getPlayer_ID() {
    return Player_ID;
  }

  public void setPlayer_ID(int player_ID) {
    Player_ID = player_ID;
  }

  public String getPlayerName() {
    return PlayerName;
  }

  public void setPlayerName(String playerName) {
    PlayerName = playerName;
  }

  public String getPlayerTeam() {
    return PlayerTeam;
  }

  public void setPlayerTeam(String playerTeam) {
    PlayerTeam = playerTeam;
  }

  public String getPlayerPosition() {
    return PlayerPosition;
  }

  public void setPlayerPosition(String playerPosition) {
    PlayerPosition = playerPosition;
  }

}
