package com.zoetis.zdms.service;

import com.zoetis.zdms.model.Product;
import com.zoetis.zdms.model.ProductMediaFile;
import com.zoetis.zdms.model.ProductPartial;
import com.zoetis.zdms.model.ProductStatus;
import com.zoetis.zdms.model.dictionary.Language;
import com.zoetis.zdms.model.dictionary.pageparameter.search.SearchBy;
import com.zoetis.zdms.model.dictionary.pageparameter.search.SearchByField;
import com.zoetis.zdms.model.dictionary.pageparameter.sort.SortBy;
import com.zoetis.zdms.model.dictionary.pageparameter.sort.SortDirection;
import com.zoetis.zdms.model.view.ProductView;
import org.springframework.data.domain.Page;

import java.util.Optional;
import java.util.Set;

public interface ProductService {

    Page<ProductView> getProductViews(Integer pageNumber, Language language, Integer pageSize,
                                      SortDirection sortDirection, SortBy.Product sortBy, Set<SearchBy<SearchByField.Product>> searchBy);

    Product getProduct(String id);

    Product updateProduct(String id, String statusId, Boolean applyForAllSystems, ProductPartial productPartial);

    ProductStatus getProductStatusForStatusId(Product product, String statusId);

    Optional<ProductMediaFile> getProductMediaFileForProductStatus(ProductStatus productStatus);

    String getProductApiMediaFilepath(ProductMediaFile productMediaFile, ProductStatus productStatus);
}
