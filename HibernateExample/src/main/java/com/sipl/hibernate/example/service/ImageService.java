package com.sipl.hibernate.example.service;

import java.io.IOException;
import org.springframework.stereotype.Service;
import com.sipl.hibernate.example.dtos.ImageDto;
import com.sipl.hibernate.example.response.ImageApiResponse;

@Service
public interface ImageService {

	public ImageApiResponse add(ImageDto imageDto) throws IOException;
}
