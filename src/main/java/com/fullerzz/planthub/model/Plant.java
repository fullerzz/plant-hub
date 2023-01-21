package com.fullerzz.planthub.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@AllArgsConstructor
public class Plant {

    @Getter @Setter @NonNull
    private String name;

    @Getter @Setter
    private String scientificName;

    @Getter @Setter
    private String datePlanted;

    @Getter @Setter
    private String lastWatered;

    @Getter @Setter
    private String output;

    @Getter @Setter
    private String tags;
}
