package com.zuobiao.map.vo;

public class GeometryVo {
	private String id;
	private String formatted_address;// 标准地址
	private String address;
	private String square;
	private String location;// 坐标
	private String businessAreas;// 商圈
	private String streetNumber;
	private String street;// 街道名
	private String district;// 区域
	private String adcode;// 地区编码
	private String area;// 小区面积
	private String township;
	private String areaName;
	private String longitude;
	private String latitude;

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFormatted_address() {
		return formatted_address;
	}

	public void setFormatted_address(String formatted_address) {
		this.formatted_address = formatted_address;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSquare() {
		return square;
	}

	public void setSquare(String square) {
		this.square = square;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getBusinessAreas() {
		return businessAreas;
	}

	public void setBusinessAreas(String businessAreas) {
		this.businessAreas = businessAreas;
	}

	public String getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getAdcode() {
		return adcode;
	}

	public void setAdcode(String adcode) {
		this.adcode = adcode;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getTownship() {
		return township;
	}

	public void setTownship(String township) {
		this.township = township;
	}

	public GeometryVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GeometryVo(String id, String formatted_address, String address, String square, String location,
			String businessAreas, String streetNumber, String street, String district, String adcode, String area,
			String township) {
		super();
		this.id = id;
		this.formatted_address = formatted_address;
		this.address = address;
		this.square = square;
		this.location = location;
		this.businessAreas = businessAreas;
		this.streetNumber = streetNumber;
		this.street = street;
		this.district = district;
		this.adcode = adcode;
		this.area = area;
		this.township = township;
	}

}
