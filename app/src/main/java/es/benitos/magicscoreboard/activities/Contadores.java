package es.benitos.magicscoreboard.activities;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.content.Context;

import butterknife.ButterKnife;
import butterknife.InjectView;
import es.benitos.magicscoreboard.R;
import es.benitos.magicscoreboard.views.ScoreView;


public class Contadores extends ActionBarActivity {


    public static Intent getIntent(Context context, int valor){
        Intent intent = new Intent(context,Contadores.class);
        intent.putExtra("RE", valor);
        return intent;
    }

    @InjectView(R.id.main_container)
    LinearLayout container;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contadores);
        ButterKnife.inject(this);

        int numcont =getIntent().getIntExtra("RE",0);
        int numjugadores = 0;
        String nombre;
        int vidas = 20;
        String str;

        if (numcont==4){

            numjugadores=2;
            vidas=30;

        }
        else{
            numjugadores=numcont;
        }

        for(int i=0;i<numjugadores;i++) {

            ScoreView view = (ScoreView) LayoutInflater.from(this).inflate(R.layout.score_view, null);
            view.setScore(vidas);
            view.setId(i);
            view.setName(getIntent().getStringExtra(String.valueOf(i)));
            container.addView(view);
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_contadores, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()){
            case R.id.nueva_partida:
                Intent intent = MainActivity.getIntent(Contadores.this);
                startActivity(intent);
                return true;
            case R.id.salir:
                Intent salida=MainActivity.getIntent(Contadores.this);
                //startActivity(salida);
                System.exit(0);
                return true;

        }
        return super.onOptionsItemSelected(item);
    }



}
