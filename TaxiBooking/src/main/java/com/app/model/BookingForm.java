package com.app.model;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="bookingform")
public class BookingForm {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@NotEmpty(message="Name can't be Empty")
	@NotBlank(message="Name can't be Blank")
	@Size(min=2, max=30, message="invalid name length")
	@Pattern(regexp="^[A-Za-z]+$", message="Name must contain only alphabet")
	@Column(length=30)
	private String name;
	@NotEmpty(message="Source can't be Empty")
	@NotBlank(message="Source can't be Blank")
	@Size(min=2, max=100, message="invalid source length")
	@Column(length=100)
	private String source;
	@NotEmpty(message="Email can't be Empty")
	@NotBlank(message="Email can't be Blank")
	@Size(min=7, max=50, message="invalid email length")
	@Column(length=50)
	private String email;
	@NotEmpty(message="Destination can't be Empty")
	@NotBlank(message="Destination can't be Blank")
	@Size(min=2, max=100, message="invalid destination length")
	@Column(length=100)
	private String destination;
	@NotNull(message="Time can't be Empty")
	private LocalTime time;
	@NotNull(message="Date can't be Empty")
	private LocalDate date;
	@NotEmpty(message="Comfort can't be Empty")
	@Size(min=2, max=20, message="invalid comfort length")
	@Column(length=20)
	private String comfort;
	@Min(value=1, message="Adult can be atmost 1")
	@Max(value=4, message="Adult can be atmost 4")
	private int adult;
	@Max(value=3, message="Children can be atmost 3")
	private int children;
	@NotEmpty(message="Message can't be Empty")
	@NotBlank(message="Message can't be Blank")
	@Size(min=2, max=2000, message="invalid message length")
	@Column(length=2000)
	private String message;
	

}
