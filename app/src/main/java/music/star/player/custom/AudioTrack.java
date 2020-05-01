package music.star.player.custom;

public class AudioTrack {

    private int titleId;
    private Artist artist;
    private Album album;

    public AudioTrack(int titleId, Artist artist, Album album) {
        this.titleId = titleId;
        this.artist = artist;
        this.album = album;
    }

    public int getTitleId() { return titleId; }
    public Artist getArtist() { return artist; }
    public Album getAlbum() { return album; }
}
