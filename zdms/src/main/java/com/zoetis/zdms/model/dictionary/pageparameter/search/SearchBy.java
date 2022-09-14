package com.zoetis.zdms.model.dictionary.pageparameter.search;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class SearchBy<SEARCH_BY_FIELD> {

    private SEARCH_BY_FIELD searchByField;
    private SearchByOperation searchByOperation;
    private List<String> values;

}
