package stash.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import stash.beans.Acorn;
import stash.beans.User;

@Repository
public interface AcornRepository extends JpaRepository <User, Long> { }
