package com.project.helpesk.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.helpesk.entities.Ticket;

/**
 * @author opera_ao6omsd.
 *
 */
@Repository
public interface TicketRepo extends JpaRepository<Ticket, Integer> {

    /**
     * @param eid eid.
     * @return find By eid.
     */
    @Query("SELECT u FROM Ticket u WHERE u.eid = :eid")
    List<Ticket> findByEid(@Param("eid") int eid);

    /**
     * @param open open.
     * @return find by status open.
     */
    @Query("SELECT u FROM Ticket u WHERE u.status LIKE %:Open%")
    List<Ticket> findByStatusOpen(@Param("Open") String open);

    /**
     * @param close close.
     * @return find by status close.
     */
    @Query("SELECT u FROM Ticket u WHERE u.status LIKE %:Close%")
    List<Ticket> findByStatusClose(@Param("Close") String close);


    /**
     * @param inProgress inprogress.
     * @return find by status in progress.
     */
    @Query("SELECT u FROM Ticket u WHERE u.status LIKE %:inProgress%")
    List<Ticket> findByStatusinProgress(@Param("inProgress") String inProgress);

    /**
     * @param moderate moderate.
     * @return find by priority Moderate.
     */
    @Query("SELECT u FROM Ticket u WHERE u.priority LIKE %:Moderate%")
    List<Ticket> findByPriorityModerate(@Param("Moderate") String moderate);

    /**
     * @param high high.
     * @return find by priority high.
     */
    @Query("SELECT u FROM Ticket u WHERE u.priority LIKE %:High%")
    List<Ticket> findByPriorityHigh(@Param("High") String high);

    /**
     * @param low low.
     * @return find by priority low.
     */
    @Query("SELECT u FROM Ticket u WHERE u.priority LIKE %:Low%")
    List<Ticket> findByPriorityLow(@Param("Low") String low);

}
