package com.zoetis.zdms.exception;

import com.zoetis.zdms.exception.common.InternalServerException;

public class UploadMediaFileException extends InternalServerException {

    private UploadMediaFileException(Throwable throwable) {
        super(throwable);
    }

    public static UploadMediaFileException of(Throwable throwable) {
        return new UploadMediaFileException(throwable);
    }

}
