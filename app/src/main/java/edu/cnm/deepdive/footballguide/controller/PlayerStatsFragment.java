package edu.cnm.deepdive.footballguide.controller;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.EditText;
import edu.cnm.deepdive.footballguide.R;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class PlayerStatsFragment extends Fragment implements OnClickListener {

  ArrayList<String>playerName;

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_player_stats, container, false);
    playerName = new ArrayList<>();
    return inflater.inflate(R.layout.fragment_player_stats, container, false);
  }

  @Override
  public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    View view = getView();
    Button searchButton = view.findViewById(R.id.search_button);
    searchButton.setOnClickListener(this);
  }

  private void onSearchClicked() {
    View view = getView();
    TextInputLayout playerLayout = view.findViewById(R.id.player_search_container);
    EditText input = view.findViewById(R.id.player_search);
    String inputPlayer = input.getText().toString();
    playerName.add(inputPlayer);

    class RetrieveFeedTask extends AsyncTask<Void, Void, String> {

      private Exception exception;

      protected void onPreExecute() {
      }

      protected String doInBackground(Void... urls) {


        try {
          URL url = new URL( "https://api.stattleship.com/football/nfl/player_season_stats" +
              "&apiKey=" + "9878f8a0b4507ba22ff8e9fd932800ee");
          HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
          try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
              stringBuilder.append(line).append("\n");
            }
            bufferedReader.close();
            return stringBuilder.toString();
          }
          finally{
            urlConnection.disconnect();
          }
        }
        catch(Exception e) {
          Log.e("ERROR", e.getMessage(), e);
          return null;
        }
      }

      protected void onPostExecute(String response) {
        if(response == null) {
          response = "THERE WAS AN ERROR";
        }

      }
    }
  }

  @Override
  public void onClick(View v) {
    switch (v.getId()) {
      case R.id.search_button:
        onSearchClicked();
        break;
    }
  }
}
