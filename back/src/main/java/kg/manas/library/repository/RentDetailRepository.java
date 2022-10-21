package kg.manas.library.repository;

import kg.manas.library.entity.RentDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RentDetailRepository extends JpaRepository<RentDetail, Long> {

    List<RentDetail> findAllByRentId(Long id);
}
