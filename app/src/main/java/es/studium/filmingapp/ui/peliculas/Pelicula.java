package es.studium.filmingapp.ui.peliculas;


import java.io.Serializable;

public class Pelicula implements Serializable {
    private int imagen;
    private String titulo;
    private String director;
    private String reparto;
    private float clasificacion;
    private String sinopsis;

    public Pelicula(int imagen, String titulo, String director,String reparto, float clasificacion, String sinopsis) {
        this.imagen = imagen;
        this.titulo = titulo;
        this.director = director;
        this.reparto = reparto;
        this.clasificacion = clasificacion;
        this.sinopsis = sinopsis;
    }

    public int getImagen() {
        return imagen;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDirector() {
        return director;
    }
    public String getReparto() {
        return reparto;
    }
    public float getClasificacion() {
        return clasificacion;
    }
    public String getSinopsis() {
        return sinopsis;
    }
}

