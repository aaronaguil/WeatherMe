package com.data;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;

import com.core.city.USCity;

public class CityDAOImpl implements CityDAO{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<USCity> getUSCityInformation(String usCityIn) {
		List<USCity> usCities = null;
		String query = "SELECT c from USCity c WHERE c.city = '" + usCityIn + "'";
		try {
			
			USCity usCity = (USCity) entityManager.createQuery(query).getSingleResult();
			usCities = new ArrayList<USCity>();
			usCities.add(usCity);
		}
		catch(NoResultException noResultException) {
			noResultException.printStackTrace();
		}
		catch(NonUniqueResultException nonUniqueResultExcpetion) {
			nonUniqueResultExcpetion.printStackTrace();
			usCities = entityManager.createQuery(query).getResultList();
		}
		return usCities;
	}

	@Override
	public USCity getUSCityInformationByCityAndCounty(String city, String county) {
		System.out.println("city dao: " + city);
		System.out.println("city county: " + county);
		USCity usCity = null;
		String query = "SELECT c from USCity c WHERE c.city='" + city + "' AND c.county='" + county + "'";
		try {
			
			usCity = (USCity) entityManager.createQuery(query).getSingleResult();
			System.out.println(usCity);
		}
		catch(NoResultException noResultException) {
			noResultException.printStackTrace();
		}
		return usCity;
	}
}
