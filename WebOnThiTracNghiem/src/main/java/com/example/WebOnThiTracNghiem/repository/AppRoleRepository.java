package com.example.WebOnThiTracNghiem.repository;
import com.example.WebOnThiTracNghiem.model.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface AppRoleRepository extends JpaRepository<AppRole, Long>{
}
