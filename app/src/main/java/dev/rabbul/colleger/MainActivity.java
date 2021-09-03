package dev.rabbul.colleger;


import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.navigation.NavigationView;
import com.rabbul.colleger.R;

import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    Toolbar toolbar;
    DrawerLayout drawer;
    ActionBarDrawerToggle toggle;
    NavigationView navigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer = findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        getSupportActionBar().setTitle("");

    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.questions:
                Intent qs = new Intent(MainActivity.this, Questions.class);
                startActivity(qs);
                //Do something Here
                break;
            case R.id.ebooks:
                Intent eb = new Intent(MainActivity.this, WebView.class);
                eb.putExtra("URL","http://gutenberg.org");
                startActivity(eb);
                //Do something Here
                break;
            case R.id.exam_routine:
                Intent rt = new Intent(MainActivity.this, Routine.class);
                startActivity(rt);
                //Do something Here
                break;
            case R.id.syllabus:
                Intent sl = new Intent(MainActivity.this, Syllabus.class);
                startActivity(sl);
                //Do something Here
                break;
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void routine(View view) {
        Intent rt = new Intent(this,Routine.class);
        startActivity(rt);
    }

    public void syllabus(View view) {
        Intent sl = new Intent(MainActivity.this, Syllabus.class);
        startActivity(sl);
    }

    public void ebook(View view) {
        Intent eb = new Intent(MainActivity.this, WebView.class);
        eb.putExtra("URL","https://gutenberg.org");
        startActivity(eb);
    }

    public void questions(View view) {
        Intent qs = new Intent(MainActivity.this, Questions.class);
        startActivity(qs);
    }

    public void exam(View view) {
        
    }

    public void news(View view) {
        Toast toast = Toast.makeText(getApplicationContext(),"Will be added soon",Toast.LENGTH_SHORT);
        toast.show();
    }
}