package com.sipl.hibernate.example.serviceImpl;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.sipl.hibernate.example.dtos.ImageDto;
import com.sipl.hibernate.example.entities.Images;
import com.sipl.hibernate.example.mapper.ImageMapper;
import com.sipl.hibernate.example.repository.ImageRepository;
import com.sipl.hibernate.example.response.ImageApiResponse;
import com.sipl.hibernate.example.service.ImageService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ImageServiceImpl implements ImageService {

	@Autowired
	private ImageMapper imageMapper;

	@Autowired
	private ImageRepository imageRepository;

	@Value("${image.location}")
	private String imageFolderName;

	@Value("${image.name}")
	private String imageName;

	private String storeFileInLocalSystemAndReturnFileLocation(ImageDto imageDtos) throws IOException {
		log.info("<<start>>storeFileInLocalSystemAndReturnFileLocation<<start>>");
		final File imageDirectory = new File(imageFolderName);
		imageDirectory.mkdirs();
		File imageFile = new File(imageDirectory + "\\" + imageName + ".jpg");
		log.info("Container Images Path Is" + imageDirectory);
		BufferedImage image = ImageIO
				.read(new ByteArrayInputStream(Base64.getDecoder().decode(imageDtos.getImageAsByteArrayString())));
		ImageIO.write(image, "JPG", new File(imageFile.getAbsolutePath()));
		final String imageFilePath = imageFile.getAbsolutePath();
	return imageFilePath;
}

	private String convertImagePathToByteArraySendAsString(String imageLocation) throws IOException {
		log.info("<<start>>convertImagePathToByteArraySendAsString<<start>>");
		log.info("Image Path is " + imageLocation);
			Path p = Paths.get(imageLocation);
			BufferedImage bImage = ImageIO.read(new File(imageLocation));
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			ImageIO.write(bImage, "jpg", bos);
			byte[] data = bos.toByteArray();
			String encoded = Base64.getEncoder().encodeToString(data);
			log.info("<<end>>convertImagePathToByteArraySendAsString<<end>>");
			return encoded;
		}
		
	

	@Override
	public ImageApiResponse add(ImageDto imageDto) throws IOException {
		try {
			log.info("<<start>>add<<start>>");
			try {
		
				imageDto.setImageAsByteArrayString(storeFileInLocalSystemAndReturnFileLocation(imageDto));
			} catch (IOException e) {
				log.error("Error In converting Image", e);
				e.printStackTrace();
			}
			Images images = imageMapper.mapImageDtoToImages(imageDto);
			Images imagesSavedTodb = imageRepository.save(images);
			ImageDto dto=imageMapper.mapImagesToImageDto(imagesSavedTodb);
			dto.setImageAsByteArrayString(convertImagePathToByteArraySendAsString(imagesSavedTodb.getImageAsByteArrayString()));
			log.info("Images Saved to Db :" + imagesSavedTodb);
			log.info("<<end>>add<<end>>");
			return new ImageApiResponse(imageMapper.mapImagesToImageDto(imagesSavedTodb),null, HttpStatus.CREATED,
					"Images added successfully", false);
		} catch (final org.hibernate.exception.JDBCConnectionException e) {
			log.error("Database connectivity error,Name: "  ,e);
		}
		return new ImageApiResponse(null, null, HttpStatus.INTERNAL_SERVER_ERROR, "Server Error", true);

	}
}
