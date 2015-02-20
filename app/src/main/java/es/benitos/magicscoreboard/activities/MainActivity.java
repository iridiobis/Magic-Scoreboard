package es.benitos.magicscoreboard.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

import butterknife.ButterKnife;
import butterknife.OnClick;
import es.benitos.magicscoreboard.R;


public class MainActivity extends ActionBarActivity {

    int numjugadores=0;

    public static Intent getIntent(Context context){
        Intent intent = new Intent(context,MainActivity.class);
        return intent;
    }


    protected void introducirNombres(int jugadores){

        Intent intent = NamePlayers.getIntent(MainActivity.this, jugadores);
        startActivityForResult(intent,1);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
    }

    @OnClick(R.id.BtnDos)
    public void selectTwoPlayers() {
        numjugadores=2;
        introducirNombres(numjugadores);
    }


    @OnClick(R.id.BtnTres)
    public void selectThreePlayers() {
        numjugadores=3;
        introducirNombres(numjugadores);
    }


    @OnClick(R.id.BtnCuatro)
    public void selectFourPlayers() {
        numjugadores=4;
        introducirNombres(numjugadores);
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
        switch (item.getItemId()){
            case R.id.salir:
                finish();
                return true;

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Intent intent=Contadores.getIntent(MainActivity.this,numjugadores);
        if (requestCode == 1) {
            if(resultCode == RESULT_OK){
                intent.putExtras(data);
                startActivity(intent);
            }
            if (resultCode == RESULT_CANCELED) {
                //Write your code if there's no result
            }
        }
    }
}
