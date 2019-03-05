package edu.cnm.deepdive.footballguide.model.entity;

import android.arch.persistence.room.Entity;

@Entity
public class user {

  int user_ID;

  public int getUser_ID() {
    return user_ID;
  }

  public void setUser_ID(int user_ID) {
    this.user_ID = user_ID;
  }
}
