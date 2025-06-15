package com.airquality.monitor.model;

public class Tip {
    private String title;
    private String description;
    private String category;
    private String icon;
    
    public Tip() {}
    
    public Tip(String title, String description, String category, String icon) {
        this.title = title;
        this.description = description;
        this.category = category;
        this.icon = icon;
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
    
    public String getIcon() {
        return icon;
    }
    
    public void setIcon(String icon) {
        this.icon = icon;
    }
}

