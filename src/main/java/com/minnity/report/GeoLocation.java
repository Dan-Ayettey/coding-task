package com.minnity.report;

public class GeoLocation {

  private final String ipAddress;
  private final String city;
  private final String country;

  private GeoLocation(String ipAddress, String city, String country) {
    this.ipAddress = ipAddress;
    this.city = city;
    this.country = country;
  }

  public String getIpAddress() {
    return ipAddress;
  }

  public String getCity() {
    return city;
  }

  public String getCountry() {
    return country;
  }

  public static final class GeoLocationBuilder {
    private String ipAddress;
    private String city;
    private String country;

    private GeoLocationBuilder() {
    }

    public static GeoLocationBuilder aGeoLocation() {
      return new GeoLocationBuilder();
    }

    public GeoLocationBuilder withIpAddress(String ipAddress) {
      this.ipAddress = ipAddress;
      return this;
    }

    public GeoLocationBuilder withCity(String city) {
      this.city = city;
      return this;
    }

    public GeoLocationBuilder withCountry(String country) {
      this.country = country;
      return this;
    }

    public GeoLocation build() {
      return new GeoLocation(ipAddress, city, country);
    }
  }
}
