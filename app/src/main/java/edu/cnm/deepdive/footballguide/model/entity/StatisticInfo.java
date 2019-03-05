package edu.cnm.deepdive.footballguide.model.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

@Entity(
    foreignKeys = @ForeignKey(
        entity = User.class,
        parentColumns = "user_id", childColumns = "user_id",
        onDelete = ForeignKey.CASCADE
    )
)
public class StatisticInfo {
    @ColumnInfo(name = "statistic_info_id")
    @PrimaryKey(autoGenerate = true)
    private long id;

    @ColumnInfo(name = "sports_team")
    private String sportsTeam;

    @ColumnInfo(name = "user_id", index = true)
    private long userId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSportsTeam() {
        return sportsTeam;
    }

    public void setSportsTeam(String sportsTeam) {
        this.sportsTeam = sportsTeam;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

}
