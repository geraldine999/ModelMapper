package com.example.modelmapper;
import lombok.*;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "item")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@ToString
public class Item {


    @XmlAttribute(name = "name")
    private String name;

    @XmlAttribute(name = "desc")
    private String desc;


    @XmlElement(name = "item")
    private List<Item> items;

}
