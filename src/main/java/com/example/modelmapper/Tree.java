package com.example.modelmapper;
import lombok.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "tree")
@Getter
@Setter
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@ToString
@Builder
public class Tree {


    @XmlElement(name="item")
    private List<Item> items;

    private List<Item> ISO8583;

    private List<Verdict> verdicts = new ArrayList<>();

    public Tree() {
    }
}
