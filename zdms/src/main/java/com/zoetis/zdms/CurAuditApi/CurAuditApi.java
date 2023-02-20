package com.zoetis.zdms.CurAuditApi;
import com.zoetis.zdms.api.dto.AuditsRequestDto;
import com.zoetis.zdms.api.dto.AuditsResponseDto;
import com.zoetis.zdms.api.dto.ErrorDto;
import com.zoetis.zdms.api.rest.ApiUtil;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Validated
@Api(value = "Audits")

public interface CurAuditApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /api/v1/auditsCur : Audit list
     *
     * @param auditsRequestDto Get audits request parameters (required)
     * @return Audits list (status code 200)
     *         or Bad request (status code 400)
     *         or Unauthorized (status code 401)
     *         or Forbidden (status code 403)
     *         or Not Found (status code 404)
     *         or Internal Server Error (status code 500)
     */

    @ApiOperation(value = "Audit list", nickname = "getAudits", notes = "", response = AuditsResponseDto.class, tags={ "audit", })
    @ApiResponses(value = {

            @ApiResponse(code = 200, message = "Audits list", response = AuditsResponseDto.class),

            @ApiResponse(code = 400, message = "Bad request", response = ErrorDto.class),

            @ApiResponse(code = 401, message = "Unauthorized", response = ErrorDto.class),

            @ApiResponse(code = 403, message = "Forbidden", response = ErrorDto.class),

            @ApiResponse(code = 404, message = "Not Found", response = ErrorDto.class),

            @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorDto.class) })
    @RequestMapping(
            method = RequestMethod.POST,
            value = "/api/v1/auditsCur",
            produces = { "application/json" },
            consumes = { "application/json" }
    )
    default ResponseEntity<AuditsResponseDto> getCurAudits(

            @ApiParam(value = "Get audits request parameters", required = true )   @Valid @RequestBody AuditsRequestDto auditsRequestDto) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"pageInfo\" : { \"pageNumber\" : 0, \"totalPages\" : 1, \"totalElements\" : 6 }, \"audits\" : [ { \"date\" : \"2000-01-23T04:56:07.000+00:00\", \"initiator\" : \"initiator\", \"header\" : \"header\", \"message\" : \"message\" }, { \"date\" : \"2000-01-23T04:56:07.000+00:00\", \"initiator\" : \"initiator\", \"header\" : \"header\", \"message\" : \"message\" } ] }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
