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

public class AlbumsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_albums);

        ButterKnife.bind(this);

        FlexboxLayout flexboxLayout = findViewById(R.id.flexbox_albums);

        Album[] albums = new Album[] {
                MainActivity.ARIANA_GRANDE_ALBUM,
                MainActivity.BILLIE_EILISH_ALBUM,
                MainActivity.MUSE_ALBUM };

        for (Album album: albums) {
            View itemLayout = LayoutInflater.from(this).inflate(R.layout.item_album, null, true);
            ((ImageView) itemLayout.findViewById(R.id.album_ic_in_albums)).setImageResource(album.getArtId());
            ((TextView) itemLayout.findViewById(R.id.album_title_in_albums)).setText(album.getTitleId());
            ((TextView) itemLayout.findViewById(R.id.album_artist_in_albums)).setText(album.getArtistId());

            flexboxLayout.addView(itemLayout);
        }
    }

    @OnClick(R.id.button_artists)
    void gotoArtists() {
        Intent intent = new Intent(AlbumsActivity.this, ArtistsActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.button_all_songs)
    void gotoAllSongs() {
        Intent intent = new Intent(AlbumsActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
