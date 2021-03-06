package com.testinprod.spotifystreamer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;


public class TopTenSongsActivity extends AppCompatActivity {
    private static final String LOG_TAG = TopTenSongsActivity.class.getSimpleName();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_ten_songs);

        ArtistSimpleParcelable artist = getIntent().getExtras().getParcelable(ArtistSimpleParcelable.EXTRA_SIMPLE_ARTIST);
        if(savedInstanceState == null)
        {

            if(artist!= null) {
                TopTenSongsActivityFragment topTenSongsActivityFragment = TopTenSongsActivityFragment.newInstance(artist);
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.framelayout_top_ten_songs,topTenSongsActivityFragment)
                        .commit();
            }
        }

        this.setTitle(artist.name);

    }


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_top_ten_songs, menu);
//        return true;
//    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
