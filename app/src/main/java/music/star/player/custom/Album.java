package music.star.player.custom;

public class Album {

    private int artId;

    private int titleId;

    private int artistId;

    public Album(int artId, int titleId, int artistId) {
        this.artId = artId;
        this.titleId = titleId;
        this.artistId = artistId;
    }

    public int getArtId() { return artId; }

    public int getTitleId() { return titleId; }

    public int getArtistId() { return artistId; }
}
