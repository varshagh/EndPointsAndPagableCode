package com.sipl.hibernate.example.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import com.sipl.hibernate.example.dtos.ImageDto;
import com.sipl.hibernate.example.entities.Images;


@Mapper(componentModel = "spring")
public interface ImageMapper {
	
	ImageDto mapImagesToImageDto(Images images);
	
	Images mapImageDtoToImages(ImageDto imageDto);
	
	List<ImageDto> imagesListToImageDtoList(List<Images> imagesList);
}
