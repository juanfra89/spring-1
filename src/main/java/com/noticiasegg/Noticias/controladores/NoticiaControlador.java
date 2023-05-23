package com.noticiasegg.Noticias.controladores;

import com.noticiasegg.Noticias.servicios.NoticiaServicio;
import com.noticiasegg.Noticias.entidades.Noticia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/noticias")
public class NoticiaControlador {

    private final NoticiaServicio noticiaServicio;

    @Autowired
    public NoticiaControlador(NoticiaServicio noticiaServicio) {
        this.noticiaServicio = noticiaServicio;
    }

    @GetMapping("/listar")
    public String listarNoticias(Model model) {
        model.addAttribute("noticias", noticiaServicio.obtenerTodasLasNoticias());
        return "listar-noticias";
    }

    @GetMapping("/crear")
    public String mostrarFormularioCreacion(Model model) {
        model.addAttribute("noticia", new Noticia());
        return "formulario-crear";
    }

    @PostMapping("/crear")
    public String crearNoticia(@ModelAttribute("noticia") Noticia noticia) {
        noticiaServicio.guardarNoticia(noticia);
        return "redirect:/noticias/listar";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEdicion(@PathVariable("id") Long id, Model model) {
        Noticia noticia = noticiaServicio.obtenerNoticiaPorId(id);
        model.addAttribute("noticia", noticia);
        return "formulario-editar";
    }

    @PostMapping("/editar/{id}")
    public String editarNoticia(@PathVariable("id") Long id, @ModelAttribute("noticia") Noticia noticia) {
        noticia.setId(id);
        noticiaServicio.guardarNoticia(noticia);
        return "redirect:/noticias/listar";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarNoticia(@PathVariable("id") Long id) {
        noticiaServicio.eliminarNoticia(id);
        return "redirect:/noticias/listar";
    }
}
