package com.bezkoder.springjwt.entities;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

public class class4getpicture {
    public String getbase64fromfolder(String productname) throws IOException {
        String imagePath = "D:\\INTERN_TMA\\sourecode_Java\\img4Project\\"+productname+".png";
        byte[] imageBytes = Files.readAllBytes(Paths.get(imagePath));
        String base64Image = Base64.getEncoder().encodeToString(imageBytes);
        return base64Image;
    }
}
