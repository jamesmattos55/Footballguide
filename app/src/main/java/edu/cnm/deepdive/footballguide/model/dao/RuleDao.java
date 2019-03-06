package edu.cnm.deepdive.footballguide.model.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import edu.cnm.deepdive.footballguide.model.entity.Rule;
import java.util.Date;
import java.util.List;

@Dao
public interface RuleDao {

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  List<Long> insert(Rule... rules);


  @Query("SELECT * FROM Rule")
  List<Rule> findSelect();

}
