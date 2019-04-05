package com.mobiledev.nbascheduler;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.room.Room;
import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.AppCompatTextView;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class UserSettings extends AppCompatActivity
{
    private String username;
    private String team;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_settings);
        //Spinner for picking favourite team.
        final Spinner spinner = (Spinner) findViewById(R.id.teams_spinner);
        final ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.teams_array, android.R.layout.simple_spinner_item);
        //Specify the layout
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        final EditText usernameText = (EditText) findViewById(R.id.name_box);
        Button apply = (Button) findViewById(R.id.applybtn);

        apply.setOnClickListener(
                new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        if (v.getId() == R.id.applybtn)
                        {
                           username = usernameText.getText().toString();
                           team = spinner.getSelectedItem().toString();

                            Log.d("TAG", username);
                            Log.d("TAG", team);

                            //Save user settings in Shared preferences.
                            SharedPreferences userPref = getApplicationContext().getSharedPreferences(
                                    "settingsPref", Context.MODE_PRIVATE);

                            SharedPreferences.Editor editor = userPref.edit();
                            editor.putString("username", username);
                            editor.putString("fav_team", team);

                            editor.commit();

                            Toast.makeText(getBaseContext(), "Settings Saved!", Toast.LENGTH_LONG).show();
                        }
                    }
                }
        );




    }

}
