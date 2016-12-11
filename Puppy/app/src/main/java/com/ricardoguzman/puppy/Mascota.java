package com.ricardoguzman.puppy;

/**
 * Created by ricgu on 10/12/2016.
 */

public class Mascota {
    private String nombre;
    private int likes;
    private boolean like;
    private int foto;

    public Mascota(String nombre, int likes, boolean like, int foto) {
        this.nombre = nombre;
        this.likes = likes;
        this.like = like;
        this.foto = foto;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public void setLike(boolean like) {
        this.like = like;
    }

    public boolean isLike() {
        return like;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}
