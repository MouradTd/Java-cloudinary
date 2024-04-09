package com.example.Crud_App.Utils;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import com.cloudinary.*;

import java.util.Map;
import java.util.UUID;


@RequiredArgsConstructor
@Component
public class Utils  {
    private final Cloudinary cloudinary;

    public  String uploadFile(MultipartFile file) throws IOException {
        return cloudinary.uploader().upload(file.getBytes(), Map.of("public_id", UUID.randomUUID().toString())).get("url").toString();
    }
}
