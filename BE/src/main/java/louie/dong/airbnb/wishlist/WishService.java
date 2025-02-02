package louie.dong.airbnb.wishlist;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import louie.dong.airbnb.accommodation.Accommodation;
import louie.dong.airbnb.accommodation.AccommodationRepository;
import louie.dong.airbnb.wishlist.dto.WishResponse;
import louie.dong.airbnb.wishlist.dto.WishSaveRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class WishService {

    private final AccommodationRepository accommodationRepository;
    private final WishRepository wishRepository;

    @Transactional
    public void save(WishSaveRequest wishSaveRequest) {
        Accommodation accommodation = accommodationRepository.findById(
                wishSaveRequest.getAccommodationId())
            .orElseThrow(NoSuchElementException::new);

        boolean existsWish = wishRepository.existsByAccommodationId(wishSaveRequest.getAccommodationId());
        if (!existsWish) {
            Wish wish = new Wish(accommodation);
            wishRepository.save(wish);
        }
    }

    public List<WishResponse> findAll() {
        return wishRepository.findAll().stream()
            .map(WishResponse::new).collect(Collectors.toList());
    }

    public void delete(Long id) {

    }
}
