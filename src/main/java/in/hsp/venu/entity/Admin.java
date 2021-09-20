package in.hsp.venu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="admin_tab")
public class Admin {
	@Id
	@GeneratedValue
	@Column(name="admin_id_col")
	private Integer id;
	@Column(name="admin_code_col")
	private String code;
	@Column(name="admin_name_col")
	private String name;
	@Column(name="admin_note_col")
	private String note;

}
