package com.example.modelmapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TreeToDtoConverter {

    private final ModelMapper modelMapper;


    @Autowired
    public TreeToDtoConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;

        TypeMap<Item, Field> propertyMapper = this.modelMapper.createTypeMap(Item.class, Field.class);
        propertyMapper.addMapping(Item::getName, Field::setField);
        propertyMapper.addMapping(Item::getDesc, Field::setValue);
        propertyMapper.addMapping(Item::getItems, Field::setFields);

        TypeMap<Tree, ReadResultResponseDto> propertyMapper2 = this.modelMapper.createTypeMap(Tree.class, ReadResultResponseDto.class);
        propertyMapper2.addMapping(Tree::getVerdicts, ReadResultResponseDto::setResults);
        propertyMapper2.addMapping(Tree::getISO8583, ReadResultResponseDto::setFields);

    }



    public ReadResultResponseDto convertXmlTreeToDto(Tree tree){
        ReadResultResponseDto result = this.modelMapper.map(tree, ReadResultResponseDto.class);
        return result;
    }

}
