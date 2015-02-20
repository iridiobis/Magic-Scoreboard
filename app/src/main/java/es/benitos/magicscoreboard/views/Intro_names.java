package es.benitos.magicscoreboard.views;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import es.benitos.magicscoreboard.R;

/**
 * Created by dbe on 2/15/2015.
 */
public class Intro_names extends RelativeLayout {

//    @InjectView(R.id.txtnombre)
//    TextView Txtnombre;




    public Intro_names(Context context) {
        super(context);
    }
    public Intro_names(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Intro_names(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.inject(this);

    }

//    public void setTexto(final int num){Txtnombre.setText("JUGADOR "+ num);}




}