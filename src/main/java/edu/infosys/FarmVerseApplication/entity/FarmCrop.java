package edu.infosys.FarmVerseApplication.entity;

public class FarmCrop {
    private Long farmId;

    public Long getFarmId() {
        return farmId;
    }

    private String farmName;

    public String getFarmName() {
        return farmName;
    }

    public Double getArea() {
        return area;
    }

    private Double area;

    public Double getYield() {
        return yield;
    }

    public String getComments() {
        return comments;
    }

    public String getSoil() {
        return soil;
    }

    public String getHarvestMonthYear() {
        return harvestMonthYear;
    }

    public String getSownMonthYear() {
        return sownMonthYear;
    }

    public String getCropName() {
        return cropName;
    }

    public String getCropId() {
        return cropId;
    }

    private String soil;

    public Double getCropArea() {
        return cropArea;
    }

    private String cropId;

    private String cropName;
    private Double cropArea;
    private String sownMonthYear;
    private String harvestMonthYear;
    private Double yield;
    private String comments;

    public void setFarmId(Long farmId) {
        this.farmId = farmId;
    }

    public void setFarmName(String farmName) {
        this.farmName = farmName;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public void setSoil(String soil) {
        this.soil = soil;
    }

    public void setCropId(String cropId) {
        this.cropId = cropId;
    }

    public void setCropName(String cropName) {
        this.cropName = cropName;
    }

    public void setCropArea(Double cropArea) {
        this.cropArea = cropArea;
    }

    public void setSownMonthYear(String sownMonthYear) {
        this.sownMonthYear = sownMonthYear;
    }

    public void setHarvestMonthYear(String harvestMonthYear) {
        this.harvestMonthYear = harvestMonthYear;
    }

    public void setYield(Double yield) {
        this.yield = yield;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }


}
