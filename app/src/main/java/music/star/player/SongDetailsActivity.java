package music.star.player;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class SongDetailsActivity extends AppCompatActivity {

    @BindView(R.id.song_title_in_details) TextView songTitleTextView;
    @BindView(R.id.song_artist_in_details) TextView songArtistTextView;
    @BindView(R.id.album_title_in_details) TextView songAlbumTitleTextView;
    @BindView(R.id.album_ic_in_details) ImageView songAlbumArtImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_details);

        ButterKnife.bind(this);

        //display back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //getting extras
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            songTitleTextView.setText(extras.getInt(MainActivity.EXTRA_SONG_TITLE));
            songArtistTextView.setText(extras.getInt(MainActivity.EXTRA_SONG_ARTIST));
            songAlbumTitleTextView.setText(extras.getInt(MainActivity.EXTRA_SONG_ALBUM_TITLE));
            songAlbumArtImageView.setImageResource(extras.getInt(MainActivity.EXTRA_SONG_ALBUM_ART));
        }
    }
}
