package com.zoetis.zdms.model;

import com.zoetis.zdms.model.dictionary.Availability;
import com.zoetis.zdms.model.dictionary.BooleanValue;
import lombok.Data;

@Data
public class ProductPartial {

    private NullableValue<BooleanValue> isVisible;
    private NullableValue<Availability> availability;
    private NullableValue<Integer> minimumOrderQuantity;
    private NullableValue<Integer> maximumOrderQuantity;
    private NullableValue<String> associatedProducts;
    private NullableValue<String> imageBase64;
    private NullableValue<String> imageFilename;
}
