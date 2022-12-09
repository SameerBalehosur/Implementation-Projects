package com.testyantra.mongodb.request;

import com.testyantra.mongodb.model.Cricketers;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * @author sameer
 *
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CricketersRequest {
	private Cricketers cricketers;
}
