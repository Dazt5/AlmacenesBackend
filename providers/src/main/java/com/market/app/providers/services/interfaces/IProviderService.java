package com.market.app.providers.services.interfaces;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Optional;

import com.market.app.providers.entity.Provider;

public interface IProviderService {
	
	public ArrayList<Provider> getAll();
	public Optional<Provider> getById(BigInteger id);
	public Provider create(Provider provider);
	public Provider update(Provider provider, BigInteger id);
	public void delete(BigInteger id);
	
}
