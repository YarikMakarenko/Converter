package com.company;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonParser {
     List<Our_Object> expansion = new ArrayList<>(){};
        public JsonParser()  {

    }
    // Считываем файл Input_data.json с входными параметрами
        public Our_Object parser_data()  {

        Object parse = null;
        try {
            parse = new JSONParser().parse(new FileReader("Input_data.json"));
        } catch (IOException | ParseException e) {
            System.out.println("Нечего конвертировать!");
            e.printStackTrace();
        }
        JSONObject json = (JSONObject) parse;
        JSONObject distance = (JSONObject) json.get("distance");
        String convert_to = (String) json.get("convert_to");
        String unit = (String) distance.get("unit");
        double value = (double) distance.get("value");

        return new Our_Object(unit, value, convert_to);
    }
    // Считываем файл Expansion.json для расширения возможностей конвертора
        public void parser_Array()  {
        Object parser = null;
        try {
            parser = new JSONParser().parse(new FileReader("Expansion.json"));
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
            JSONObject json = (JSONObject) parser;
            JSONArray lang = (JSONArray) json.get("expansion");
            if (lang!=null)
        for (Object obj : lang) {
            JSONObject object = (JSONObject) obj;
            String unit = (String) object.get("unit");
            double coefficient = (double) object.get("coefficient");
            String convert_to = (String) object.get("convert_to");
            expansion.add(new Our_Object(unit, coefficient, convert_to));
        }
    }
    // Добавляем результат в Result.json
        public void load_To_Json(Our_Object e)  {
            JSONArray a = new JSONArray();
            JSONObject result = new JSONObject();

//            result.put("result",JSONArray a);
            result.put("unit",e.getUnit());
            result.put("value", e.getCoefficient());
            FileWriter writer = null;
            try {
                writer = new FileWriter("Result.json");
                writer.write(result.toJSONString());
                writer.flush();
                writer.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
                }
    }

}
