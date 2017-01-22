package com.example.daniel.loldatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Daniel on 5/30/2016.
 */
public class champ_page_1 extends AppCompatActivity implements android.view.View.OnClickListener{
    String abilityText;
    String[] statText;
    String champion;
    String champ_number;
    String column = "passive";
    String stats_column = "passive_stats";
    TextView desc;
    TextView ab_stat;
    TextView ab_name;
    DatabaseAccess databaseAccess;

    ImageButton pass;
    ImageButton ab_1;
    ImageButton ab_2;
    ImageButton ab_3;
    ImageButton ult;

    TextView skintext_1;
    TextView skintext_2;
    TextView skintext_3;
    TextView skintext_4;
    TextView skintext_5;
    TextView skintext_6;
    TextView skintext_7;
    TextView skintext_8;
    TextView skintext_9;
    TextView skintext_10;
    TextView skintext_11;

    ImageView skin_1;
    ImageView skin_2;
    ImageView skin_3;
    ImageView skin_4;
    ImageView skin_5;
    ImageView skin_6;
    ImageView skin_7;
    ImageView skin_8;
    ImageView skin_9;
    ImageView skin_10;
    ImageView skin_11;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.champ_page_1);
        getSupportActionBar().hide();

        //Get champion ID from intent
        Bundle extras = getIntent().getExtras();
        champ_number = extras.getString("button_id");

        desc = (TextView) findViewById(R.id.desc);
        ab_stat = (TextView) findViewById(R.id.ab_stat);
        ab_name = (TextView) findViewById(R.id.ab_name);
        TextView name = (TextView) findViewById(R.id.name);
        TextView title = (TextView) findViewById(R.id.title);

        databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();

        String[] champ_name = databaseAccess.get_info(champ_number,"name").split("~");
        champion = champ_name[0].toLowerCase().replace(" ","_");
        name.setText(champ_name[0]);
        title.setText(champ_name[1]);

        //Set references for ability buttons
        pass = (ImageButton) findViewById(R.id.pass);
        ab_1 = (ImageButton) findViewById(R.id.ab_1);
        ab_2 = (ImageButton) findViewById(R.id.ab_2);
        ab_3 = (ImageButton) findViewById(R.id.ab_3);
        ult = (ImageButton) findViewById(R.id.ult);

        //Set references for skin images
        skin_1 = (ImageView) findViewById(R.id.skin_1);
        skin_2 = (ImageView) findViewById(R.id.skin_2);
        skin_3 = (ImageView) findViewById(R.id.skin_3);
        skin_4 = (ImageView) findViewById(R.id.skin_4);
        skin_5 = (ImageView) findViewById(R.id.skin_5);
        skin_6 = (ImageView) findViewById(R.id.skin_6);
        skin_7 = (ImageView) findViewById(R.id.skin_7);
        skin_8 = (ImageView) findViewById(R.id.skin_8);
        skin_9 = (ImageView) findViewById(R.id.skin_9);
        skin_10 = (ImageView) findViewById(R.id.skin_10);
        skin_11 = (ImageView) findViewById(R.id.skin_11);

        //Set references for skin names
        skintext_1 = (TextView) findViewById(R.id.skintext_1);
        skintext_2 = (TextView) findViewById(R.id.skintext_2);
        skintext_3 = (TextView) findViewById(R.id.skintext_3);
        skintext_4 = (TextView) findViewById(R.id.skintext_4);
        skintext_5 = (TextView) findViewById(R.id.skintext_5);
        skintext_6 = (TextView) findViewById(R.id.skintext_6);
        skintext_7 = (TextView) findViewById(R.id.skintext_7);
        skintext_8 = (TextView) findViewById(R.id.skintext_8);
        skintext_9 = (TextView) findViewById(R.id.skintext_9);
        skintext_10 = (TextView) findViewById(R.id.skintext_10);
        skintext_11 = (TextView) findViewById(R.id.skintext_11);

        //Set the text for the skin names if there is one
       set_skin_text(skintext_1,databaseAccess.get_info(champ_number,"skin_1"));
        set_skin_text(skintext_2,databaseAccess.get_info(champ_number,"skin_2"));
        set_skin_text(skintext_3,databaseAccess.get_info(champ_number,"skin_3"));
        set_skin_text(skintext_4,databaseAccess.get_info(champ_number,"skin_4"));
        set_skin_text(skintext_5,databaseAccess.get_info(champ_number,"skin_5"));
        set_skin_text(skintext_6,databaseAccess.get_info(champ_number,"skin_6"));
        set_skin_text(skintext_7,databaseAccess.get_info(champ_number,"skin_7"));
        set_skin_text(skintext_8,databaseAccess.get_info(champ_number,"skin_8"));
        set_skin_text(skintext_9,databaseAccess.get_info(champ_number,"skin_9"));
        set_skin_text(skintext_10,databaseAccess.get_info(champ_number,"skin_10"));
        set_skin_text(skintext_11,databaseAccess.get_info(champ_number,"skin_11"));

        //Set listener for ability buttons
        pass.setOnClickListener(this);
        ab_1.setOnClickListener(this);
        ab_2.setOnClickListener(this);
        ab_3.setOnClickListener(this);
        ult.setOnClickListener(this);

        //Passive ability button is used by default first
        onClick(findViewById(R.id.pass));

        databaseAccess.close();

        //Set the image for each skin image
        set_button_image(pass,champion+"_pass");
        set_button_image(ab_1,champion+"_ab_1");
        set_button_image(ab_2,champion+"_ab_2");
        set_button_image(ab_3,champion+"_ab_3");
        set_button_image(ult,champion+"_ult");
        set_image(skin_1,champion+"_skin_1");
        set_image(skin_2,champion+"_skin_2");
        set_image(skin_3,champion+"_skin_3");
        set_image(skin_4,champion+"_skin_4");
        set_image(skin_5,champion+"_skin_5");
        set_image(skin_6,champion+"_skin_6");
        set_image(skin_7,champion+"_skin_7");
        set_image(skin_8,champion+"_skin_8");
        set_image(skin_9,champion+"_skin_9");
        set_image(skin_10,champion+"_skin_10");
        set_image(skin_11,champion+"_skin_11");

    }

    @Override
    public void onClick(View v) {
        if (v == findViewById(R.id.pass)) {
            column = "passive";
            stats_column = "passive_stats";
        }
        if (v == findViewById(R.id.ab_1)) {
            column = "ability_1";
            stats_column = "ab_1_stats";
        }
        if (v == findViewById(R.id.ab_2)) {
            column = "ability_2";
            stats_column = "ab_2_stats";
        }
        if (v == findViewById(R.id.ab_3)) {
            column = "ability_3";
            stats_column = "ab_3_stats";
        }
        if (v == findViewById(R.id.ult)) {
            column = "ultimate";
            stats_column = "ultimate_stats";
        }
        databaseAccess.open();

        abilityText = databaseAccess.get_info(champ_number,column);
        statText = databaseAccess.get_info(champ_number,stats_column).split("~");
        desc.setText(abilityText);
        ab_name.setText(statText[0]);
        ab_stat.setText(statText[1]);
        databaseAccess.close();
    }

    public int convertDpToPixel(float dp){
        return Math.round(dp*(getResources().getDisplayMetrics().xdpi/DisplayMetrics.DENSITY_DEFAULT));
    }

    public void set_image(ImageView skin_view, String drawable_name){
        int resID = getResources().getIdentifier(drawable_name , "drawable", getPackageName());
        if(resID != 0){
            LinearLayout.LayoutParams llp = new LinearLayout.LayoutParams(LinearLayoutCompat.LayoutParams.WRAP_CONTENT, LinearLayoutCompat.LayoutParams.WRAP_CONTENT);
            llp.setMargins(0, 0, convertDpToPixel(20), 0); // llp.setMargins(left, top, right, bottom);
            skin_view.setLayoutParams(llp);

            skin_view.setImageResource(resID);
            skin_view.getLayoutParams().width = convertDpToPixel(270);
        }
        else{
            skin_view.getLayoutParams().width = convertDpToPixel(0);
        }
        }


    public void set_button_image(ImageButton ab_button, String drawable_name) {
        int resID = getResources().getIdentifier(drawable_name , "drawable", getPackageName());
        if(resID != 0){
            ab_button.setImageResource(resID);
        }

    }
    public void set_skin_text(TextView skin_text, String text){
        skin_text.setText(text);
        if(text.length() > 1){
            LinearLayout.LayoutParams llp = new LinearLayout.LayoutParams(LinearLayoutCompat.LayoutParams.WRAP_CONTENT, LinearLayoutCompat.LayoutParams.WRAP_CONTENT);
            llp.setMargins(0, 0, convertDpToPixel(20), 0); // llp.setMargins(left, top, right, bottom);
            skin_text.setLayoutParams(llp);

            skin_text.setWidth(convertDpToPixel(270));
        }
        else{
            skin_text.setWidth(0);
        }

    }

}
