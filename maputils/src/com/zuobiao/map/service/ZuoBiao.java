package com.zuobiao.map.service;

import java.sql.SQLException;
import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zuobiao.map.dao.GeometryDao;
import com.zuobiao.map.vo.GeometryVo;

public class ZuoBiao {

	public static void main(String[] args) throws Exception {
		// String key = "171a090d92697db7615bfdafab817fdd";
		//String key ="606935d14ebc61f49febb37f35f853dd";
		String key ="018bcb4a30809917adb5a05b5258fa5d";
		
		for (int i = 13; i <= 13; i++) {
			getAddress(key,"areadata"+i);
			//getArea(key, "areadata"+i);
		}
		
		
	}

	// 通过坐标获取地址
	public static void getArea(String key, String table) throws Exception {

		GeometryDao gd = new GeometryDao();

		List<GeometryVo> list2 = gd.getAll(table);

		for (GeometryVo vo : list2) {
			if(!"".equals(vo.getLocation())&&vo.getLocation()!=null) {
				System.out.println(vo);
			String zb = vo.getLocation();

			/*
			 * 发送请求获得返回数据
			 * 
			 * @param param 请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
			 */
			String sd = HttpRequest.sendPost("http://restapi.amap.com/v3/geocode/regeo?",
					"key=" + key + "&extensions=all&radius=1000&extensions=all&batch=false&roadlevel=0&location=" + zb);

			JSONObject jo = (JSONObject) JSONObject.parse(sd);
			System.out.println(jo);
			String sa = jo.getString("regeocode");

			JSONObject ja = (JSONObject) JSONObject.parse(sa);
			
			String formatted_address = ja.getString("formatted_address");

			vo.setFormatted_address(formatted_address);
			// 获得地址详情
			String addressComponent = ja.getString("addressComponent");

			JSONObject adc = (JSONObject) JSONObject.parse(addressComponent);

			String township = adc.getString("township");// 字符串
			vo.setTownship(township);

			String adcode = adc.getString("adcode");// 字符串
			vo.setAdcode(adcode);
			String businessAreas = ja.getString("pois");// 周边地区数组

			if (!businessAreas.equals("[[]]")) {
				JSONArray ba = JSONArray.parseArray(businessAreas);

				String baName = "";
				int count = 0;
				for (Object object : ba) {
					JSONObject ob = (JSONObject) JSONObject.parse(object.toString());
					baName += ob.getString("name") + ",";
					count++;
					if (count > 5) {
						break;
					}
				}
				System.out.println(baName);
				vo.setBusinessAreas(baName);
			}

			String streetNumber = adc.getString("streetNumber");// 获得街道
			JSONObject stn = (JSONObject) JSONObject.parse(streetNumber);
			String street = stn.getString("street");
			String stNumber = stn.getString("number");
			vo.setStreet(street);
			vo.setStreetNumber(stNumber);

			// 获得小区地址
			String str = ja.getString("aois");

			JSONArray array = JSONArray.parseArray(str);

			if (array.size() != 0) {
				JSONObject js = (JSONObject) JSONObject.parse(array.get(0).toString());
				vo.setAreaName(js.getString("name"));

				vo.setArea(js.getString("area"));

			}

			gd.updateVo(vo, table);
		}
		}
	}

	public static void getAddress(String key, String table) throws SQLException {

		GeometryDao gd = new GeometryDao();

		List<GeometryVo> list2 = gd.getAll(table);
		int i = 1;
		for (GeometryVo vo : list2) {
			String address = vo.getAddress();

			String sd = HttpRequest.sendPost("http://restapi.amap.com/v3/geocode/geo?",
					"key=" + key + "&district=义乌&city=金华市&citycode=0579&address=" + address);
			// http://restapi.amap.com/v3/geocode/geo?city=金华&citycode=0579&address=

			JSONObject jo = (JSONObject) JSONObject.parse(sd);
			
			String sa = jo.getString("geocodes");

			JSONArray ja = JSONArray.parseArray(sa);
			if (ja.size() != 0) {

				JSONObject jc = (JSONObject) JSONObject.parse(ja.get(0).toString());
				String formatted_address = jc.getString("formatted_address");
				String location = jc.getString("location");
				vo.setLocation(location);
				vo.setFormatted_address(formatted_address);
				gd.updateVo2(vo, table);
			} else {
				continue;
			}

			System.out.println(i);
			i++;

		}
	}
}
