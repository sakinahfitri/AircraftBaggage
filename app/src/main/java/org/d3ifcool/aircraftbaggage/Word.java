package org.d3ifcool.aircraftbaggage;

public class Word {
    private String judul;
    private String keterangan;
    private int imageResId;

    public Word(String judul, String keterangan) {
        this.judul = judul;
        this.keterangan = keterangan;
    }

    public Word(String judul, String keterangan, int imageResId) {
        this.judul = judul;
        this.keterangan = keterangan;
        this.imageResId = imageResId;
    }

    public String getJudul() {
        return judul;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public int getImageResId() {
        return imageResId;
    }
}
