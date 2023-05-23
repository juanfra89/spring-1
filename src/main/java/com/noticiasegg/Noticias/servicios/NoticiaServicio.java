package com.noticiasegg.Noticias.servicios;

import com.noticiasegg.Noticias.entidades.Noticia;
import com.noticiasegg.Noticias.repositores.NoticiaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticiaServicio {

    private final NoticiaRepositorio noticiaRepositorio;

    @Autowired
    public NoticiaServicio(NoticiaRepositorio noticiaRepositorio) {
        this.noticiaRepositorio = noticiaRepositorio;
    }
    // Retorna todas las noticias almacenadas en la base de datos.
    public List<Noticia> obtenerTodasLasNoticias() {
        return noticiaRepositorio.findAll();
    }
    //Retorna la noticia correspondiente al ID especificado.
    public Noticia obtenerNoticiaPorId(Long id) {
        return noticiaRepositorio.findById(id).orElse(null);
    }
    // Guarda una nueva noticia en la base de datos o actualiza una noticia existente.
    public Noticia guardarNoticia(Noticia noticia) {
        return noticiaRepositorio.save(noticia);
    }
    //Actualiza una noticia existente en la base de datos.
    public Noticia actualizarNoticia(Noticia noticia) {
        return noticiaRepositorio.save(noticia);
    }
   // Elimina la noticia correspondiente al ID especificado de la base de datos.
    public void eliminarNoticia(Long id) {
        noticiaRepositorio.deleteById(id);
    }
}