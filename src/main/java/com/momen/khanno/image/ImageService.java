package com.momen.khanno.image;

public interface ImageService {
    Image save(Image image);

    void delete(Long id);

    Image getById(Long id);
}
