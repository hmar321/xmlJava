package com.ies.baroja;

import org.json.*;

import java.nio.file.Files;
import java.nio.file.Path;

import java.nio.file.Paths;

import java.io.IOException;

public class Ejercicio2Convert {

	private static Path pathIn = Paths.get("src\\xml\\ejercicio2.xml");
	private static Path pathout = Paths.get("src\\json\\ejercicio2.json");

	public static void main(String[] args) {

		try {

			/* 1- Leemos el xml */
			String xml = Files.readString(pathIn);
			/* 2- Lo convertimos, a JSON */
			System.out.println("XML leido: " + xml);
			JSONObject json = XML.toJSONObject(xml);
			String jsonString = json.toString(4);
			System.out.println("Resultado JSON + jsonString");
			/* 3- Lo volcamos a fichero */
			Files.write(pathout, jsonString.getBytes());
		} catch (JSONException | IOException e) {
			System.out.println(e.toString());
			e.printStackTrace();
		} // fin catch
	}
}
