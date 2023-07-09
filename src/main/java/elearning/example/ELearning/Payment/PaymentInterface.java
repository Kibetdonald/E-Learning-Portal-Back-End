package elearning.example.ELearning.Payment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentInterface extends JpaRepository<PaymentModel, Long> {
}
