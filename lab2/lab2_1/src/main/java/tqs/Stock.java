package tqs;

public class Stock {

    private String label;
    private Integer quantity;

    public Stock(String label, Integer quantity) {
        this.label = label;
        this.quantity = quantity;
    }

    public String getLabel() {
        return label;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        Stock stock = (Stock) obj;

        if (!stock.getLabel().equals(this.getLabel())) {
            return false;
        }

        if (!stock.getQuantity().equals(this.getQuantity())) {
            return false;
        }

        return true;
    }

}
