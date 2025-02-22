package tqs;

import com.google.gson.Gson;
import java.util.Optional;

public class ProductFinderService {

    private final ISimpleHttpClient httpClient;
    public final String API_PRODUCTS = "https://fakestoreapi.com/products/";

    public ProductFinderService(ISimpleHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public Optional<Product> findProductDetails(int id) {
        String data = httpClient.doHttpGet(API_PRODUCTS + id);
        if (data.equals("Error found in id.")) {
            return Optional.empty();
        }
        Product product = new Gson().fromJson(data, Product.class);
        return Optional.ofNullable(product);
    }

}
