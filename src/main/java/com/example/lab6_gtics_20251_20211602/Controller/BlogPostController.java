package com.example.lab6_gtics_20251_20211602.Controller;

import com.example.lab6_gtics_20251_20211602.Entity.BlogPost;
import com.example.lab6_gtics_20251_20211602.Repository.BlogPostRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Optional;

@Controller
@RequestMapping("/posts")
public class BlogPostController {

    private final BlogPostRepository blogPostRepository;

    public BlogPostController(BlogPostRepository blogPostRepository) {
        this.blogPostRepository = blogPostRepository;
    }

    @GetMapping
    public String listarPosts(Model model) {
        model.addAttribute("posts", blogPostRepository.findAll());
        return "blog/list";
    }

    @GetMapping("/nuevo")
    public String nuevoPostForm(Model model) {
        model.addAttribute("blogPost", new BlogPost());
        return "blog/form";
    }

    @PostMapping("/guardar")
    public String guardarPost(@ModelAttribute("blogPost") @Valid BlogPost post, BindingResult result) {
        if (result.hasErrors()) return "blog/form";
        if (post.getFechaPublicacion() == null) post.setFechaPublicacion(LocalDateTime.now());
        blogPostRepository.save(post);
        return "redirect:/posts";
    }

    @GetMapping("/editar/{id}")
    public String editarPostForm(@PathVariable("id") Long id, Model model) {
        Optional<BlogPost> optional = blogPostRepository.findById(id);
        if (optional.isPresent()) {
            model.addAttribute("blogPost", optional.get());
            return "blog/form";
        } else {
            return "redirect:/posts";
        }
    }

    @GetMapping("/{id}")
    public String verPostCompleto(@PathVariable("id") Long id, Model model) {
        Optional<BlogPost> optional = blogPostRepository.findById(id);
        if (optional.isPresent()) {
            model.addAttribute("post", optional.get());
            return "blog/view";
        } else {
            return "redirect:/posts";
        }
    }

    @PostMapping("/eliminar/{id}")
    public String eliminarPost(@PathVariable("id") Long id) {
        blogPostRepository.deleteById(id);
        return "redirect:/posts";
    }
}
