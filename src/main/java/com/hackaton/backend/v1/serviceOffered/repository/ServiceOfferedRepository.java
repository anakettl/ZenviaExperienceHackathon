package com.hackaton.backend.v1.serviceOffered.repository;

        import com.hackaton.backend.v1.serviceOffered.model.ServiceOffered;
        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.stereotype.Repository;

@Repository
public interface ServiceOfferedRepository extends JpaRepository<ServiceOffered, Long> {
}
