package com.slamgantdroid.searchviewinlistview;

/**
 * Created by WIN10 on 08/06/2017.
 */

public class Model {

    private String nama;
    private int gambar;

    public Model(String nama, int gambar) {
        this.nama = nama;
        this.gambar = gambar;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getGambar() {
        return gambar;
    }

    public void setGambar(int gambar) {
        this.gambar = gambar;
    }
}
