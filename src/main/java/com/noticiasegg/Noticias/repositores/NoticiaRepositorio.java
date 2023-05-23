package com.noticiasegg.Noticias.repositores;
import com.noticiasegg.Noticias.entidades.Noticia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Date;
import java.util.List;
@Repository
public interface NoticiaRepositorio extends JpaRepository<Noticia, Long> {
    //Permite buscar noticias que contengan un cierto texto en el título.
    List<Noticia> findByTituloContaining(String titulo);
    //Permite buscar noticias publicadas después de una determinada fecha.
    List<Noticia> findByFechaPublicacionAfter(Date fecha);
    //Permite buscar noticias por autor.

}
