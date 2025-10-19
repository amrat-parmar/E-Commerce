package com.api.crud.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Products {
    @Id
    /*@GeneratedValue(strategy = GenerationType.IDENTITY)*/
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "category")
    private String category;

    @Column(name = "price")
    private String price;

    @Column(name = "discountPercentage")
    private String discountPercentage;

    @Column(name = "rating")
    private String rating;

    @Column(name = "stock")
    private String stock;

    @Column(name = "brand")
    private String brand;

    @Column(name = "sku")
    private String sku;

    @Column(name = "weight")
    private String weight;

    @Column(name = "warrantyInformation")
    private String warrantyInformation;

    @Column(name = "shippingInformation")
    private String shippingInformation;

    @Column(name = "availabilityStatus")
    private String availabilityStatus;

    @Column(name = "returnPolicy")
    private String returnPolicy;

    @Column(name = "minimumOrderQuantity")
    private String minimumOrderQuantity;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "meta_id", referencedColumnName = "id")
    private Meta meta;

    /*@ElementCollection
    private List<String> images;*/

    @Column(name = "thumbnail")
    private String thumbnail;

   /* @ElementCollection
    private List<String> tags;*/

    @OneToMany(mappedBy = "products", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Reviews> reviews;

    @Version
    @Column(nullable = false)
    private int version;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(String discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getWarrantyInformation() {
        return warrantyInformation;
    }

    public void setWarrantyInformation(String warrantyInformation) {
        this.warrantyInformation = warrantyInformation;
    }

    public String getShippingInformation() {
        return shippingInformation;
    }

    public void setShippingInformation(String shippingInformation) {
        this.shippingInformation = shippingInformation;
    }

    public String getAvailabilityStatus() {
        return availabilityStatus;
    }

    public void setAvailabilityStatus(String availabilityStatus) {
        this.availabilityStatus = availabilityStatus;
    }

    public String getReturnPolicy() {
        return returnPolicy;
    }

    public void setReturnPolicy(String returnPolicy) {
        this.returnPolicy = returnPolicy;
    }

    public String getMinimumOrderQuantity() {
        return minimumOrderQuantity;
    }

    public void setMinimumOrderQuantity(String minimumOrderQuantity) {
        this.minimumOrderQuantity = minimumOrderQuantity;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

  /*  public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }
*/
    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

  /*  public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }*/

    public List<Reviews> getReviews() {
        return reviews;
    }

    public void setReviews(List<Reviews> reviews) {
        this.reviews = reviews;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "Products{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", price='" + price + '\'' +
                ", discountPercentage='" + discountPercentage + '\'' +
                ", rating='" + rating + '\'' +
                ", stock='" + stock + '\'' +
                ", brand='" + brand + '\'' +
                ", sku='" + sku + '\'' +
                ", weight='" + weight + '\'' +
                ", warrantyInformation='" + warrantyInformation + '\'' +
                ", shippingInformation='" + shippingInformation + '\'' +
                ", availabilityStatus='" + availabilityStatus + '\'' +
                ", returnPolicy='" + returnPolicy + '\'' +
                ", minimumOrderQuantity='" + minimumOrderQuantity + '\'' +
                ", meta=" + meta +
                /*", images=" + images +*/
                ", thumbnail='" + thumbnail + '\'' +
               /* ", tags=" + tags +*/
                ", reviews=" + reviews +
                ", version=" + version +
                '}';
    }
}

