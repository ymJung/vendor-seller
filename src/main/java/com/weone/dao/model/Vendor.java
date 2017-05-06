/**
 * 
 */
package com.weone.dao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author YoungMin User information entity.
 */
@Entity
@Table(name = "vendor", schema = "vendor")
public class Vendor {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private long id;

}