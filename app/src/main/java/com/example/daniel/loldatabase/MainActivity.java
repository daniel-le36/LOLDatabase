package com.example.daniel.loldatabase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    DatabaseAccess databaseAccess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        databaseAccess = DatabaseAccess.getInstance(this);

        ImageButton button_1 = (ImageButton) findViewById(R.id.button_1);
        ImageButton button_2 = (ImageButton) findViewById(R.id.button_2);
        ImageButton button_3 = (ImageButton) findViewById(R.id.button_3);
        ImageButton button_4 = (ImageButton) findViewById(R.id.button_4);
        ImageButton button_5 = (ImageButton) findViewById(R.id.button_5);
        ImageButton button_6 = (ImageButton) findViewById(R.id.button_6);
        ImageButton button_7 = (ImageButton) findViewById(R.id.button_7);
        ImageButton button_8 = (ImageButton) findViewById(R.id.button_8);
        ImageButton button_9 = (ImageButton) findViewById(R.id.button_9);
        ImageButton button_10 = (ImageButton) findViewById(R.id.button_10);
        ImageButton button_11 = (ImageButton) findViewById(R.id.button_11);

        button_1.setOnClickListener(this);
        button_2.setOnClickListener(this);
        button_3.setOnClickListener(this);
        button_4.setOnClickListener(this);
        button_5.setOnClickListener(this);
        button_6.setOnClickListener(this);
        button_7.setOnClickListener(this);
        button_8.setOnClickListener(this);
        button_9.setOnClickListener(this);
        button_10.setOnClickListener(this);
        button_11.setOnClickListener(this);

        set_image(button_1);
        set_image(button_2);
        set_image(button_3);
        set_image(button_4);
        set_image(button_5);
        set_image(button_6);
        set_image(button_7);
        set_image(button_8);
        set_image(button_9);
        set_image(button_10);
        set_image(button_11);
    }
    public void onClick(View v) {
        String name = v.getResources().getResourceName(v.getId());
        String button_id = name.substring(name.length()-1);
        Intent newIntent = new Intent(MainActivity.this,champ_page_1.class);
        newIntent.putExtra("button_id",button_id);
        startActivity(newIntent);
    }

    public void set_image(ImageButton champ_button){
        databaseAccess.open();

        String name = champ_button.getResources().getResourceName(champ_button.getId());
        //String button_id = name.substring(name.length()-1);
        String[] button_str = name.split("_");
        String button_id = button_str[1];
        String[] champ_name = databaseAccess.get_info(button_id,"name").split("~");
        String champion = champ_name[0].toLowerCase().replace(" ","_");
        int resID = getResources().getIdentifier(champion , "drawable", getPackageName());
        champ_button.setImageResource(resID);

        databaseAccess.close();
    }

}
