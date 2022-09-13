package com.momen.khanno.image;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/image_attachment/v1")
@AllArgsConstructor
public class ImageController {
    private final ImageService service;
    private ImageMapper mapper;

    @PostMapping
    public ResponseEntity<Void> saveImage(@RequestBody ImageDTO imageDTO) {
        Image image = mapper.toImage(imageDTO);
        service.save(image);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ImageDTO> getById(@PathVariable Long id) {
        Image image = service.getById(id);
        ImageDTO imageDTO = mapper.toImageDTO(image);
        return ResponseEntity.ok(imageDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

}
