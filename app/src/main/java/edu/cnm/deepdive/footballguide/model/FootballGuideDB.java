package edu.cnm.deepdive.footballguide.model;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverter;
import android.arch.persistence.room.TypeConverters;
import android.support.annotation.Nullable;
import edu.cnm.deepdive.footballguide.FootballGuideApplication;
import edu.cnm.deepdive.footballguide.model.FootballGuideDB.Converters;
import edu.cnm.deepdive.footballguide.model.dao.RuleDao;
import edu.cnm.deepdive.footballguide.model.dao.StatisticInfoDao;
import edu.cnm.deepdive.footballguide.model.dao.UserDao;
import edu.cnm.deepdive.footballguide.model.entity.Rule;
import edu.cnm.deepdive.footballguide.model.entity.StatisticInfo;
import edu.cnm.deepdive.footballguide.model.entity.User;
import java.util.Calendar;

@Database(
    entities = {User.class, StatisticInfo.class, Rule.class},
    version = 1,
    exportSchema = true
)
@TypeConverters(Converters.class)
public abstract class FootballGuideDB extends RoomDatabase {

  private static final String DB_NAME = "football_guide_db";

  public synchronized static FootballGuideDB getInstance() {
    return InstanceHolder.INSTANCE;
  }

  public abstract RuleDao getRuleDao();

  public abstract StatisticInfoDao getStatisticInfoDao();

  public abstract UserDao getUserDao();

  private static class InstanceHolder {

    private static final FootballGuideDB INSTANCE = Room.databaseBuilder(
        FootballGuideApplication.getInstance().getApplicationContext(), FootballGuideDB.class, DB_NAME)
        .build();

  }

  public static class Converters {

    @Nullable
    @TypeConverter
    public static Calendar calendarFromLong(@Nullable Long milliseconds) {
      if (milliseconds != null) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(milliseconds);
        return calendar;
      }
      return null;
    }

    /**
     * Converts a {@link Calendar} date-time value number of milliseconds since the start of the
     * Unix epoch (1970-01-01 00:00:00.000 UTC), and returns the latter.
     *
     * @param calendar date-time as a {@link Calendar} instance.
     * @return date-time as a number of milliseconds since the start of the Unix epoch.
     */
    @Nullable
    @TypeConverter
    public static Long longFromCalendar(@Nullable Calendar calendar) {
      return (calendar != null) ? calendar.getTimeInMillis() : null;
    }

//    /**
//     * Converts an {@link Integer} value containing the days since the start of the Unix epoch
//     * (1970-01-01) to an instance of {@link Date}, and returns the latter. Both of these are
//     * interpreted as local dates, with no reference to time zone.
//     *
//     * @param days local date as a number of days since the start of the Unix epoch.
//     * @return local date as a {@link Date} instance.
//     */
//    @Nullable
//    @TypeConverter
//    public static Date dateFromInt(@Nullable Integer days) {
//      return (days != null) ? Date.fromEpochDays(days) : null;
//    }
//
//    /**
//     * Converts a {@link Date} local date value to a number of days since the start of the Unix
//     * epoch (1970-01-01), and returns the latter. Both of these are interpreted as local dates,
//     * with no reference to time zone.
//     *
//     * @param date local date as a {@link Date} instance.
//     * @return local date as a number of days since the start of the Unix epoch.
//     */
//    @Nullable
//    @TypeConverter
//    public static Integer intFromDate(@Nullable Date date) {
//      return (date != null) ? date.toEpochDays() : null;
//    }

  }


}
