package fm.kirtsim.kharos.facebookapp;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import fm.kirtsim.kharos.facebookapp.facebook.FBLoginFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction().add(R.id.container, FBLoginFragment.newInstance(null), null).commit();
    }
}
