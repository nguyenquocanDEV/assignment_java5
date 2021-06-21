package com.poly.assignment.services.impl;

import com.poly.assignment.config.StorageProperties;

import com.poly.assignment.services.StorageService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileSystemStorageServiceImpl implements StorageService {
    // đường dẫn gốc lưu thông tin file hình
    private final Path rootLocation;

    @Override
    public String getStoredFilename(MultipartFile file, String id) {

        //phần mở rộng của file( jpg, png,...)
        String ext = FilenameUtils.getExtension(file.getOriginalFilename());
        return "p" + id + "." + ext;
    }

    //contructor truyền thông tin cấu hình
    public FileSystemStorageServiceImpl(StorageProperties properties) {
        this.rootLocation = Paths.get(properties.getLocation());
    }

    //lưu file
    @Override
    public void store(MultipartFile file, String storeFilename) {
        try {
            if (file.isEmpty()) {
                throw new RuntimeException("Failed to store empty file");
            }
            Path destinationFile = this.rootLocation.resolve(Paths.get(storeFilename)).normalize().toAbsolutePath();
            if (!destinationFile.getParent().equals(this.rootLocation.toAbsolutePath())) {
                throw new RuntimeException("Cannot store file outside current directory");
            }
            try (InputStream inputStream = file.getInputStream()) {
                Files.copy(inputStream, destinationFile, StandardCopyOption.REPLACE_EXISTING);

            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to store file", e);
        }

    }

    //nạp nội dung file dưới dạng resource
    @Override
    public Resource loadAsResource(String filename) {
        try {
            Path file = load(filename);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            }
            throw new RuntimeException("Could not read file" + filename);
        } catch (Exception e) {
            throw new RuntimeException("Could not read file" + filename);
        }
    }
    @Override
    public Path load(String filename) {
        return rootLocation.resolve(filename);
    }

    //xoá file
    @Override
    public void delete(String storeFilename) throws IOException {
        Path destinationFile = rootLocation.resolve(Paths.get(storeFilename)).normalize().toAbsolutePath();
        Files.delete(destinationFile);
    }


    @Override
    public void init(){
        try {
            Files.createDirectories(rootLocation);
            System.out.println(rootLocation.toString());
        }catch (Exception e) {
            throw new RuntimeException("Could not initialize storage", e);
        }
    }
}
