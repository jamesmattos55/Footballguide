package edu.cnm.deepdive.footballguide.model.dao;

import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import edu.cnm.deepdive.footballguide.model.entity.StatisticInfo;
import java.util.List;

public interface StatisticInfoDao {

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  List<Long> insert(StatisticInfo... statisticInfos);

  @Query("SELECT * FROM statisticinfo")
  StatisticInfo findSelect(StatisticInfo statisticInfo);


}
