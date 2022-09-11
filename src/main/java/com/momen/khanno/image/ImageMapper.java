package com.momen.khanno.image;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ImageMapper {

    Image toImage(ImageDTO imageDTO);

    ImageDTO toImageDTO(Image image);

}
