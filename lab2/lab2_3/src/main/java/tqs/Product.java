package tqs;

public class Product {

    private Integer id;
    private String image;
    private String description;
    private Double price;
    private String title;
    private String category;

    public Product() {

    }

    public Product(Integer id, String image, String description, Double price, String title, String category) {
        this.id = id;
        this.image = image;
        this.description = description;
        this.price = price;
        this.title = title;
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public String getImage() {
        return image;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        Product product = (Product) obj;

        if (!product.getId().equals(this.getId())) {
            return false;
        }

        if (!product.getTitle().equals(this.getTitle())) {
            return false;
        }

        if (!product.getPrice().equals(this.getPrice())) {
            return false;
        }

        if (!product.getDescription().equals(this.getDescription())) {
            return false;
        }

        if (!product.getCategory().equals(this.getCategory())) {
            return false;
        }

        if (!product.getImage().equals(this.getImage())) {
            return false;
        }

        return true;
    }

}
