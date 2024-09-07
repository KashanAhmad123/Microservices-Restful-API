package respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entity.department;

@Repository
public interface DepartmentRepository extends JpaRepository<department,Long> {
	

}
