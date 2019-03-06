package edu.cnm.deepdive.footballguide.model.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import edu.cnm.deepdive.footballguide.model.entity.User;
import java.util.List;
@Dao
public interface UserDao {

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  List<Long> insert(User...user);

  @Query("SELECT * FROM User WHERE user_id = :userId")
  User findFirstByUserId(long userId);



}
