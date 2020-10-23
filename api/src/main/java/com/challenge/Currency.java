package com.challenge;

import java.util.Objects;

public class Currency {
    private String id;
    private long timestamp;
    private String exchangeRateDatetime;
    private String exchangeRateDate;
    private double buyRate;
    private double sellRate;

    public Currency(String id, long timestamp, String exchangeRateDatetime, String exchangeRateDate, double buyRate, double sellRate) {
        this.id = id;
        this.timestamp = timestamp;
        this.exchangeRateDatetime = exchangeRateDatetime;
        this.exchangeRateDate = exchangeRateDate;
        this.buyRate = buyRate;
        this.sellRate = sellRate;
    }

    public Currency() {
    }
        
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Currency)) {
            return false;
        }

        Currency other = (Currency) obj;

        return other.timestamp==this.timestamp;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.timestamp);
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public Long getTimestamp() {
    return timestamp;
    }
    
    public void setTimestamp(Long timestamp) {
    this.timestamp = timestamp;
    }
    
    public String getExchangeRateDatetime() {
    return exchangeRateDatetime;
    }
    
    public void setExchangeRateDatetime(String exchangeRateDatetime) {
    this.exchangeRateDatetime = exchangeRateDatetime;
    }

    public String getExchangeRateDate() {
    return exchangeRateDate;
    }
    
    public void setExchangeRateDate(String exchangeRateDate) {
    this.exchangeRateDate = exchangeRateDate;
    }
    
    public double getBuyRate() {
    return buyRate;
    }
    
    public void setBuyRate(double buyRate) {
    this.buyRate = buyRate;
    }
    
    public double getSellRate() {
    return sellRate;
    }
    
    public void setSellRate(double sellRate) {
    this.sellRate = sellRate;
    }
}
