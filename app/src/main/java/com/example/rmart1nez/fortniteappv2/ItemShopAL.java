package com.example.rmart1nez.fortniteappv2;

public class ItemShopAL {

    private String imageURL;
    private String name;
    private String rarity;
    private String storeCategory;
    private int vBucks;

    public ItemShopAL(String imageURL, String name, String rarity, String storeCategory, int vBucks){
        this.imageURL = imageURL;
        this.name = name;
        this.rarity = rarity;
        this.storeCategory = storeCategory;
        this.vBucks = vBucks;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public String getStoreCategory() {
        return storeCategory;
    }

    public void setStoreCategory(String storeCategory) {
        this.storeCategory = storeCategory;
    }

    public int getvBucks() {
        return vBucks;
    }

    public void setvBucks(int vBucks) {
        this.vBucks = vBucks;
    }
}