package lk.ijse.spring.repo;

import lk.ijse.spring.entity.BookingDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingDetailsRepo extends JpaRepository<BookingDetails,String> {

}
