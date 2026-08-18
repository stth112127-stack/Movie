package model;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserBean {

	
	private int id;
	private String title;
	private LocalDate release_year;
	private String duration;
	private String description;
	private int category_id;
	
}
