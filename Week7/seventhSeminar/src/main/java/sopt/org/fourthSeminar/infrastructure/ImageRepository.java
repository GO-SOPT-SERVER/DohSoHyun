package sopt.org.fourthSeminar.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import sopt.org.fourthSeminar.domain.Image;

public interface ImageRepository extends JpaRepository<Image , Long> {
    Image save(Image image);
}
