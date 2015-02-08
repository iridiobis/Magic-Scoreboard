package es.benitos.magicscoreboard.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import es.benitos.magicscoreboard.R;

public class ScoreView extends RelativeLayout {
    @InjectView(R.id.score_score)
    TextView scoreView;

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
        scoreView.setText(Integer.toString(score));
    }

    @OnClick(R.id.score_add)
    public void addToScore(){
        int score = Integer.parseInt(scoreView.getText().toString());
        score++;
        setScore(score);
    }

    @OnClick(R.id.score_subtract)
    public void subtractToScore(){
        int score = Integer.parseInt(scoreView.getText().toString());
        score--;
        setScore(score);
    }
}
