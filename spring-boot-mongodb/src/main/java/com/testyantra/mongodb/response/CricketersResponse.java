package com.testyantra.mongodb.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
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
@JsonInclude(value = Include.NON_DEFAULT)
public class CricketersResponse {
private String msg;
private Cricketers cricketers;
private int id;
List<Cricketers> list;
private int totalData;
}
