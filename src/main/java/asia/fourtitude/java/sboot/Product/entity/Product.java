package asia.fourtitude.java.sboot.Product.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCT")
public class Product extends EntityAudit{

	@Id
	@Column(name = "ID", updatable = false, unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
	@Column(name = "CODE", unique=true, nullable = false, columnDefinition = "VARCHAR(9)")
    private String code;
	
	@Column(name = "NAME", nullable = false, columnDefinition = "VARCHAR(90)")
    private String name;
	
	@Column(name = "CATEGORY", nullable = false, columnDefinition = "VARCHAR(28)")
    private String category;
	
	@Column(name = "BRAND", nullable = true, columnDefinition = "VARCHAR(28)")
    private String brand;
	
	@Column(name = "TYPE", nullable = true, columnDefinition = "VARCHAR(21)")
    private String type;
	
	@Column(name = "DESCRIPTION", nullable = true, columnDefinition = "VARCHAR(180)")
    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static Product build(
            Integer id,
            String code,
            String name,
            String category,
            String brand,
            String type,
            String description) {
        Product item = new Product();
        item.id = id;
        item.code = code;
        item.name = name;
        item.category = category;
        item.brand = brand;
        item.type = type;
        item.description = description;
        return item;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int idx = -1;
        if (id != null) {
            sb.append(++idx > 0 ? ", " : "").append("id=").append(id);
        }
        if (code != null) {
            sb.append(++idx > 0 ? ", " : "").append("code=").append(code);
        }
        if (name != null) {
            sb.append(++idx > 0 ? ", " : "").append("name=").append(name);
        }
        if (category != null) {
            sb.append(++idx > 0 ? ", " : "").append("category=").append(category);
        }
        if (brand != null) {
            sb.append(++idx > 0 ? ", " : "").append("brand=").append(brand);
        }
        if (type != null) {
            sb.append(++idx > 0 ? ", " : "").append("type=").append(type);
        }
        if (description != null) {
            sb.append(++idx > 0 ? ", " : "").append("description=").append(description);
        }
        return sb.toString();
    }

}
