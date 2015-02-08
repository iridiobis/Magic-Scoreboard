package es.benitos.magicscoreboard;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

import butterknife.ButterKnife;
import butterknife.InjectView;
import es.benitos.magicscoreboard.views.ScoreView;


public class MainActivity extends ActionBarActivity {
    @InjectView(R.id.main_container)
    LinearLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        ScoreView view = (ScoreView) LayoutInflater.from(this).inflate(R.layout.score_view, null);
        view.setScore(20);
        container.addView(view);
        view = (ScoreView) LayoutInflater.from(this).inflate(R.layout.score_view, null);
        view.setScore(20);
        container.addView(view);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
