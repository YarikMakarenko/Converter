package com.company;

public class Main {
    public static void main(String[] args)  {
        JsonParser jp = new JsonParser();
	    Convert_To ct = new Convert_To();
        jp.load_To_Json(ct.Convert_to(jp.parser_data()));
    }
}
