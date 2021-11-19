/* create a sequence in the database before running the project
 * CREATE SEQUENCE JPA_SEQUENCE
 * START WITH 101
 * INCREMEMENT BY 1;
 */

package com.cg.jpastart.entities;



import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name="students")
public class Student implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(generator = "ST_SEQ", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "ST_SEQ", sequenceName = "JPA_SEQUENCE",allocationSize=1)
	
	private int studentId;
	@Column(length = 25)
	private String name;
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
