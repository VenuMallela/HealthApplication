package in.hsp.venu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import in.hsp.venu.entity.Admin;
@Repository
public interface AdminRepository extends JpaRepository<Admin,Integer>{
	
	@Query("SELECT COUNT(code) FROM Admin WHERE code=:code")
	public Integer adminCountExit(String code);

}
