package com.example.appbar;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class Menu {
    private static Intent intent;

    public static int HandleMenu(Context c, int itemId) {
        switch (itemId) {
                case R.id.action_settings:
                    intent = new Intent(c, MainActivity.class);
                    c.startActivity(intent);
                    Toast.makeText(c, R.string.mnSettings, Toast.LENGTH_SHORT).show();
                    break;
                case R.id.action_open_first:
                    intent = new Intent(c, FirstActivity.class);
                    c.startActivity(intent);
                    Toast.makeText(c, R.string.mnFirst, Toast.LENGTH_SHORT).show();
                    break;
                case R.id.action_open_splash:
                    intent = new Intent(c, SplashScreenActivity.class);
                    c.startActivity(intent);
                    Toast.makeText(c, R.string.mnSplash, Toast.LENGTH_SHORT).show();
                    break;
                case R.id.action_open_universal:
                    intent = new Intent(c, UniversalActivity.class);
                    c.startActivity(intent);
                    Toast.makeText(c, R.string.mnUniversal, Toast.LENGTH_SHORT).show();
                    break;
                case R.id.action_open_transition:
                    intent = new Intent(c, TransitionActivity.class);
                    c.startActivity(intent);
                    Toast.makeText(c, R.string.mnTransition, Toast.LENGTH_SHORT).show();
                    break;
                case R.id.action_open_monitoring:
                    intent = new Intent(c, MonitoringActivity.class);
                    c.startActivity(intent);
                    Toast.makeText(c, R.string.mnMonitoring, Toast.LENGTH_SHORT).show();
                    break;
                case R.id.action_open_checkbox:
                    intent = new Intent(c, CheckboxActivity.class);
                    c.startActivity(intent);
                    Toast.makeText(c, R.string.mnCheckbox, Toast.LENGTH_SHORT).show();
                    break;
                case R.id.action_open_spinner:
                    intent = new Intent(c, SpinnerActivity.class);
                    c.startActivity(intent);
                    Toast.makeText(c, R.string.mnSpinner, Toast.LENGTH_SHORT).show();
                    break;
                case R.id.action_open_calendar:
                    intent = new Intent(c, CalendarActivity.class);
                    c.startActivity(intent);
                    Toast.makeText(c, R.string.mnCalendar, Toast.LENGTH_SHORT).show();
                    break;
                case R.id.action_open_notes:
                    intent = new Intent(c, NotesActivity.class);
                    c.startActivity(intent);
                    Toast.makeText(c, R.string.mnNotes, Toast.LENGTH_LONG).show();
                    break;
            }
        return itemId;
    }
}