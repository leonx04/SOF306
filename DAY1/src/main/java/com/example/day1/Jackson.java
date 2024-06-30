package com.example.day1;

import com.example.day1.entity.Contact;
import com.example.day1.entity.SinhVien2;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Jackson {

    public static void main(String[] args) throws Exception {

        demo1();
        demo2();
        demo3();
        demo4();
        demo5();
        demo6();
        demo7();
        demo8();
        demo9();
    }

    private static void demo9() throws Exception {
        System.out.println("Demo 9 ----------------------");
        Contact contact = new Contact("0123456789", "v5jXc@example.com");
        List<String> subjects = List.of("Toan", "Ly");
        SinhVien2 SinhVien2 = new SinhVien2("Nguyễn Văn A", "Nam", "8.5", contact, subjects);
        System.out.println("Sinh viên: " + SinhVien2);
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(SinhVien2);
        System.out.println(json);

        //Write to file
        mapper.writeValue(new File("A:\\SOF306\\DAY1\\src\\main\\resources\\SinhVien.json"), SinhVien2);

    }

    private static void demo8() throws Exception {
        System.out.println("Demo 8 ----------------------");
        Map<String, Object> contact = new HashMap<>();
        contact.put("phone", "0123456789");
        contact.put("email", "v5jXc@example.com");
        System.out.println("Contact: " + contact);

        List<String> subjects = List.of("Toan", "Ly");
        System.out.println("Subjects: " + subjects);

        Map<String, Object> SinhVien2 = new HashMap<String, Object>();
        SinhVien2.put("name", "Nguyễn Văn A");
        SinhVien2.put("gender", "Nam");
        SinhVien2.put("marks", 8.5);
        SinhVien2.put("contact", contact);
        SinhVien2.put("subjects", subjects);
        System.out.println("Sinh viên : " + SinhVien2);

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(SinhVien2);
        System.out.println(json);

        //Write to String
         mapper.writeValueAsString(SinhVien2);
        //Write to file
        mapper.writeValue(new File("A:\\SOF306\\DAY1\\src\\main\\resources\\SinhVien.json"), SinhVien2);

    }

    private static void demo7() throws Exception {
        System.out.println("Demo 7 ----------------------");
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode SinhVien2 = mapper.createObjectNode();
        SinhVien2.put("name", "Nguyễn Văn A");
        SinhVien2.put("gender", "Nam");
        SinhVien2.put("marks", 8.5);
        ObjectNode contact = mapper.createObjectNode();
        contact.put("phone", "0123456789");
        contact.put("email", "v5jXc@example.com");
        SinhVien2.set("contact", contact);
        ArrayNode subjects = SinhVien2.putArray("subjects");
        subjects.add("Toan");
        subjects.add("Ly");
        SinhVien2.set("subjects", subjects);
        System.out.println(SinhVien2.toString());

        //Write to String
        String json = mapper.writeValueAsString(SinhVien2);
        // Write to file
        mapper.writeValue(new File("A:\\SOF306\\DAY1\\src\\main\\resources\\SinhVien.json"), SinhVien2);
    }


    private static void demo6() throws Exception {
        System.out.println("Demo 6 ----------------------");
        String path = "A:\\SOF306\\DAY1\\src\\main\\resources\\SinhViens.json";
        TypeReference<List<SinhVien2>> type = new TypeReference<List<SinhVien2>>() {};
        ObjectMapper mapper = new ObjectMapper();
        List<SinhVien2> SinhViens = mapper.readValue(new File(path), type);
        SinhViens.forEach(sinhVien -> {
            System.out.println("Sinh viên: " + sinhVien.getName());
            System.out.println("------------------");
        });
    }

    private static void demo5() throws Exception {
        System.out.println("Demo 5 ----------------------");
        String path = "A:\\SOF306\\DAY1\\src\\main\\resources\\SinhVien.json";
        ObjectMapper mapper = new ObjectMapper();
        SinhVien2 SinhViens = mapper.readValue(new File(path), SinhVien2.class);
        System.out.println("Sinh viên: " + SinhViens.getName());
        System.out.println("Giới tính: " + SinhViens.getGender());
        System.out.println("Điểm: " + SinhViens.getMarks());
        Contact contact = SinhViens.getContact();
        System.out.println("Số điện thoại: " + contact.getPhone());
        System.out.println("Email: " + contact.getEmail());
        List<String> subjects = SinhViens.getSubjects();
        subjects.forEach(subject -> {
            System.out.println("Môn học: " + subject);
        });
    }

    private static void demo4() throws Exception{
        System.out.println("Demo 4 ----------------------");
        String path = "A:\\SOF306\\DAY1\\src\\main\\resources\\SinhViens.json";
        ObjectMapper mapper = new ObjectMapper();
        List<Map<String, Object>> SinhViens = mapper.readValue(new File(path), List.class);
        SinhViens.forEach(sinhVien -> {
            System.out.println("Sinh viên: " + sinhVien.get("name"));
            System.out.println("------------------");
        });
    }

    private static void demo3() throws Exception{
        System.out.println("Demo 3 ----------------------");
        String path = "A:\\SOF306\\DAY1\\src\\main\\resources\\SinhVien.json";
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> SinhVien = mapper.readValue(new File(path), Map.class);

        System.out.println("Sinh viên: " + SinhVien.get("name"));
        System.out.println("Giới tính: " + SinhVien.get("gender"));
        System.out.println("Điểm: " + SinhVien.get("marks"));
        Map<String, Object> contact = (Map<String, Object>) SinhVien.get("contact");
        System.out.println("Số điện thoại: " + contact.get("phone"));
        System.out.println("Email: " + contact.get("email"));
        List<String> subjects = (List<String>) SinhVien.get("subjects");
        subjects.forEach(subject -> {
            System.out.println("Môn học: " + subject);
        });

    }

    private static void demo2() throws Exception{
        System.out.println("Demo 2 ----------------------");
        String path = "A:\\SOF306\\DAY1\\src\\main\\resources\\SinhViens.json";
        ObjectMapper mapper = new ObjectMapper();
        JsonNode SinhVien = mapper.readTree(new File(path));
        SinhVien.iterator().forEachRemaining(sinhVien -> {
            System.out.println("Sinh viên: " + sinhVien.get("name").asText());
            System.out.println("------------------");
        });

    }

    private static void demo1() {
        System.out.println("Demo 1 ----------------------");
        String path = "A:\\SOF306\\DAY1\\src\\main\\resources\\SinhVien.json";

        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode sinhVien = mapper.readTree(new File(path));
            System.out.println("Tên Sinh viên: " + sinhVien.get("name").asText());
            System.out.println("Giới tính: " + sinhVien.get("gender").asBoolean());
            System.out.println("Điểm: " + sinhVien.get("marks").asDouble());
            System.out.println("Số điện thoại: " + sinhVien.get("contact").get("phone").asText());
            System.out.println("Email: " + sinhVien.get("contact").get("email").asText());
            sinhVien.get("subjects").forEach(subject -> {
                System.out.println("Môn học: " + subject.asText());
            });
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}