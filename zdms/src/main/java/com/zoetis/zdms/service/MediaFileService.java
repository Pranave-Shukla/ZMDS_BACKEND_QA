package com.zoetis.zdms.service;

public interface MediaFileService {

    void uploadMediaFile(String mediaFilePath, String mediaFileName, byte[] mediaFile);

    void deleteMediaFile(String mediaFilePath, String mediaFileName);
}
