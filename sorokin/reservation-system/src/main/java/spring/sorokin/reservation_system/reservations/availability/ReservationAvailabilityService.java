package spring.sorokin.reservation_system.reservations.availability;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import spring.sorokin.reservation_system.reservations.ReservationRepository;
import spring.sorokin.reservation_system.reservations.ReservationStatus;

import java.time.LocalDate;
import java.util.List;

@Service
public class ReservationAvailabilityService {
    private final static Logger log = LoggerFactory.getLogger(ReservationAvailabilityService.class);

    private ReservationRepository repository;

    public ReservationAvailabilityService(ReservationRepository repository) {
        this.repository = repository;
    }

    public boolean isReservationAvailable(
            Long roomId,
            LocalDate startDate,
            LocalDate endDate
    ) {
        if (!endDate.isAfter(startDate))
            throw new IllegalArgumentException("Start date must be 1 day before the end date");

        List<Long> conflictingIds = repository.findConflictReservationIds(
                roomId,
                startDate,
                endDate,
                ReservationStatus.APPROVED
        );
        if (conflictingIds.isEmpty())
            return true;

        log.info("Conflicting with the existing reservations: ids={}", conflictingIds);
        return false;
    }
}
