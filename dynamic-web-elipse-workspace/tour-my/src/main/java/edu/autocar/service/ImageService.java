package edu.autocar.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import edu.autocar.domain.Board.FileInfo;
import edu.autocar.domain.Board.Image;

public interface ImageService {
	List<Image> getGalleryImages(int galleryId) throws Exception;

	Image getImage(int imageId) throws Exception;

	void create(Image image) throws Exception;

	void saveImage(Image image, MultipartFile file) throws Exception;

	boolean delete(int imageId) throws Exception;
	
	public FileInfo getFileInfo(int imageId) throws Exception;
	
	public FileInfo getThumbFileInfo(int imageId) throws Exception;
}
