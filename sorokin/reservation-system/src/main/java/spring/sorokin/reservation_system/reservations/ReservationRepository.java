package spring.sorokin.reservation_system.reservations;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface ReservationRepository extends JpaRepository<ReservationEntity, Long> {

//    List<ReservationEntity> findAllByStatusIs(ReservationStatus status);

//    @Query(value = "SELECT * FROM reservations r WHERE r.status = :status", nativeQuery = true)
//    List<ReservationEntity> findAllByStatusIs(ReservationStatus status);
//
//    @Query("SELECT r FROM ReservationEntity r WHERE r.roomId = :roomId")
//    List<ReservationEntity> findAllByRoomId(Long roomId);
//
//    @Transactional
//    @Modifying
//    @Query("""
//            UPDATE ReservationEntity r
//            SET r.userId = :userId,
//                r.roomId = :roomId,
//                r.startDate = :startDate,
//                r.endDate = :endDate,
//                r.status = :status
//            WHERE r.id = :id
//            """)
//    int updateAllFields(
//            @Param("id") Long id,
//            @Param("userId") Long userId,
//            @Param("roomId") Long roomId,
//            @Param("startDate") LocalDate startDate,
//            @Param("endDate") LocalDate endDate,
//            @Param("status") ReservationStatus status
//    );

    @Modifying
    @Query("""
            UPDATE ReservationEntity r
            SET r.status = :status
            WHERE r.id = :id
            """)
    void setStatus(
            @Param("id") Long id,
            @Param("status") ReservationStatus status
    );

    @Query("""
                  SELECT r.id FROM ReservationEntity r
                  WHERE r.roomId= :roomId
                  AND :startDate < r.endDate
                  AND r.startDate < :endDate
                  AND r.status = :status
            """)
    List<Long> findConflictReservationIds(
            @Param("roomId") Long roomId,
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate,
            @Param("status") ReservationStatus status
    );

    @Query("""
            SELECT r FROM ReservationEntity r
                WHERE (:roomId IS NULL OR r.roomId = :roomId)
                AND (:userId IS NULL OR r.userId = :userId)
            """)
    List<ReservationEntity> searchAllByFilter(
            @Param("roomId") Long roomId,
            @Param("userId") Long userId,
            Pageable pageable
    );
}













