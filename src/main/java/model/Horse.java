package model;

import lombok.Data;

@Data
public class Horse {
    private final String name;
    private final Rider rider;
    private final Breed breed;
    private final double averageSpeed;
}
