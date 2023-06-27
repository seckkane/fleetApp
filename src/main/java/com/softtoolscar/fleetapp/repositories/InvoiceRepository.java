package com.softtoolscar.fleetapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.softtoolscar.fleetapp.models.Invoice;


@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {

}
