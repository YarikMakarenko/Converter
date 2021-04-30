package com.company;

import java.util.ArrayList;

public class Convert_To {
    ArrayList<Our_Object> start = new ArrayList();
    JsonParser jp = new JsonParser();
    Our_Object Inch_to_cm = new Our_Object("in",2.54d,"cm");
    Our_Object Foot_to_cm = new Our_Object("ft",30.48d,"cm");
    Our_Object Metrs_to_cm = new Our_Object("m",100d,"cm");
    Our_Object Cm_to_cm = new Our_Object("cm",1d,"cm");

         public Convert_To()  {
        add();
         }
    // Добавляем начальные вариенты едениц конвертации
         public void add(){
             start.add(Inch_to_cm);
             start.add(Foot_to_cm);
             start.add(Metrs_to_cm);
             start.add(Cm_to_cm);
         }
    // Конвертируем данные
         public Our_Object Convert_to(Our_Object o)  {
             double temporary=0;
             double value=0;
             Our_Object distance = new Our_Object("Упс!",0);
             jp.parser_Array();
             start.addAll(jp.expansion);
             for (Our_Object f : start) {
                     if (f.getUnit().equals(o.getUnit())){
                     temporary = o.getCoefficient()*f.getCoefficient();
                     }
             }
             for (Our_Object f : start){
                 if (f.getUnit().equals(o.getConvert_to())){
                     value = temporary/f.getCoefficient();
                 }
             }
             if(value==0) {
                 System.out.println("Не возможно конвертировать эту единицу измерения, расширьте конвертор.");
             }else {
                distance = new Our_Object(o.getConvert_to(),value);
             }
             return distance;

         }
}
