package music.star.player.custom;

public class Artist {

    private int imageId;

    private int nameId;

    public Artist(int imageId, int nameId) {
        this.imageId = imageId;
        this.nameId = nameId;
    }

    public int getImageId() { return imageId; }

    public int getNameId() { return nameId; }
}
