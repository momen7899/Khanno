package com.momen.khanno.image;

import com.momen.khanno.common.exception.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ImageServiceImpl implements ImageService {

    private final ImageRepository repository;

    @Override
    public Image save(Image image) {
        return repository.save(image);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Image getById(Long id) {
        Optional<Image> optionalFileAttachment = repository.findById(id);
        if (optionalFileAttachment.isEmpty()) {
            throw new NotFoundException("Not Found");
        }
        return optionalFileAttachment.get();
    }

}
