package edu.cnm.deepdive.footballguide;

import android.app.Application;
import com.facebook.stetho.Stetho;

public class FootballGuideApplication extends Application {

  private static FootballGuideApplication instance = null;

  @Override
  public void onCreate() {
    super.onCreate();
    instance = this;
    Stetho.initializeWithDefaults(this);
  }


  /**
   * Returns this instance, for access to application context across the app.
   *
   * @return singleton instance.
   */
  public static FootballGuideApplication getInstance() {
    return instance;
  }
}