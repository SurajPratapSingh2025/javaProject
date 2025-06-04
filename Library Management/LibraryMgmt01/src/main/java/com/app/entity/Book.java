package com.app.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {
	
	private long bookId;
	private String name;
	private String author;
	private String description;
	private boolean available;
	private double pricePerDay;
	private double penaltyPerDay;
	
	@Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", description='" + description + '\'' +
                ", available=" + available +
                ", pricePerDay=" + pricePerDay +
                ", penaltyPerDay=" + penaltyPerDay +
                '}';
    }
	
}
