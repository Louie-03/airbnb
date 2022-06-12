package louie.dong.airbnb.web.book.dto;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import louie.dong.airbnb.domain.Book;

@Getter
@AllArgsConstructor
public class BookResponse {

	private Long bookId;
	private String accommodationImageUrl;
	private LocalDate checkIn;
	private LocalDate checkOut;
	private String accommodationCountry;
	private String accommodationName;

	public BookResponse(Book book) {
		this.bookId = book.getId();
		this.accommodationImageUrl = book.getAccommodation().getAccommodationImages().get(0).getImageUrl();
		this.checkIn = book.getCheckIn().toLocalDate();
		this.checkOut = book.getCheckOut().toLocalDate();
		this.accommodationCountry = book.getAccommodation().getCountry();
		this.accommodationName = book.getAccommodation().getName();
	}
}
