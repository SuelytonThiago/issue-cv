package io.github.suelytonthiago.Issuecv.domain.repositories;

import io.github.suelytonthiago.Issuecv.domain.entites.Curriculum;
import io.github.suelytonthiago.Issuecv.domain.entites.Issue;
import io.github.suelytonthiago.Issuecv.domain.enums.IssueStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IssueRepository extends JpaRepository<Issue,Long> {
    Optional<Issue> findByCurriculum(Curriculum curriculum);

    List<Issue> findTop3ByStatus(IssueStatus status);


}
