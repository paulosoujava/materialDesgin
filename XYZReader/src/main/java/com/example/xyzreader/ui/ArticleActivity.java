package com.example.xyzreader.ui;

import android.content.Intent;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.xyzreader.R;
import com.squareup.picasso.Picasso;

public class ArticleActivity extends AppCompatActivity {

    private TextView author;
    private TextView title;
    private TextView body;
    private TextView aspect_radio;
    private ImageView phot_url;
    private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);

        toolbar = (Toolbar) findViewById(R.id.toolbar);

        author = (TextView) findViewById(R.id.author);
        title = (TextView) findViewById(R.id.title);
        body =  (TextView) findViewById(R.id.body);
        aspect_radio =  (TextView) findViewById(R.id.radio);
        phot_url =  (ImageView) findViewById(R.id.phot_url);

        Intent it = getIntent();

        if( it != null  ){

            String titleIt = it.getStringExtra("TITLE");
            toolbar.setTitle(titleIt);
            title.setText(  titleIt.toString() );

            String authorIt = it.getStringExtra("AUTHOR");
            author.setText(  authorIt.toString() );

            String radioIt = it.getStringExtra("ASPECT_RATIO");
            aspect_radio.setText( radioIt.toString() );


            String bodyIt = it.getStringExtra("BODY");
            bodyIt = bodyIt.replaceAll("(\\r|\\n)", "");

            body.setText(  bodyIt.toString().toLowerCase() );


            Picasso.get().load(it.getStringExtra("PHOTO_URL")).into(phot_url);

        }

    }

    public void fab(View view) {
        startActivity(Intent.createChooser(ShareCompat.IntentBuilder.from(this)
                .setType("text/plain")
                .setText("Some sample text")
                .getIntent(), getString(R.string.action_share)));
    }
}
