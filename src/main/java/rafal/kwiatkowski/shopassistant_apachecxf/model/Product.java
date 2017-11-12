package rafal.kwiatkowski.shopassistant_apachecxf.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

@XmlRootElement
@Entity
public class Product {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private BigDecimal unitPrice;
    private BigDecimal quantity;

    public Product() {
    }

    public Product(String name, BigDecimal unitPrice, BigDecimal quantity) {
        this.name = name;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }
}
