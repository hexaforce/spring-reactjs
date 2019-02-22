package io.hexaforce.websocket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;

import io.hexaforce.websocket.model.Employee;

@PreAuthorize("hasRole('ROLE_MANAGER')")
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Override
    @PreAuthorize("#employee?.manager == null or #employee?.manager?.name == authentication?.name")
    Employee save(@Param("employee") Employee employee);

    @Override
    @PreAuthorize("@employeeRepository.findById(#id)?.manager?.name == authentication?.name")
    void deleteById(@Param("id") Long id);

    @Override
    @PreAuthorize("#employee?.manager?.name == authentication?.name")
    void delete(@Param("employee") Employee employee);

}
