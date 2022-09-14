package com.zoetis.zdms.mapper;

import com.zoetis.zdms.api.dto.RejectionReasonDto;
import com.zoetis.zdms.model.dictionary.RejectionReason;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RejectionReasonMapper {

    RejectionReasonDto map(RejectionReason rejectionReason);

    RejectionReason map(RejectionReasonDto rejectionReason);
}
