package com.sagar.threadscale.service.impl;

import com.sagar.threadscale.domain.FileData;
import com.sagar.threadscale.service.FileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class FileServiceImpl implements FileService {

    @Value("${cod.demo.file}")
    String fileName;

    @Override
    public String readFile() {
        log.info("Reading the file using Async thread");
        List<String> list = new ArrayList<>();
        try (BufferedReader br = Files.newBufferedReader(Paths.get(fileName))) {
            list = br.lines().toList();
        } catch (IOException e) {
            log.error("Error is readFile : {}", String.valueOf(e));
        }
        StringBuilder sb = new StringBuilder();
        for(String s : list) {
            sb.append(s);
        }
        return sb.toString();
    }

    @Override
    public boolean writeFile(FileData fileData) {
        log.info("Writing to file using Async thread");
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(fileName));
            writer.write(fileData.getData());
            writer.close();
        } catch(IOException e) {
            log.error("Error in writeFile is : {}", String.valueOf(e));
            return false;
        }
        return true;
    }
}
