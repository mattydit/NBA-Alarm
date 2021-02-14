package com.mobiledev.nbascheduler;

import android.graphics.drawable.Drawable;

public class TeamLogos
{
    String imageName;

    public String GetTeamLogo(String team)
    {
        switch (team)
        {
            case "Bucks": {
                imageName = "bucks";
                break;
            }
            case "Bulls": {
                imageName = "bulls";
                break;
            }
            case "Cavaliers": {
                imageName = "cavs";
                break;
            }
            case "Celtics": {
                imageName = "celtics";
                break;
            }
            case "Clippers": {
                imageName = "clippers";
                break;
            }
            case "Grizzlies": {
                imageName = "grizzlies";
                break;
            }
            case "Hawks": {
                imageName = "hawks";
                break;
            }
            case "Heat": {
                imageName = "heat";
                break;
            }
            case "Hornets": {
                imageName = "hornets";
                break;
            }
            case "Jazz": {
                imageName = "jazz";
                break;
            }
            case "Kings": {
                imageName = "kings";
                break;
            }
            case "Knicks": {
                imageName = "knicks";
                break;
            }
            case "Lakers": {
                imageName = "lakers";
                break;
            }
            case "Magic": {
                imageName = "magic";
                break;
            }
            case "Mavericks": {
                imageName = "mavs";
                break;
            }
            case "Nets": {
                imageName = "nets";
                break;
            }
            case "Nuggets": {
                imageName = "nuggets";
                break;
            }
            case "Pacers": {
                imageName = "pacers";
                break;
            }
            case "Pelicans": {
                imageName = "pelicans";
                break;
            }
            case "Pistons": {
                imageName = "pistons";
                break;
            }
            case "Raptors": {
                imageName = "raptors";
                break;
            }
            case "Rockets": {
                imageName = "rockets";
                break;
            }
            case "76ers": {
                imageName = "sixers";
                break;
            }
            case "Spurs": {
                imageName = "spurs";
                break;
            }
            case "Suns": {
                imageName = "suns";
                break;
            }
            case "Thunder": {
                imageName = "thunder";
                break;
            }
            case "Timberwolves": {
                imageName = "wolves";
                break;
            }
            case "Trail Blazers": {
                imageName = "blazers";
                break;
            }
            case "Warriors": {
                imageName = "warriors";
                break;
            }
            case "Wizards": {
                imageName = "wizards";
                break;
            }
        }
        return imageName;
    }
}
