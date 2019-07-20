package com.niit.EcomBackend.DAO;

import java.util.List;

import com.niit.EcomBackend.Model.Supplier;

public interface SupplierDAO {
boolean createSupplier(Supplier supplier);
boolean updateSupplier(Supplier supplier);
boolean deleteSupplier(Supplier supplier);
List<Supplier>selectAllSupplier();
Supplier selectOneSupplier(String emailId);
}
