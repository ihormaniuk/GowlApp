package com.groot.gowl.ArraysPage;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArraysPageSerial implements Serializable,Comparable<ArraysPageSerial>{
    private String seriesUrl;
    private String infoSeries;
    private String image;
    private int id;


    public ArraysPageSerial(String seriesUrl, String infoSeries,String image,int id) {
        this.seriesUrl = seriesUrl;
        this.infoSeries = infoSeries;
        this.image = image;
        this.id = id;
    }

    public ArraysPageSerial(String image) {
        this.image = image;
    }




    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSeriesUrl() {
        return seriesUrl;
    }

    public void setSeriesUrl(String seriesUrl) {
        this.seriesUrl = seriesUrl;
    }

    public String getInfoSeries() {
        return infoSeries;
    }

    public void setInfoSeries(String infoSeries) {
        this.infoSeries = infoSeries;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
//    private String getIds(){
//        String a = null;
//        Pattern pattern = Pattern.compile("\\d");
//        Matcher matcher = pattern.matcher(getInfoSeries());
//        while (matcher.find()) {
//            System.out.println(matcher.group());
//            a = matcher.group();
//        }
//        return a;
//    }


    @Override
    public int compareTo(ArraysPageSerial o){
//        int i = Integer.parseInt(getIds().trim());
        return this.id - o.getId();
    }

}