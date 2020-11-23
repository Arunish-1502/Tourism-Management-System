package com.cts.dao;

import java.sql.SQLException;
import com.cts.model.TransactionDetails;
import com.cts.model.bookingDetails;

public interface TransactionDetailsDao {
	public int getTotalCost(bookingDetails bookingDetails) throws SQLException;
	public int getBaseCost(int packageId) throws SQLException;
	public boolean extractTransactionDetails(TransactionDetails transactionDetails) throws SQLException;
	
}
