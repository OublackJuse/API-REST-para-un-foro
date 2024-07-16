package com.example.foro.service;

import com.example.foro.model.Post;
import com.example.foro.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> listarPosts() {
        return postRepository.findAll();
    }

    public Post obtenerPostPorId(Long id) {
        return postRepository.findById(id).orElse(null);
    }

    public Post crearPost(Post post) {
        return postRepository.save(post);
    }

    public Post actualizarPost(Long id, Post post) {
        Post postExistente = obtenerPostPorId(id);
        if (postExistente != null) {
            post.setId(id);
            return postRepository.save(post);
        }
        return null;
    }

    public void eliminarPost(Long id) {
        postRepository.deleteById(id);
    }
}
