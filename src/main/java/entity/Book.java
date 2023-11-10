package entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Book {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="book_id")
	@Getter @Setter private long id;
	
	@Getter @Setter private String author;
	@Getter @Setter private String country;
	
	@Column(name="image_link")
	@Getter @Setter private String imageLink;
	
	@Getter @Setter private String language;
	@Getter @Setter private String link;
	@Getter @Setter private int pages;
	@Getter @Setter private String title;
	@Getter @Setter private int year;
	@Getter @Setter private BigDecimal price;
	
	
}
