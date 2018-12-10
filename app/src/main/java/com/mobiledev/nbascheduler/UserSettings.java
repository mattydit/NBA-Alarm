package com.mobiledev.nbascheduler;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.arch.persistence.room.Room;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatTextView;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

public class UserSettings extends AppCompatActivity
{
    private String username;
    private String team;


    private UserViewModel mUserViewModel;

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
                    @RequiresApi(api = Build.VERSION_CODES.O)
                    @Override
                    public void onClick(View v)
                    {
                        if (v.getId() == R.id.applybtn)
                        {
                           setUsername(usernameText.getText().toString());
                           setTeam(spinner.getSelectedItem().toString());

                            Log.d("TAG", getUsername());
                            Log.d("TAG", getTeam());

                            UserRoomDatabase db = Room.databaseBuilder(getApplicationContext(), UserRoomDatabase.class, "user").build();
                            Log.d("DB:", String.join(db.userDao().getAllUsers().toString()));

                        }
                    }
                }
        );




    }

}
