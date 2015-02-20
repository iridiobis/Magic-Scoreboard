package es.benitos.magicscoreboard.views;

import android.content.Context;
import android.content.DialogInterface;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.app.AlertDialog;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import es.benitos.magicscoreboard.R;



public class ScoreView extends RelativeLayout {
    @InjectView(R.id.score_score)
    TextView scoreView;

    @InjectView(R.id.score_name)
    TextView nameView;


    public ScoreView(Context context) {
        super(context);
    }

    public ScoreView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ScoreView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.inject(this);

    }



    public void setScore(final int score) {

        if(score!=0) {
            scoreView.setText(Integer.toString(score));



        }
        else {

            Toast toast1 =
                    Toast.makeText(getContext(),
                            "Uno menos...", Toast.LENGTH_LONG);

            toast1.show();
            scoreView.setTextSize(28);
//            scoreView.setHeight(80);
            scoreView.setText("ELIMINADO");
            //     this.setVisibility(GONE);
            enableDisableView(this, false);

        }
    }

    public void setName(final String name){nameView.setText(name);}

    @OnClick(R.id.score_add)
    public void addToScore(){
        int score = Integer.parseInt(scoreView.getText().toString());
        score++;
        setScore(score);
    }

    //Deshabilita el layout cuando se score llega a 0


    private void enableDisableView(View view, boolean enabled) {
        view.setEnabled(enabled);

        if ( view instanceof ViewGroup ) {
            ViewGroup group = (ViewGroup)view;

            for ( int idx = 0 ; idx < group.getChildCount() ; idx++ ) {
                enableDisableView(group.getChildAt(idx), enabled);
            }
        }
    }

    @OnClick(R.id.score_subtract)
    public void subtractToScore(){

        int score = Integer.parseInt(scoreView.getText().toString());
        score--;
        if(score!=0){

            setScore(score);

        }
        else {


            AlertDialog.Builder builder1 = new AlertDialog.Builder(getContext());
            builder1.setMessage("Este jugador será eliminado. ¿Continuar?");
            builder1.setCancelable(true);

            builder1.setPositiveButton("Si",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            setScore(0);
                            dialog.cancel();
                        }
                    });
            builder1.setNegativeButton("No",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            //no me deja poner score = 1;
                            setScore(1);
                            dialog.cancel();
                        }
                    });

            AlertDialog alert11 = builder1.create();
            alert11.show();
        }

    }



}
