package com.example.demo.controller;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/simpleRest")
public class All_in_one {
	//this is sample method post rest with parameter
	@RequestMapping(value = "/simpleReturnRestPOST", method = RequestMethod.POST)
	public @ResponseBody String getSimplePOST(@RequestBody String params) {
		String parameter = params;
		return parameter;
	}
	
	//this is sample method get rest parameter
	@RequestMapping(value = "/simpleReturnRestGET", method = RequestMethod.GET)
	public @ResponseBody String getSimpleGET(@RequestBody String params) {
		String parameter = params;
		return parameter;
	}

	@RequestMapping(value = "/simpleReturnRestGETnotParams", method = RequestMethod.GET)
	public @ResponseBody String getSimpleGETNotParams() {
		String parameter = "{\"data\":\"sample simple rest biar paham aja\"}";
		return parameter;
	}

	@RequestMapping(value = "/simpleReturnRestGETdataMysql", method = RequestMethod.GET)
	public @ResponseBody ArrayList<String> getSimpleMysqls() {
		ArrayList<String> arr_data = new ArrayList<>();
		try {

			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://host:port/your data base";
			Connection conn = (Connection) DriverManager.getConnection(url, "root", "password");

			Statement st = (Statement) conn.createStatement();
			String query = "select * from spring";

			// execute the query, and get a java resultset
			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {

				// you cat set get looping data to string in your field myslq database , example:
				// free mapping your data oke this is example
				String id = rs.getString("id");
				arr_data.add(id);
			}

			st.close();
		} catch (Exception e) {
			// TODO: handle exception
		}

		return arr_data;

	}
}
