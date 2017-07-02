package com.hellojd.jpetstore.domain.service.catalog;

import com.hellojd.jpetstore.domain.model.Category;
import com.hellojd.jpetstore.domain.model.Item;
import com.hellojd.jpetstore.domain.model.Product;

import java.util.List;

public interface CatalogService {

    List<Category> getCategoryList();

    Category getCategory(String categoryId);

    Product getProduct(String productId);

    List<Product> getProductListByCategory(String categoryId);

    // TODO enable using more than one keyword
    List<Product> searchProductList(String keyword);

    List<Item> getItemListByProduct(String productId);

    Item getItem(String itemId);

    boolean isItemInStock(String itemId);

}
