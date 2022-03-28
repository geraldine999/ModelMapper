package com.example.modelmapper;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@ContextConfiguration(classes = {TreeToDtoConverter.class, ModelMapperConfig.class})
public class TreeToDtoConverterTest {

    @Autowired
    TreeToDtoConverter treeToDtoConverter;

    private ModelMapper mapper;


    @Nested
    class convertXmlTreeToDto{
        @BeforeEach
        public void setup() {
            mapper = new ModelMapper();
        }
        @Test
        void test(){
            List<Item> items = new ArrayList<>();
            Item item = new Item();
            item.setName("name");
            item.setDesc("desc");

            Item item2 = new Item();
            item2.setName("name2");
            item2.setDesc("desc2");
            Item item1 = new Item("nested", "nested", null);
            List<Item> items1 = new ArrayList<>();
            items1.add(item1);
            item2.setItems(items1);

            items.add(item);
            items.add(item2);

            Verdict verdict = new Verdict();
            verdict.setComment("comment");
            verdict.setResult("result");

            Verdict verdict2 = new Verdict();
            verdict2.setComment("comment");
            verdict2.setResult("result");

            Tree tree = Tree.builder()
                    .ISO8583(items)
                    .verdicts(List.of(verdict, verdict2))
                    .build();

            System.out.println(treeToDtoConverter.convertXmlTreeToDto(tree));
        }
    }

}
