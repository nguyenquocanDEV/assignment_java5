package com.poly.assignment.services;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;

public interface StorageService {
    String getStoredFilename(MultipartFile file, String id);

    //lưu file
    void store(MultipartFile file, String storeFilename);

    //nạp nội dung file dưới dạng resource
    Resource loadAsResource(String filename);

    Path load(String filename);

    //xoá file
    void delete(String storeFilename) throws IOException;

    void init();
}
