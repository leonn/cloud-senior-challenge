package com.challenge;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import org.bson.Document;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class CurrencyService {
    @Inject MongoClient mongoClient;

    public List<Currency> list(String currencyType){
        List<Currency> list = new ArrayList<>();
        MongoCursor<Document> cursor = getCollection(currencyType).find().iterator();

        try {
            while (cursor.hasNext()) {
                Document document = cursor.next();
                Currency currency = new Currency();
                currency.setId(document.getObjectId("_id").toString());
                currency.setTimestamp(document.getLong("timestamp"));
                currency.setExchangeRateDatetime(document.getString("exchangeRateDatetime"));
                currency.setExchangeRateDate(document.getString("exchangeRateDate"));
                currency.setBuyRate(document.getDouble("buyRate"));
                currency.setSellRate(document.getDouble("sellRate"));
                list.add(currency);
            }
        } finally {
            cursor.close();
        }
        return list;
    }

    public void add(Currency currency, String currencyType){
        Document document = new Document()
            .append("timestamp", currency.getTimestamp())
            .append("exchangeRateDatetime", currency.getExchangeRateDatetime())
            .append("exchangeRateDate", currency.getExchangeRateDate())
            .append("buyRate", currency.getBuyRate())
            .append("sellRate", currency.getSellRate());
        getCollection(currencyType).insertOne(document);
    }

    private MongoCollection getCollection(String currencyType){
        return mongoClient.getDatabase("exchange").getCollection(currencyType);
    }
}