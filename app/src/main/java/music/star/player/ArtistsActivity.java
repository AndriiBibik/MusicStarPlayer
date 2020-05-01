package music.star.player;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.flexbox.FlexboxLayout;

import butterknife.ButterKnife;
import butterknife.OnClick;
import music.star.player.custom.Album;
import music.star.player.custom.Artist;

public class ArtistsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artists);

        ButterKnife.bind(this);

        FlexboxLayout flexboxLayout = findViewById(R.id.flexbox_artists);

        Artist[] artists = new Artist[] {
                MainActivity.ARIANA_GRANDE,
                MainActivity.BILLIE_EILISH,
                MainActivity.MUSE };

        for (Artist artist: artists) {
            View itemLayout = LayoutInflater.from(this).inflate(R.layout.item_artist, null, true);
            ((ImageView) itemLayout.findViewById(R.id.artist_ic_in_artists)).setImageResource(artist.getImageId());
            ((TextView) itemLayout.findViewById(R.id.artist_in_artists)).setText(artist.getNameId());

            flexboxLayout.addView(itemLayout);
        }
    }

    @OnClick(R.id.button_all_songs)
    void gotoArtists() {
        Intent intent = new Intent(ArtistsActivity.this, MainActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.button_albums)
    void gotoAllSongs() {
        Intent intent = new Intent(ArtistsActivity.this, AlbumsActivity.class);
        startActivity(intent);
    }
}