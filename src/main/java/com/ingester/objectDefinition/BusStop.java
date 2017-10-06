package com.ingester.objectDefinition;

/**
 * 
 * @author ilariacorda
 * @version 1.0
 * @since 2017-10
 *
 */
public class BusStop {

    private String code;
    private String name;
    private String latitude;
    private String longitude;

    public BusStop(String code, String name, String latitude, String longitude) {
        this.setCode(code);
        this.setName(name);
        this.setLatitude(latitude);
        this.setLongitude(longitude);
    }

    public BusStop() {
    }

    @Override
    public String toString() {
        return  "code = " + getCode() +
                ", name = " + getName() +
                ", latitude = " + getLatitude() +
                ", longitude = " + getLongitude();
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

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}
