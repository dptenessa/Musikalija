package hr.bonbon.musikalija;


import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import java.util.Random;

public class MainActivity extends YouTubeBaseActivity {

    Button b;
    private YouTubePlayerView youTubePlayerView;
    private YouTubePlayer.OnInitializedListener onInitializedListener;

    String[] Preg0 = {
            "dsUXAEzaC3Q",
            "When was Michael Jackson born?",
            "1953",
            "1967",
            "1981",
            "1"
    };

    String[] Preg1 = {
            "PKB4cioGs98",
            "Can you guess the author of this song?",
            "Madonna",
            "Jax Jones",
            "B-92",
            "2"
    };

    String[] Preg2 = {
            "XaE_9pfybL4",
            "Can you recognize which song this is?",
            "Way down we go",
            "I kissed a girl",
            "Bad",
            "1"
    };

    String[] Preg3 = {
            "10mMDtpfcQM",
            "Can you name the only international nr.1 author Belgium has ever had?",
            "Marie Pierre Pelirot",
            "Soeur Sourire",
            "Jean Claude Van Damne",
            "2"
    };


    String[][] Preguntas={Preg0,Preg1,Preg2,Preg3};

    RadioGroup rg;
    RadioButton rb;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rg =(RadioGroup)findViewById(R.id.radioGroup);

        youTubePlayerView = (YouTubePlayerView) findViewById(R.id.YTview);


        onInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                Random rand = new Random();
                int videonumber = rand.nextInt(5);

                RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 360.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                rotateAnimation.setInterpolator(new LinearInterpolator());
                rotateAnimation.setRepeatCount(50); //anim.setRepeatCount(Animation.INFINITE); //Repeat animation indefinitely
                rotateAnimation.setDuration(700);

                // Start animating the image
                final ImageView logobonbon = (ImageView) findViewById(R.id.logobonbon);
                logobonbon.startAnimation(rotateAnimation);

                //TranslateAnimation translateAnimation = new TranslateAnimation(Animation.ABSOLUTE, 1, Animation.ABSOLUTE, 2,Animation.ABSOLUTE,0,Animation.ABSOLUTE,100);
                TranslateAnimation translateAnimation = new TranslateAnimation(100, 0,0,0);
                translateAnimation.setDuration(1000);
                //final AlphaAnimation alphaAnimation= new AlphaAnimation(0.5f,1);
                //alphaAnimation.setDuration(1000);

                QaA QaA = new QaA(Preguntas[videonumber][0],Preguntas[videonumber][1],Preguntas[videonumber][2],Preguntas[videonumber][3],Preguntas[videonumber][4],Preguntas[videonumber][5]);
                TextView tv1 = (TextView)findViewById(R.id.textView1);
                RadioButton rb2 = (RadioButton) findViewById(R.id.radioButton2);
                RadioButton rb3 = (RadioButton) findViewById(R.id.radioButton3);
                RadioButton rb4 = (RadioButton) findViewById(R.id.radioButton4);
                rb2.setVisibility(View.VISIBLE);
                rb3.setVisibility(View.VISIBLE);
                rb4.setVisibility(View.VISIBLE);
                tv1.setText(QaA.getPregunta());
                rb2.setText(QaA.getRespuesta1());
                rb3.setText(QaA.getRespuesta2());
                rb4.setText(QaA.getRespuesta3());

                /*tv1.setText(Text1[videonumber]);
                rb2.setText(Text2[videonumber]);
                rb3.setText(Text3[videonumber]);
                rb4.setText(Text4[videonumber]);*/

                rb2.startAnimation(translateAnimation);
                rb3.startAnimation(translateAnimation);
                rb4.startAnimation(translateAnimation);

                //youTubePlayerView.startAnimation(alphaAnimation);
                youTubePlayerView.setVisibility(View.VISIBLE);
                YouTubePlayer.PlayerStyle style = YouTubePlayer.PlayerStyle.MINIMAL;
                youTubePlayer.setPlayerStyle(style);
                youTubePlayer.loadVideo(QaA.getVideocode());
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        };

        b = (Button) findViewById(R.id.Play);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                b.setVisibility(View.GONE);
                youTubePlayerView.initialize("AIzaSyC3cfRlUw-u9Kw0UJoLVtGpugmVtVK2P2Y",onInitializedListener);
            }
        });
    }


    public void rbclick (View v) {
        int radiobuttonid = rg.getCheckedRadioButtonId();
        rb = (RadioButton) findViewById(radiobuttonid);
        //Toast.makeText(getBaseContext(),rb.getText(),Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, Prize_Activity.class);
        startActivity(intent);


        ///layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(LAYOUT_INFLATER_SERVICE);
        ///ViewGroup container = (ViewGroup) layoutInflater.inflate(R.layout.activity_prize_, null);

        ///popupWindow = new PopupWindow(container, 400, 400, true);
        ///popupWindow.showAtLocation(linearLayout, Gravity.NO_GRAVITY, 500, 500);

        ///container.setOnTouchListener(new View.OnTouchListener() {
        ///    @Override
        ///    public boolean onTouch(View view, MotionEvent motionEvent) {
        ///        popupWindow.dismiss();
        ///        return true;
        ///    }
        ///});
    }

}
