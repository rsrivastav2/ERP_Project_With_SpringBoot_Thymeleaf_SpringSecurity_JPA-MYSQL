package com.roze.controller;


import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.roze.domain.Tag;
import com.roze.repository.TagRepository;




@RestController
@RequestMapping("/api/tags")
public class TagApiController {
	private Logger log=LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TagRepository tagRepository;

    @GetMapping("")
    public ResponseEntity<Iterable<Tag>> getTagList(){
        return ResponseEntity.ok(tagRepository.findAll());
    }

    @PostMapping("")
    public ResponseEntity<Tag> createNewTag(@Validated @RequestBody Tag tag){
        tagRepository.save(tag);
        return ResponseEntity.ok(tag);
    }

    @PutMapping("")
    public ResponseEntity<Tag> updateTag(@Validated @RequestBody Tag tag){
        tagRepository.save(tag);
        return ResponseEntity.ok(tag);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tag> showTag(@PathVariable Long id){

        Optional<Tag> tagOptional = tagRepository.findById(id);

        if(!tagOptional.isPresent()){
            log.warn("Tag with id: {} is not present");
            return ResponseEntity.noContent().build();
        }
        else
        {
            return ResponseEntity.ok(tagOptional.get());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTag(@PathVariable Long id){
        tagRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

}
