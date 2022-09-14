package com.zoetis.zdms.util.factory;

import com.zoetis.zdms.model.dictionary.Availability;
import com.zoetis.zdms.model.dictionary.BooleanValue;
import com.zoetis.zdms.model.dictionary.Language;
import com.zoetis.zdms.model.view.ProductView;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ProductFactory {

    public static final String UUID = "uuid";
    public static final Integer PRODUCT_ID = 1;
    public static final Integer STATUS_ID = 1;
    public static final BooleanValue IS_VISIBLE = BooleanValue.TRUE;
    public static final String IS_VISIBLE_LOCALIZED = "is visible localized";
    public static final Language IS_VISIBLE_LANGUAGE = Language.DE;
    public static final Availability AVAILABILITY = Availability.AVAILABLE;
    public static final String AVAILABILITY_LOCALIZED = "availability localized";
    public static final Language AVAILABILITY_LANGUAGE = Language.DE;
    public static final String DESCRIPTION = "description";
    public static final Integer MINIMUM_ORDER_QUANTITY = 1;
    public static final Integer MAXIMUM_ORDER_QUANTITY = 10;
    public static final BooleanValue HAS_MEDIA = BooleanValue.FALSE;
    public static final String HAS_MEDIA_LOCALIZED = "has media localized";
    public static final Language HAS_MEDIA_LANGUAGE = Language.DE;
    public static final String SOURCE = "source";

    public ProductView buildDefaultProductView() {
        return ProductView.of(
                UUID, PRODUCT_ID, STATUS_ID, IS_VISIBLE, IS_VISIBLE_LOCALIZED, IS_VISIBLE_LANGUAGE.getValue(), AVAILABILITY, AVAILABILITY_LOCALIZED, AVAILABILITY_LANGUAGE.getValue(),
                DESCRIPTION, MINIMUM_ORDER_QUANTITY, MAXIMUM_ORDER_QUANTITY, HAS_MEDIA, HAS_MEDIA_LOCALIZED, HAS_MEDIA_LANGUAGE.getValue(), SOURCE
        );
    }
}
