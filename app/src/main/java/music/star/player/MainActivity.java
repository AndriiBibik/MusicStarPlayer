package music.star.player;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import music.star.player.custom.Album;
import music.star.player.custom.Artist;
import music.star.player.custom.AudioTrack;

public class MainActivity extends AppCompatActivity {

    //Albums to work with
    public static final Album ARIANA_GRANDE_ALBUM =
            new Album(R.drawable.album_art_ariana_grande, R.string.album_ariana_grande, R.string.name_ariana_grande);
    public static final Album BILLIE_EILISH_ALBUM =
            new Album(R.drawable.album_art_billie_eilish, R.string.album_billie_eilish, R.string.name_billie_eilish);
    public static final Album MUSE_ALBUM =
            new Album(R.drawable.album_art_muse, R.string.album_muse, R.string.name_muse);

    //Artists to work with
    public static final Artist ARIANA_GRANDE =
            new Artist(R.drawable.artist_ariana_grande, R.string.name_ariana_grande);
    public static final Artist BILLIE_EILISH =
            new Artist(R.drawable.artist_billie_eilish, R.string.name_billie_eilish);
    public static final Artist MUSE =
            new Artist(R.drawable.artist_muse, R.string.name_muse);

    //Intent extras
    public static final String EXTRA_SONG_TITLE = "song_title";
    public static final String EXTRA_SONG_ARTIST = "song_artist";
    public static final String EXTRA_SONG_ALBUM_TITLE = "album_title";
    public static final String EXTRA_SONG_ALBUM_ART = "song_album_art";

    @BindView(R.id.list_all_songs) ListView songsListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // use ButterKnife
        ButterKnife.bind(this);

        ArrayList<AudioTrack> songs = new ArrayList<>();
        songs.add(new AudioTrack(R.string.song_ariana_grande_1, ARIANA_GRANDE, ARIANA_GRANDE_ALBUM));
        songs.add(new AudioTrack(R.string.song_ariana_grande_2, ARIANA_GRANDE, ARIANA_GRANDE_ALBUM));
        songs.add(new AudioTrack(R.string.song_ariana_grande_3, ARIANA_GRANDE, ARIANA_GRANDE_ALBUM));
        songs.add(new AudioTrack(R.string.song_billie_eilish_1, BILLIE_EILISH, BILLIE_EILISH_ALBUM));
        songs.add(new AudioTrack(R.string.song_billie_eilish_2, BILLIE_EILISH, BILLIE_EILISH_ALBUM));
        songs.add(new AudioTrack(R.string.song_billie_eilish_3, BILLIE_EILISH, BILLIE_EILISH_ALBUM));
        songs.add(new AudioTrack(R.string.song_muse_1, MUSE, MUSE_ALBUM));
        songs.add(new AudioTrack(R.string.song_muse_2, MUSE, MUSE_ALBUM));
        songs.add(new AudioTrack(R.string.song_muse_3, MUSE, MUSE_ALBUM));

        // ArrayAdapter
        final ArrayAdapter<AudioTrack> adapter =  new AudioTrackAdapter(this, songs);
        // Setting adapter
        songsListView.setAdapter(adapter);
        // Handling onItems click
        songsListView.setOnItemClickListener((adapterView, view, position, id) -> {
            Intent intent = new Intent(MainActivity.this, SongDetailsActivity.class);
            int songTitleId = ((AudioTrack) adapterView.getItemAtPosition(position)).getTitleId();
            int songArtistId = ((AudioTrack) adapterView.getItemAtPosition(position)).getArtist().getNameId();
            int songAlbumTitleId = ((AudioTrack) adapterView.getItemAtPosition(position)).getAlbum().getTitleId();
            int songAlbumArtId = ((AudioTrack) adapterView.getItemAtPosition(position)).getAlbum().getArtId();
            intent.putExtra(EXTRA_SONG_TITLE, songTitleId);
            intent.putExtra(EXTRA_SONG_ARTIST, songArtistId);
            intent.putExtra(EXTRA_SONG_ALBUM_ART, songAlbumArtId);
            intent.putExtra(EXTRA_SONG_ALBUM_TITLE, songAlbumTitleId);
            startActivity(intent);
        });
    }

    @OnClick(R.id.button_albums)
    void gotoAlbums() {
        Intent intent = new Intent(MainActivity.this, AlbumsActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.button_artists)
    void gotoArtists() {
        Intent intent = new Intent(MainActivity.this, ArtistsActivity.class);
        startActivity(intent);
    }
}
