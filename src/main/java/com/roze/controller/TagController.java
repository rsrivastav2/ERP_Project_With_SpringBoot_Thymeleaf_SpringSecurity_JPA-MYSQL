package com.roze.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.roze.domain.Tag;
import com.roze.repository.TagRepository;

@Controller
@RequestMapping("/tags")
public class TagController {

    @Autowired
    private TagRepository tagRepository;

    @GetMapping("")
    public String getTagList(Model model){
        model.addAttribute("tags", tagRepository.findAll());
        return "tags/tagList";
    }

    @GetMapping("/new")
    public String getNewTag(Model model){
        model.addAttribute("tag", new Tag());
        return "tags/newTag";
    }

    @PostMapping("/new")
    public String postNewTag(@ModelAttribute Tag tag){
        tagRepository.save(tag);
        return "redirect:/tags";
    }

    @GetMapping("/{id}")
    public String getShowTag(@PathVariable Long id, Model model){
        model.addAttribute("tag",tagRepository.findById(id).get());
        return "tags/showTag";
    }

    @GetMapping("/{id}/update")
    public String getUpdateTag(@PathVariable Long id, Model model){
        model.addAttribute("tag", tagRepository.findById(id).get());
        return "tags/updateTag";
    }

    @PostMapping("/{id}/update")
    public String postUpdateTag(@ModelAttribute Tag tag){
        tagRepository.save(tag);
        return "redirect:/tags";
    }
}
