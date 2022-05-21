package com.sipl.hibernate.example.response;

import java.util.List;
import org.springframework.http.HttpStatus;
import com.sipl.hibernate.example.dtos.ImageDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImageApiResponse {
	private ImageDto imageDto;
	private List<ImageDto> imageDtos;
	private HttpStatus status;
	private String message;
    private boolean error;
}
