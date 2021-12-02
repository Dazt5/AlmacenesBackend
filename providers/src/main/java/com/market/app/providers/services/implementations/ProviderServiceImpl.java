package com.market.app.providers.services.implementations;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.market.app.providers.dto.ProviderRequestDTO;
import com.market.app.providers.entity.Provider;
import com.market.app.providers.repository.IProviderRepository;
import com.market.app.providers.services.interfaces.IProviderService;

@Service
public class ProviderServiceImpl implements IProviderService {

	@Autowired
	private IProviderRepository providerRepository;
	
	@Override
	public ArrayList<Provider> getAll() {
		return (ArrayList<Provider>) providerRepository.findAll();		
	}

	@Override
	public Optional<Provider> getById(BigInteger id) {
		return providerRepository.findById(id);
	}

	@Override
	public Provider create(ProviderRequestDTO provider) {
		return providerRepository.save(provider.toEntity());
	}

	@Override
	public Provider update(Provider provider, BigInteger id) {
		Provider actualProvider = providerRepository.findById(id).orElse(null);
		if(actualProvider == null) return null;
		
		actualProvider.setNombre_proveedor(provider.getNombre_proveedor());
		actualProvider.setTelefono_proveedor(provider.getTelefono_proveedor());
		actualProvider.setDireccion_proveedor(provider.getDireccion_proveedor());
		actualProvider.setCiudad_proveedor(provider.getCiudad_proveedor());
		
		return providerRepository.save(actualProvider);		
	}

	@Override
	public void delete(BigInteger id) {
		providerRepository.deleteById(id);
	}

}
