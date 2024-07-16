package com.example.app.beans;

import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SinhVien {

    public String name;
    public Boolean  gender;
    public Double mark = 0.0;
    Contacts contacts;
    List<String> subjects;

}
