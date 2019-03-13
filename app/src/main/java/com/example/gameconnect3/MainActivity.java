package com.example.gameconnect3;

        import android.media.Image;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.text.Layout;
        import android.view.View;
        import android.widget.ImageView;
        import android.widget.LinearLayout;
        import android.widget.TextView;
        import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageView i[] = new ImageView[10];
    int gameState[] = {2,2,2,2,2,2,2,2,2,2};
    int count = 0;
    boolean gameIsActive = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        defaultState(i);
    }

    public void dropImage(View view) {
        if(gameIsActive) {
            ImageView image = (ImageView) view;
            LinearLayout playAgainLayout = (LinearLayout) findViewById(R.id.playAgainLayout);

            count++;
            if (count % 2 == 1) {
                image.setImageResource(R.drawable.red);
                gameState[Integer.parseInt(image.getTag().toString())] = 0;
            } else {
                image.setImageResource(R.drawable.yellow);
                gameState[Integer.parseInt((image.getTag().toString()))] = 1;
            }
            image.setTranslationY(-1000f);

            image.animate().translationYBy(1000f).setDuration(300);
            image.setAlpha(1000);
            //Toast.makeText(MainActivity.this,"image clicked",Toast.LENGTH_SHORT).show();
            image.setOnClickListener(null);

            checkWinner(i);
        }

    }
    public void checkWinner(ImageView i[]) {
        //Toast.makeText(MainActivity.this,"Toast is working",Toast.LENGTH_SHORT).show();
        //row wise winner
        int winner = 2;
        // rowwise winner
        for(int j =0;j < 3;j++) {
            if(gameState[3*j+1] == gameState[3*j+2] && gameState[3*j+2]== gameState[3*j+3] && gameState[3*j+1] != 2) {
                winner = gameState[3*j+1];
                displayWinner(winner);
                LinearLayout playAgainLayout = (LinearLayout) findViewById(R.id.playAgainLayout);
                playAgainLayout.setVisibility(View.VISIBLE);
                return;
            }
        }
        for(int j =0;j < 3;j++) {
            if(gameState[3*j+1] == gameState[3*j+2] && gameState[3*j+2]== gameState[3*j+3] && gameState[3*j+1] != 2) {
                winner = gameState[3*j+1];
                displayWinner(winner);
                LinearLayout playAgainLayout = (LinearLayout) findViewById(R.id.playAgainLayout);
                playAgainLayout.setVisibility(View.VISIBLE);
                return;
            }
        }
        for(int j = 1;j < 4;j++) {
            if(gameState[3*0+j] == gameState[3*1+j] && gameState[3*1+j]== gameState[3*2+j] && gameState[3*0+j] != 2) {
                winner = gameState[3*0+j];
                displayWinner(winner);
                LinearLayout playAgainLayout = (LinearLayout) findViewById(R.id.playAgainLayout);
                playAgainLayout.setVisibility(View.VISIBLE);
                return;
            }
        }
        if(gameState[1] == gameState[5] && gameState[5] == gameState[9] && gameState[1] != 2) {
            winner = gameState[1];
            displayWinner(winner);
            LinearLayout playAgainLayout = (LinearLayout) findViewById(R.id.playAgainLayout);
            playAgainLayout.setVisibility(View.VISIBLE);
            return;
        }
        if(gameState[3] == gameState[5] && gameState[5] == gameState[7] && gameState[3] != 2) {
            winner = gameState[3];
            displayWinner(winner);
            LinearLayout playAgainLayout = (LinearLayout) findViewById(R.id.playAgainLayout);
            playAgainLayout.setVisibility(View.VISIBLE);
            return;
        }
        if(count == 9 && winner == 2) {
            TextView declareWinner = (TextView) findViewById(R.id.declareWinner);
            declareWinner.setText("Match Draw");
            LinearLayout playAgainLayout = (LinearLayout) findViewById(R.id.playAgainLayout);
            playAgainLayout.setVisibility(View.VISIBLE);
            gameIsActive = false;
        }
    }
    private void displayWinner(int winner) {
        TextView declareWinner = (TextView) findViewById(R.id.declareWinner);
        if(winner == 0) {
            declareWinner.setText("Player 1 won the game");
        }
        else{
            declareWinner.setText("Player 2 won the game");
        }
        gameIsActive = false;
     }
    /*private int getImageResource(ImageView iv) {
        return (Integer) iv.getTag();
    }*/
    private void defaultState(ImageView i[]) {
        for(int j=0;j<10;j++) {
            gameState[j] = 2;
        }
        count = 0;
        gameIsActive = true;
        i[1] = (ImageView) findViewById(R.id.imageView18);
        i[1].setAlpha(0);
        i[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dropImage(v);
            }
        });
        i[2] = (ImageView) findViewById(R.id.imageView17);
        i[2].setAlpha(0);
        i[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dropImage(v);
            }
        });
        i[3] = (ImageView) findViewById(R.id.imageView16);
        i[3].setAlpha(0);
        i[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dropImage(v);
            }
        });
        i[4] = (ImageView) findViewById(R.id.imageView15);
        i[4].setAlpha(0);
        i[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dropImage(v);
            }
        });
        i[5] = (ImageView) findViewById(R.id.imageView14);
        i[5].setAlpha(0);
        i[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dropImage(v);
            }
        });
        i[6] = (ImageView) findViewById(R.id.imageView19);
        i[6].setAlpha(0);
        i[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dropImage(v);
            }
        });
        i[7] = (ImageView) findViewById(R.id.imageView21);
        i[7].setAlpha(0);
        i[7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dropImage(v);
            }
        });
        i[8] = (ImageView) findViewById(R.id.imageView20);
        i[8].setAlpha(0);
        i[8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dropImage(v);
            }
        });
        i[9] = (ImageView) findViewById(R.id.imageView12);
        i[9].setAlpha(0);
        i[9].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dropImage(v);
            }
        });
    }
    public void playAgain(View view) {
        defaultState(i);
        LinearLayout playAgainLayout = (LinearLayout) findViewById(R.id.playAgainLayout);
        playAgainLayout.setVisibility(View.INVISIBLE);
    }
    public void exit(View view) {
       System.exit(0);
    }
}
