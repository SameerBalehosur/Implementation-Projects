package com.testyantra.mongodb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testyantra.mongodb.model.Cricketers;
import com.testyantra.mongodb.repository.CricketerRepo;
import com.testyantra.mongodb.request.CricketersRequest;
import com.testyantra.mongodb.response.CricketersResponse;

/**
 * @author sameer
 *
 */
@Service
public class CricketersServiceImpl {

	@Autowired
	CricketerRepo cricketerRepo;

	public CricketersResponse addCricketer(CricketersRequest cricketersRequest) {
		try {
			Cricketers cricketers = cricketersRequest.getCricketers();
			if (cricketers != null) {
				Cricketers save = cricketerRepo.save(cricketers);
				return CricketersResponse.builder().msg("Cricketer Data Added Success").cricketers(save).build();
			}
		} catch (Exception e) {
		}
		return CricketersResponse.builder().msg("Something Wrong").build();

	}

	public CricketersResponse deleteeCricketer(int cricketerId) {
		try {
			if (cricketerId != 0) {
				cricketerRepo.deleteById(cricketerId);
				return CricketersResponse.builder().msg("Cricketer Data Deleted Success").id(cricketerId).build();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return CricketersResponse.builder().msg("Something Wrong").build();

	}

	public CricketersResponse getCricketerById(int cricketerId) {
		try {
			if (cricketerId != 0) {
				Optional<Cricketers> findById = cricketerRepo.findById(cricketerId);
				return CricketersResponse.builder().msg("Cricketer Data Fetched Success").cricketers(findById.get())
						.build();
			}
		} catch (Exception e) {
		}
		return CricketersResponse.builder().msg("Invalid Id may be").build();

	}

	public CricketersResponse getAllCricketer() {
		try {
			List<Cricketers> findAll = cricketerRepo.findAll();
			if (!findAll.isEmpty()) {
				int size = findAll.size();
				return CricketersResponse.builder().msg("List Of Cricketer Data Fetched Success").list(findAll)
						.totalData(size).build();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return CricketersResponse.builder().msg("Something Wrong").build();

	}

	public CricketersResponse update(CricketersRequest cricketersRequest) {
		try {
			if (cricketersRequest != null) {

				Optional<Cricketers> findById = cricketerRepo.findById(cricketersRequest.getCricketers().getId());
				Cricketers cricketers2 = findById.get();

				cricketers2.setNickName(cricketersRequest.getCricketers().getNickName());
				cricketers2.setJourseyNo(cricketersRequest.getCricketers().getJourseyNo());
				Cricketers save = cricketerRepo.save(cricketers2);
				if (save != null) {
					return CricketersResponse.builder().msg("Data Updated").cricketers(cricketers2).build();
				}
			}
		} catch (

		Exception e) {
			e.printStackTrace();
		}
		return CricketersResponse.builder().msg("Something Wrong").build();

	}
}
