/**
 * 
 */
package com.viasimplex.covid19.utils;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.viasimplex.covid19.jdbc.DBConnection;

/**
 * @author Sreeharsha Venkatapuram
 * 
 * 
 */
public class DataIngester {
	private static final String JDBC_URI = "jdbc:mysql://lachapelle.bowl.dreamhost.com/covid19db?useSSL=false";
	private static final String MYSQL_UNAME = "sreeharsha";
	private static final String MYSQL_PASS = "C0r0n4v1rus";

	public static void main(String[] args) throws SQLException {
		String filePath = "/media/sree/Drive/CCS/covid19/covid19-dashboard/jsons/india-districts.json";
		DBConnection dbCon = new DBConnection(JDBC_URI, MYSQL_UNAME, MYSQL_PASS);
		Connection con = dbCon.getConnection();
		JSONObject json = file2Json(filePath);
		Statement st = con.createStatement();
		JSONArray features = (JSONArray) json.get("features");
		for (Object feature : features) {
			feature = (JSONObject) feature;
			System.out.println(feature.toString());
		}
	}

	public static JSONObject file2Json(String file) { 
    	JSONParser parser = new JSONParser(); 
    	JSONObject json = new JSONObject();
    	try { 
    		System.out.println("Reading JSON file from Java program"); 
    		FileReader fileReader = new FileReader(file); 
    		json = (JSONObject) parser.parse(fileReader); 
    	} catch (Exception ex) {
            ex.printStackTrace();
        }
    	return json;
    }
}
