package es.benitos.magicscoreboard.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.view.ViewGroup.LayoutParams;

import butterknife.ButterKnife;
import butterknife.InjectView;
import es.benitos.magicscoreboard.R;
import es.benitos.magicscoreboard.util.Strings;


public class NamePlayers extends ActionBarActivity {


    public static Intent getIntent(Context context,int valor){
        Intent intent = new Intent(context,NamePlayers.class);
        intent.putExtra("RE", valor);
        return intent;
    }

    @InjectView(R.id.name_container)
    View LLnameContainer;

    @InjectView(R.id.btnEmpezar)
    Button btnempezar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nameplayers);
        ButterKnife.inject(this);

        int numjugadores =getIntent().getIntExtra("RE",0);
        int players;
        final String str;

        if (numjugadores==4){

            players=2;
            str=getString(R.string.namePlayers_teamFormat);

        }
        else{
            str=getString(R.string.namePlayers_playerFormat);
            players=numjugadores;
        }


        for(int i=0;i<players;i++) {

            EditText view = new EditText(this);
            view.setHint(String.format(str, i + 1));
            view.setSingleLine();
            view.setInputType(InputType.TYPE_TEXT_FLAG_CAP_SENTENCES);
            view.setLayoutParams(new LinearLayout.LayoutParams(
                    LayoutParams.MATCH_PARENT,
                    LayoutParams.WRAP_CONTENT));

            ((LinearLayout)LLnameContainer).addView(view);

        }



        final int finalNumjugadores = numjugadores;

        btnempezar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ViewGroup viu = (LinearLayout)LLnameContainer;
                String string = new String();
                EditText editText;
                Intent intent = new Intent();
                for(int index=0;index<viu.getChildCount();index++){
                    editText = (EditText)viu.getChildAt(index);
                    string= Strings.valueOrDefault(
                            editText.getText().toString(),
                            editText.getHint().toString());
                    intent.putExtra(String.valueOf(index),string);
                }
                setResult(RESULT_OK,intent);
                finish();

            }




    });


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
                Intent intent = MainActivity.getIntent(NamePlayers.this);
                startActivity(intent);
                return true;
            case R.id.salir:
                Intent salida=MainActivity.getIntent(NamePlayers.this);
                startActivity(salida);
                System.exit(0);
                return true;

        }
        return super.onOptionsItemSelected(item);
    }


}
