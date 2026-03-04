package com.sagar.threadscale.service;

import com.sagar.threadscale.domain.FileData;

public interface FileService {
    String readFile();

    boolean writeFile(FileData fileData);
}
