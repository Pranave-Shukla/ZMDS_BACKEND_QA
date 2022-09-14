package com.zoetis.zdms.service.impl;

import com.zoetis.zdms.exception.UploadMediaFileException;
import com.zoetis.zdms.service.MediaFileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
@RequiredArgsConstructor
@Slf4j
public class MediaFileServiceImpl implements MediaFileService {

    @Value("${media.file.storage.base-path}")
    private String mediaFileStorageBasePath;

    @Override
    public void uploadMediaFile(String mediaFilePath, String mediaFileName, byte[] mediaFile) {
        log.info("[uploadMediaFile] started processing with parameters [mediaFilePath = {}, mediaFileName = {}]}", mediaFilePath, mediaFileName);
        try {
            File media = createMediaFile(mediaFilePath, mediaFileName);

            FileUtils.writeByteArrayToFile(media, mediaFile);
        } catch (IOException e) {
            throw UploadMediaFileException.of(e);
        }
    }

    @Override
    public void deleteMediaFile(String mediaFilePath, String mediaFileName) {
        log.info("[deleteMediaFile] started processing with parameters [mediaFilePath = {}, mediaFileName = {}]}", mediaFilePath, mediaFileName);
        File mediaFile = createMediaFile(mediaFilePath, mediaFileName);
        FileUtils.deleteQuietly(mediaFile);
    }

    private File createMediaFile(String mediaFilePath, String mediaFileName) {
        return new File(getMediaFilePathFrom(mediaFilePath, mediaFileName));
    }

    private String getMediaFilePathFrom(String mediaFilePath, String mediaFileName) {
        return mediaFileStorageBasePath + File.separator + mediaFilePath + File.separator + mediaFileName;
    }
}
