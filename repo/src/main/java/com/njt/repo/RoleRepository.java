package com.njt.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.njt.repo.entity.Role;
import com.njt.repo.enumeration.RoleName;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>
{
	Optional<Role> findByName(RoleName roleName);
}