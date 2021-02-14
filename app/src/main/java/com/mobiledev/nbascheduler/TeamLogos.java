package com.mobiledev.nbascheduler;

import android.content.Context;
import android.graphics.drawable.Drawable;

public class TeamLogos
{
    public Drawable GetTeamLogo(String teamName, Context context)
    {
        Drawable drawable;

        switch (teamName)
        {
            case "Bucks":
            {
                drawable = context.getResources().getDrawable(R.drawable.bucks);

                break;
            }
            case "Bulls":
            {
                drawable = context.getResources().getDrawable(R.drawable.bulls);

                break;
            }
            case "Cavaliers":
            {
                drawable = context.getResources().getDrawable(R.drawable.cavs);

                break;
            }
            case "Celtics":
            {
                drawable = context.getResources().getDrawable(R.drawable.celtics);

                break;
            }
            case "Clippers":
            {
                drawable = context.getResources().getDrawable(R.drawable.clippers);

                break;
            }
            case "Grizzlies":
            {
                drawable = context.getResources().getDrawable(R.drawable.grizzlies);

                break;
            }
            case "Hawks":
            {
                drawable = context.getResources().getDrawable(R.drawable.hawks);

                break;
            }
            case "Heat":
            {
                drawable = context.getResources().getDrawable(R.drawable.heat);

                break;
            }
            case "Hornets":
            {
                drawable = context.getResources().getDrawable(R.drawable.hornets);

                break;
            }
            case "Jazz":
            {
                drawable = context.getResources().getDrawable(R.drawable.jazz);

                break;
            }
            case "Kings":
            {
                drawable = context.getResources().getDrawable(R.drawable.kings);

                break;
            }
            case "Knicks":
            {
                drawable = context.getResources().getDrawable(R.drawable.knicks);

                break;
            }
            case "Lakers":
            {
                drawable = context.getResources().getDrawable(R.drawable.lakers);

                break;
            }
            case "Magic":
            {
                drawable = context.getResources().getDrawable(R.drawable.magic);

                break;
            }
            case "Mavericks":
            {
                drawable = context.getResources().getDrawable(R.drawable.mavs);

                break;
            }
            case "Nets":
            {
                drawable = context.getResources().getDrawable(R.drawable.nets);

                break;
            }
            case "Nuggets":
            {
                drawable = context.getResources().getDrawable(R.drawable.nuggets);

                break;
            }
            case "Pacers":
            {
                drawable = context.getResources().getDrawable(R.drawable.pacers);

                break;
            }
            case "Pelicans":
            {
                drawable = context.getResources().getDrawable(R.drawable.pelicans);

                break;
            }
            case "Pistons":
            {
                drawable = context.getResources().getDrawable(R.drawable.pistons);

                break;
            }
            case "Raptors":
            {
                drawable = context.getResources().getDrawable(R.drawable.raptors);

                break;
            }
            case "Rockets":
            {
                drawable = context.getResources().getDrawable(R.drawable.rockets);

                break;
            }
            case "76ers":
            {
                drawable = context.getResources().getDrawable(R.drawable.sixers);

                break;
            }
            case "Spurs":
            {
                drawable = context.getResources().getDrawable(R.drawable.spurs);

                break;
            }
            case "Suns":
            {
                drawable = context.getResources().getDrawable(R.drawable.suns);

                break;
            }
            case "Thunder":
            {
                drawable = context.getResources().getDrawable(R.drawable.thunder);

                break;
            }
            case "Timberwolves":
            {
                drawable = context.getResources().getDrawable(R.drawable.wolves);

                break;
            }
            case "Trail Blazers":
            {
                drawable = context.getResources().getDrawable(R.drawable.blazers);

                break;
            }
            case "Warriors":
            {
                drawable = context.getResources().getDrawable(R.drawable.warriors);

                break;
            }
            case "Wizards":
            {
                drawable = context.getResources().getDrawable(R.drawable.wizards);

                break;
            }
            default:
                drawable = null;
        }
        return drawable;
    }
}
