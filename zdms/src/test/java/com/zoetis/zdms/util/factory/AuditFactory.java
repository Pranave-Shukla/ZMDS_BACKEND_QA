package com.zoetis.zdms.util.factory;

import com.zoetis.zdms.model.Audit;
import com.zoetis.zdms.model.dictionary.DataSet;
import lombok.experimental.UtilityClass;

import java.time.OffsetDateTime;

@UtilityClass
public class AuditFactory {

    public static final String ID = "1";
    public static final DataSet DATA_SET = DataSet.PRODUCT;
    public static final String TRANSACTION_HEADER = "transaction header";
    public static final String TRANSACTION_MESSAGE = "transaction message";
    public static final String LOG_BY = "log by";
    public static final OffsetDateTime LOG_TIME = OffsetDateTime.now();

    public Audit buildDefaultAudit() {
        return Audit.of(ID, DATA_SET, TRANSACTION_HEADER, TRANSACTION_MESSAGE, LOG_BY, LOG_TIME);
    }
}
