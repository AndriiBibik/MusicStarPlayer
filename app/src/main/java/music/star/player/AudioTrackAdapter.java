package music.star.player;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import music.star.player.custom.AudioTrack;

public class AudioTrackAdapter extends ArrayAdapter<AudioTrack> {

    private Context  context;
    private List<AudioTrack> audioTracks;

    public AudioTrackAdapter(Context context, List<AudioTrack> audioTracks) {
        super(context, 0, audioTracks);
        this.context = context;
        this.audioTracks = audioTracks;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View itemView = convertView;

        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.list_item_song, parent, false);
            ViewHolder holder = new ViewHolder(itemView);
            itemView.setTag(holder);
        }
        ViewHolder holder = (ViewHolder) itemView.getTag();

        // setting album art
        holder.albumArt.setImageResource(audioTracks.get(position).getAlbum().getArtId());
        // setting song title
        holder.songTitle.setText(audioTracks.get(position).getTitleId());
        // setting song artist name
        holder.songArtist.setText(audioTracks.get(position).getArtist().getNameId());

        return itemView;
    }

    class ViewHolder {

        @BindView(R.id.album_art_in_list) ImageView albumArt;
        @BindView(R.id.song_title) TextView songTitle;
        @BindView(R.id.song_artist) TextView songArtist;

        ViewHolder(View itemView) {
            ButterKnife.bind(this, itemView);
        }
    }
}